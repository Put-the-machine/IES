package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.user.*;
import org.put_the_machine.ies.repository.user.*;
import org.put_the_machine.ies.service.UserService;
import org.put_the_machine.ies.specification.*;
import org.put_the_machine.ies.criteria.*;
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

    @Override
    public User save(User user) {
        return userRepository.save(user);
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

}
