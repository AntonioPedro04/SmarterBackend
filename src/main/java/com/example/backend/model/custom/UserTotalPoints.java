package com.example.backend.model.custom;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

public class UserTotalPoints implements IUserTotalPoints {

    private Long position;
    private String userName;
    private String firstName;
    private String lastName;
    private String country;
    private Long points;

    public UserTotalPoints(Long position, String userName, String firstName, String lastName, String country, Long points){
        this.position = position;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.points = points;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}
