package com.zenika;

import java.util.List;

public interface StoryRepository {
    void save(Story story);

    List<Story> findAll();
}
