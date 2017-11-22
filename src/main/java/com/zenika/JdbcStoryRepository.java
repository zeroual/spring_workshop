package com.zenika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class JdbcStoryRepository implements StoryRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcStoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Story story) {
        String query = "INSERT INTO stories (text) VALUES(?)";
        jdbcTemplate.update(query, story.getText());

    }

    public List<Story> findAll() {
        String query = "SELECT * FROM stories";
        return jdbcTemplate.query(query, mapToStory());

    }

    private RowMapper<Story> mapToStory() {
        return (rs, rowNum) -> new Story(rs.getString("text"));
    }
}
