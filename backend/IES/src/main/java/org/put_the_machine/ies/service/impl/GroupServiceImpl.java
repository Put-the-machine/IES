package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.Group;
import org.put_the_machine.ies.repository.GroupRepository;
import org.put_the_machine.ies.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public List<Group> getGroupsByStudentId(Long studentId) {
        return groupRepository.findAllByStudentId(studentId);
    }
}
