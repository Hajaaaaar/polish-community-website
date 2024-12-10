package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.Safety;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SafetyRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Safety> safetyRowMapper = new RowMapper<>() {
        @Override
        public Safety mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Safety(
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("link"),
                    rs.getString("phone")
            );
        }
    };

    public SafetyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Safety> findAll() {
        String sql = "SELECT name, description, link, phone FROM Safety";
        return jdbcTemplate.query(sql, safetyRowMapper);
    }
}