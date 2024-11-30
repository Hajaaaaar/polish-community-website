package com.example.workPage.service;

import com.example.workPage.model.WorkInformation;
import com.example.workPage.repository.WorkInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkInformationService {

    private final WorkInformationRepository workInformationRepository;

    public WorkInformationService(WorkInformationRepository workInformationRepository) {
        this.workInformationRepository = workInformationRepository;
    }

    public List<WorkInformation> getAllWorkInformation() {
        return workInformationRepository.findAll();
    }
}
