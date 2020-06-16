package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.Institute;
import org.put_the_machine.ies.service.InstituteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstituteController {
    private final InstituteService instituteService;

    @PostMapping("institutes")
    public Institute save(Institute institute) {
        return instituteService.save(institute);
    }

    @PutMapping("institutes")
    public Institute update(Institute institute) {
        return instituteService.update(institute);
    }

    @GetMapping("institutes/{instituteId}")
    public Institute getById(@PathVariable Long instituteId) {
        return instituteService.getById(instituteId);
    }

    @DeleteMapping("institutes/{instituteId}")
    public void deleteById(@PathVariable Long instituteId) {
        instituteService.deleteById(instituteId);
    }

    @GetMapping("institutes/full_department_info")
    public List<Institute> getInstitutesWithFullDepartmentInfo() {
        return instituteService.getInstitutesWithFullDepartmentInfo();
    }

    @GetMapping("institutes")
    public List<Institute> getAll() {
        return instituteService.getAll();
    }
}
