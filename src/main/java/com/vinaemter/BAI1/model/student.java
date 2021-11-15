package com.vinaemter.BAI1.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class student {
    private int id;
    private String place;
    private Date date_create;
    private int student;
    private String img;
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public student(int id, String place, Date date_create, int student) {
        this.id = id;
        this.place = place;
        this.date_create = date_create;
        this.student = student;
    }

    public student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }
}
