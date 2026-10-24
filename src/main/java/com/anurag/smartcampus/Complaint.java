package com.anurag.smartcampus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String rollNumber;
    private String category;
    private String description;
    private String status;

    public Complaint() {
    }

    public Complaint(String studentName, String rollNumber, String category, String description, String status) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.category = category;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
