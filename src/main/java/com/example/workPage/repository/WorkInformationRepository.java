package com.example.workPage.repository;

import com.example.workPage.model.WorkInformation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class WorkInformationRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<WorkInformation> workInfoRowMapper = new RowMapper<>() {
        @Override
        public WorkInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new WorkInformation(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("resourceLink")
            );
        }
    };

    public WorkInformationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<WorkInformation> findAll() {
        String sql = "SELECT id, title, description, resourceLink FROM WorkInformation";
        return jdbcTemplate.query(sql, workInfoRowMapper);
    }
}





