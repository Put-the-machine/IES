package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.repository.DepartmentRepository;
import org.put_the_machine.ies.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repo;

    @Override
    public Department save(Department department) {
        return repo.save(department);
    }

    @Override
    public Department update(Department department) {
        return repo.save(department);
    }


    @Override
    public Department getById(Long departmentId) {
        return repo.findById(departmentId)
                .orElseThrow(() -> new NoSuchElementException("Department not found by id: " + departmentId));
    }

    @Override
    public void deleteById(Long departmentId) {
        repo.deleteById(departmentId);
    }

    @Override
    public List<Department> getDepartmentsByInstituteId(Long instituteId) {
        return repo.findAllByInstituteId(instituteId);
    }
}
