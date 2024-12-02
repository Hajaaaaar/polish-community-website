package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.HealthInformation;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class HealthInformationRepository {
    private final DataSource dataSource;
    public HealthInformationRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }



    public void saveHealthInformation(HealthInformation healthInformation) {
        String sql = "INSERT INTO healthtable (name, email, location, q1registered, q2queries) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, healthInformation.getName());
            statement.setString(2, healthInformation.getEmail());
            statement.setString(3, healthInformation.getLocation());
            statement.setBoolean(4, healthInformation.isQ1registered());
            statement.setString(5, healthInformation.getQ2queries());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving health information: " + e.getMessage());
        }
    }
}