package com.workpage.repository;

import com.yourpackage.model.WorkInformation;
import java.util.List;

public interface WorkInformationRepository {
    void save(WorkInformation workInfo);  // Save a new work info record
    List<WorkInformation> getAll();      // Fetch all work records
}