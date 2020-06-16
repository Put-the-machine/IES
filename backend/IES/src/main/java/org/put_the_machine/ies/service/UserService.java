package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Group;
import org.put_the_machine.ies.model.user.*;
import org.put_the_machine.ies.criteria.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(User user);

    User create(User user);

    User getById(Long userId);

    void deleteById(Long userId);

    List<User> findUsersByCriteria(UserCriteria criteria);

    List<Student> findStudentsByCriteria(StudentCriteria criteria);

    List<Teacher> findTeachersByCriteria(TeacherCriteria criteria);

    List<Administrator> findAdministratorsByCriteria(AdministratorCriteria criteria);

    List<Manager> findManagersByCriteria(ManagerCriteria criteria);

    void saveGroups(List<Group> groups);

    UserDetails loadUserByUsername(String s);

    User findUserByUsername(String name);
}


