package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getGroupsByStudentId(Long studentId);
}
