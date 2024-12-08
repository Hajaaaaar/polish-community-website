package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EventRepository {
    private final JdbcTemplate jdbcTemplate;

    public EventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // RowMapper to map database rows to Event objects
    private final RowMapper<Event> rowMapper = new RowMapper<Event>() {
        @Override
        public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
            Event event = new Event();
            event.setId(rs.getInt("id"));
            event.setTitle(rs.getString("title"));
            event.setDate(rs.getString("date"));
            event.setLocation(rs.getString("location"));
            event.setCategory(rs.getString("category"));
            event.setDescription(rs.getString("description"));
            event.setImageUrl(rs.getString("image_url"));
            return event;
        }
    };

    // Fetch all events from the database
    public List<Event> getAllEvents() {
        String sql = "SELECT * FROM eventss";
        return jdbcTemplate.query(sql, rowMapper);
    }


    // Add a new event to the database
    public void addEvent(Event event) {
        String sql = "INSERT INTO eventss (title, date, location, category, description, image_url) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, event.getTitle(), event.getDate(), event.getLocation(), event.getCategory(), event.getDescription(), event.getImageUrl());
    }
}
