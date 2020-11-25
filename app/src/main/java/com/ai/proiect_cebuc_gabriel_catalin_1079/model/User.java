package com.ai.proiect_cebuc_gabriel_catalin_1079.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String userName;
    private String password;
    private String email;
    private String tipChirias1;

    public User(String userName, String email, String password, String tipChirias1) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.tipChirias1 = tipChirias1;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipChirias1() {
        return tipChirias1;
    }

    public void setTipChirias1(String tipChirias1) {
        this.tipChirias1 = tipChirias1;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", tipChirias1='" + tipChirias1 + '\'' +
                '}';
    }
}
