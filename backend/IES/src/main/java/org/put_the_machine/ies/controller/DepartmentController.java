package org.put_the_machine.ies.controller;

import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    @Autowired
    DepartmentService service;

    @PostMapping("save")
    public void save(@RequestBody Department department) {
        service.save(department);
    }

    @GetMapping("get")
    public Department getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("delete")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("get_by_institute")
    public List<Department> getByInstitute(@PathVariable Institute institute) {
        return service.getDepartmentsByInstitute(institute);
    }
}
