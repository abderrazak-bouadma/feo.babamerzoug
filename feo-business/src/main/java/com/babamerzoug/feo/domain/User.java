package com.babamerzoug.feo.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/29/13
 * Time: 5:11 PM
 */
public class User {

    @Id
    private String id;
    private int reputation;
    private String displayName;
    private String email;
    private String realName;
    private String location;
    private Date birthday;
    private String aboutme;

    public User() {
    }

    public User(String displayName, String email) {
        this.displayName = displayName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", reputation=" + reputation +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                ", birthday=" + birthday +
                ", aboutme='" + aboutme + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }
}
