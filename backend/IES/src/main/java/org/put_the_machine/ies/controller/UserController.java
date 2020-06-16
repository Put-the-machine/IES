package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.criteria.*;
import org.put_the_machine.ies.model.user.*;
import org.put_the_machine.ies.service.FileContentToStudentsService;
import org.put_the_machine.ies.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final FileContentToStudentsService fileContentToStudentsService;

    @GetMapping("who-am-i")
    User whoAmI(@AuthenticationPrincipal Principal principal){
        return userService.findUserByUsername(principal.getName());
    }

    @GetMapping("users/{userId}")
    User getById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @GetMapping("users")
    List<User> userList(@ModelAttribute UserCriteria criteria) {
        return userService.findUsersByCriteria(criteria);
    }

    @GetMapping("students")
    List<Student> studentList(@ModelAttribute StudentCriteria criteria) {
        return userService.findStudentsByCriteria(criteria);
    }

    @GetMapping("managers")
    List<Manager> managerList(@RequestParam ManagerCriteria criteria) {
        return userService.findManagersByCriteria(criteria);
    }

    @GetMapping("teachers")
    List<Teacher> teacherList(@RequestParam TeacherCriteria criteria) {
        return userService.findTeachersByCriteria(criteria);
    }

    @GetMapping("administrators")
    List<Administrator> administratorList(@RequestParam AdministratorCriteria criteria) {
        return userService.findAdministratorsByCriteria(criteria);
    }

}
