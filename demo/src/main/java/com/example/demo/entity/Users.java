package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

//To use the @Data annotation you should add the Lombok dependency.
@Data
@Entity
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 291353626011036772L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthDate")
    private Date birthDate;

    @JsonBackReference
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Medical_Records> medicalListRecords;

    public List<Medical_Records> getMedicalListRecords() {
        return medicalListRecords;
    }

    public void setMedicalListRecords(List<Medical_Records> medicalListRecords) {
        this.medicalListRecords = medicalListRecords;
    }

    public List<Medical_Records> getMedicalList() {
        return medicalListRecords;
    }

    public Users() {
    }

    public Users(Long id, String firstname, String lastname, Date birthDate, List<Medical_Records> medicalListRecords) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.medicalListRecords = medicalListRecords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Users [birthDate=" + birthDate + ", firstname=" + firstname + ", id=" + id + ", lastname=" + lastname
                + ", medicalListRecords=" + medicalListRecords + "]";
    }

}