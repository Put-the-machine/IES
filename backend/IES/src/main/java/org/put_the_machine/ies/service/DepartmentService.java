package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.*;

import java.util.List;


public interface DepartmentService {
    Department save(Department department);

    Department update(Department department);

    Department getById(Long id);
    void deleteById(Long id);


    List<Department> getDepartmentsByInstituteId(Long instituteId);
}