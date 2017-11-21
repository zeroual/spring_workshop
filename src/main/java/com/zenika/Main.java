package com.zenika;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "prod");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PublicationService publicationService = context.getBean(PublicationService.class);

        Story hello = new Story("Hi");
        //WHEN
        publicationService.publish(hello);
        //THEN
        List<Story> feed = publicationService.getAll();
        System.out.println(feed);
    }
}
