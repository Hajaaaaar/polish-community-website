package com.workpage.repository;

import com.yourpackage.model.WorkInformation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkInformationRepositoryJDBC implements WorkInformationRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<WorkInformation> workInfoMapper;

    public WorkInformationRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.workInfoMapper = (rs, rowNum) -> new WorkInformation(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("resource_link")
        );
    }

    @Override
    public void save(WorkInformation workInfo) {
        String sql = "INSERT INTO work_information (title, description, resource_link) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, workInfo.getTitle(), workInfo.getDescription(), workInfo.getResourceLink());
    }

    @Override
    public List<WorkInformation> getAll() {
        String sql = "SELECT * FROM work_information";
        return jdbcTemplate.query(sql, workInfoMapper);
    }
}