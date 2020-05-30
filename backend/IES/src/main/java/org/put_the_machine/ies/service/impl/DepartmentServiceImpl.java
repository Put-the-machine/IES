package org.put_the_machine.ies.service.impl;

import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.repository.DepartmentRepository;
import org.put_the_machine.ies.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository repo;

    @Override
    public void save(Department department) {
        repo.save(department);
    }

    @Override
    public Department getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Department> getDepartmentsByInstitute(Institute institute) {
        return repo.findAllByInstitute(institute);
    }
}
