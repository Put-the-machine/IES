package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.text.RandomStringGenerator;
import org.put_the_machine.ies.criteria.*;
import org.put_the_machine.ies.model.EmailMessage;
import org.put_the_machine.ies.model.Group;
import org.put_the_machine.ies.model.user.*;
import org.put_the_machine.ies.repository.GroupRepository;
import org.put_the_machine.ies.repository.user.*;
import org.put_the_machine.ies.service.NotificationEmailMessageService;
import org.put_the_machine.ies.service.UserService;
import org.put_the_machine.ies.specification.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final ManagerRepository managerRepository;
    private final AdministratorRepository administratorRepository;
    private final TeacherRepository teacherRepository;

    private final GroupRepository groupRepository;

    private final PasswordEncoder passwordEncoder;
    private final RandomStringGenerator passwordGenerator;

    private final NotificationEmailMessageService notificationEmailMessageService;


    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @SneakyThrows
    @Override
    public User create(User user) {
        val notification = EmailMessage.builder()
                .from("IES")
                .title("Вы зарегестрированы в IES")
                .text("Пароль: " + user.getPassword())
                .receiver(user.getEmail())
                .build();
        notificationEmailMessageService.sendNotificationMessage(notification);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found by id: " + userId));
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> findUsersByCriteria(UserCriteria criteria) {
        return userRepository.findAll(new UserSpecification(criteria));
    }

    @Override
    public List<Student> findStudentsByCriteria(StudentCriteria criteria) {
        return studentRepository.findAll(new StudentSpecification(criteria));
    }

    @Override
    public List<Teacher> findTeachersByCriteria(TeacherCriteria criteria) {
        return teacherRepository.findAll(new TeacherSpecification(criteria));
    }

    @Override
    public List<Administrator> findAdministratorsByCriteria(AdministratorCriteria criteria) {
        return administratorRepository.findAll(new AdministratorSpecification(criteria));
    }

    @Override
    public List<Manager> findManagersByCriteria(ManagerCriteria criteria) {
        return managerRepository.findAll(new ManagerSpecification(criteria));
    }

    @Override
    public void saveGroups(List<Group> groups) {
        groups.forEach(group ->
                group.getStudents().forEach(student -> {
                    student.setPassword(passwordGenerator.generate(7));
                    val emailMessage = EmailMessage.builder()
                            .from("IES")
                            .receiver(student.getEmail())
                            .title("Вы зарегестрированы в IES.")
                            .text("Ваш пароль: " + student.getPassword())
                            .build();
                    notificationEmailMessageService.sendNotificationMessage(emailMessage);
                    student.setPassword(passwordEncoder.encode(student.getPassword()));
                }));
        groupRepository.saveAll(groups);
    }

    @Override
    public UserDetails loadUserByUsername(String s) {
        return userRepository.findByUsername(s);
    }

}
