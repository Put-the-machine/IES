package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User getById(Long userId);

    User update(User user);

    void deleteById(Long userId);

    List<User> getAllUsers();

    // todo: filtering methods
}


