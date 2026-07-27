package com.strikes.crudDtoDemo.dto;

public class StudentRequestDTO {
    private String name;
    private int age;
    private String email;
    private String subject;
    private int rolNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRolNo() {
        return rolNo;
    }

    public void setRolNo(int rolNo) {
        this.rolNo = rolNo;
    }
}
