package com.zenika;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class InMemoryStoryRepository implements StoryRepository {

    private List<Story> db = new ArrayList<Story>();

    public void save(Story story) {
        db.add(story);
    }

    public List<Story> findAll() {
        return db;
    }
}
