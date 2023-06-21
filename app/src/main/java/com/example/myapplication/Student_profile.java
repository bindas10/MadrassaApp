package com.example.myapplication;

public class Student_profile {

    private String id;
    private   String name;
    private String student_class;
    private String Age;

    public Student_profile(String id, String name, String student_class, String age) {
        this.id = id;
        this.name = name;
        this.student_class = student_class;
        Age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
}
