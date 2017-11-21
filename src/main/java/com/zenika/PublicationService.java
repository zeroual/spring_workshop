package com.zenika;

import java.util.List;

public interface PublicationService {
    void publish(Story story);

    List<Story> getAll();
}
