package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.put_the_machine.ies.model.CourseProfile;
import org.put_the_machine.ies.model.Group;
import org.put_the_machine.ies.service.FileContentToStudentsService;
import org.put_the_machine.ies.service.GroupService;
import org.put_the_machine.ies.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GroupController {
    private final UserService userService;
    private final FileContentToStudentsService fileContentToStudentsService;
    private final GroupService groupService;


    @PostMapping("course-profiles/{courseProfile}/groups")
    @PreAuthorize("hasAuthority('MANAGER')")
    public void createGroup(
            @PathVariable("courseProfile") CourseProfile courseProfile,
            @ModelAttribute("file") MultipartFile file
    ) {
        val groups = fileContentToStudentsService.parseExcelFile(file);
        groups.forEach(group -> group.setCourseProfile(courseProfile));
        userService.saveGroups(groups);
    }

    @GetMapping("students/{studentId}/groups")
    public List<Group> getGroupsByStudentId(@PathVariable Long studentId) {
        return groupService.getGroupsByStudentId(studentId);
    }

}
