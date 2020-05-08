package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);
    Department getById(Long id);
    Department update(Department department);
    void deleteById(Long id);
	
    List<Department> getDepartments();
    List<Department> getDepartmentsByInstituteId(Long instituteId);
}