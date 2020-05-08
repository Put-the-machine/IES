package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Institute;

import java.util.List;

public interface InstituteService {
    Institute saveInstitute(Institute institute);
    Institute getInstituteById(Long id);
    Institute updateInstitute(Institute institute);
    void deleteInstituteById(Long id);

    List<Institute> getInstitutes();
}