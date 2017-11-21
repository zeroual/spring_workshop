package com.zenika;

public class Story {
    private String text;

    public Story(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Story{" +
                "text='" + text + '\'' +
                '}';
    }
}
