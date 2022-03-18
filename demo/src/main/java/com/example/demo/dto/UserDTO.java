package com.example.demo.dto;
import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {

    Long id;
    String firstname, lastname;
    Date birthdate;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstname, String lastname, Date birthdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "UserDTO [birthdate=" + birthdate + ", firstname=" + firstname + ", id=" + id + ", lastname=" + lastname
                + "]";
    }

}
