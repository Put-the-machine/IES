package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.Institute;
import org.put_the_machine.ies.repository.InstituteRepository;
import org.put_the_machine.ies.service.InstituteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class InstituteServiceImpl implements InstituteService {
    private final InstituteRepository instituteRepository;

    @Override
    public Institute save(Institute institute) {
        return instituteRepository.save(institute);
    }

    @Override
    public Institute getById(Long id) {
        return instituteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no institute with id = " + id));
    }

    @Override
    public Institute update(Institute institute) {
        return instituteRepository.save(institute);
    }

    @Override
    public void deleteById(Long id) {
        instituteRepository.deleteById(id);
    }

    @Override
    public List<Institute> getInstitutesWithFullDepartmentInfo() {
        return instituteRepository.findAllWithFullInfoAboutDepartments();
    }
}
