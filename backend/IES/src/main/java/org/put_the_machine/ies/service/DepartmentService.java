package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.*;

import java.util.List;


public interface DepartmentService {
    void save(Department department);
    Department getById(Long id);
    void deleteById(Long id);

    List<Department> getDepartmentsByInstitute(Institute institute);
}