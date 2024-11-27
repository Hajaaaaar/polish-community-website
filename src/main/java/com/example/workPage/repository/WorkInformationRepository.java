package com.example.workPage.repository;

import com.example.workPage.model.WorkInformation;
import java.util.List;

public interface WorkInformationRepository {
    void save(WorkInformation workInfo);  // Save a new work info record
    List<WorkInformation> getAll();      // Fetch all work records
}

