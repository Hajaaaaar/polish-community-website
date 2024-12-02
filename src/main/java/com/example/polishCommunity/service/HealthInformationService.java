package com.example.polishCommunity.service;

import com.example.polishCommunity.repository.HealthInformationRepository;
import com.example.polishCommunity.model.HealthInformation;
import org.springframework.stereotype.Service;

@Service
public class HealthInformationService {
    private final HealthInformationRepository healthInformationRepository;
    public HealthInformationService(HealthInformationRepository healthInformationRepository){
        this.healthInformationRepository = healthInformationRepository;
    }
    public void saveHealthInformation(HealthInformation healthInformation){
        healthInformationRepository.saveHealthInformation(healthInformation);
    }
}
