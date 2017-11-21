package com.zenika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final StoryRepository storyRepository;

    @Autowired
    public PublicationServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void publish(Story story) {
        storyRepository.save(story);
    }

    public List<Story> getAll() {
        return storyRepository.findAll();
    }
}
