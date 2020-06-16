package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Institute;

import java.util.List;


public interface InstituteService {
    Institute save(Institute institute);
    Institute getById(Long id);
    Institute update(Institute institute);
    void deleteById(Long id);

    List<Institute> getInstitutesWithFullDepartmentInfo();

    List<Institute> getAll();

}