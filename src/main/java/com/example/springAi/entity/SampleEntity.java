package com.example.springAi.entity;


public class SampleEntity {

    private String title;
    private String Description;
    private String createdDate;

    public SampleEntity() { }

    public SampleEntity(String title, String createdDate, String description) {
        this.title = title;
        this.createdDate = createdDate;
        Description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
