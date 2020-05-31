package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService service;

    @PostMapping("departments")
    public Department save(@ModelAttribute Department department) {
        return service.save(department);
    }

    @PutMapping("departments")
    public Department update(@ModelAttribute Department department) {
        return service.update(department);
    }

    @GetMapping("departments/{departmentId}")
    public Department getById(@PathVariable Long departmentId) {
        return service.getById(departmentId);
    }

    @DeleteMapping("delete/{departmentId}")
    public void deleteById(@PathVariable Long departmentId) {
        service.deleteById(departmentId);
    }

    @GetMapping("institutes/{instituteId}/departments")
    public List<Department> getByInstitute(@PathVariable Long instituteId) {
        return service.getDepartmentsByInstituteId(instituteId);
    }
}
