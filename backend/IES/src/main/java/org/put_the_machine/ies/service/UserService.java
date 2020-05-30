package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.user.*;
import org.put_the_machine.ies.criteria.*;

import java.util.List;

public interface UserService {
    User save(User user);

    User getById(Long userId);

    void deleteById(Long userId);

    List<User> findUsersByCriteria(UserCriteria criteria);

    List<Student> findStudentsByCriteria(StudentCriteria criteria);

    List<Teacher> findTeachersByCriteria(TeacherCriteria criteria);

    List<Administrator> findAdministratorsByCriteria(AdministratorCriteria criteria);

    List<Manager> findManagersByCriteria(ManagerCriteria criteria);
}


