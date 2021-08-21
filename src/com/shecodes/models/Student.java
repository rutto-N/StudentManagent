package com.shecodes.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student  {
    String registrationNumber;
    String name;
    Date dateOfBirth;
    Date dateOfAdmission;
    String course;
    Gender gender;

    public Student(String registrationNumber, String name) {
        this.registrationNumber = registrationNumber;
        this.name = name;
    }

    public Student(String registrationNumber, String name, Date dateOfBirth, Date dateOfAdmission, String course,
                   Gender gender) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAdmission = dateOfAdmission;
        this.course = course;
        this.gender = gender;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "" +
                registrationNumber +
                "," + name +
                "," + new SimpleDateFormat("dd/MM/yyyy").format(dateOfBirth) +
                "," + new SimpleDateFormat("dd/MM/yyyy").format(dateOfAdmission) +
                "," + course +
                "," + gender +
                '\n';
    }



}
