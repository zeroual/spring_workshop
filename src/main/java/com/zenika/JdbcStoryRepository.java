package com.zenika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("prod")
public class JdbcStoryRepository implements StoryRepository {

    private final Connection connection;

    @Autowired
    public JdbcStoryRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Story story) {

        try {

            Statement statement = connection.createStatement();
            String query = "INSERT INTO stories (text) VALUES('" + story.getText() + "')";
            statement.execute(query);
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Story> findAll() {
        ArrayList<Story> stories = new ArrayList<Story>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM stories";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Story story = new Story(resultSet.getString("text"));
                stories.add(story);
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stories;
    }
}
