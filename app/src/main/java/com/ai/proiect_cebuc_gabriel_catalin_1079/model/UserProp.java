package com.ai.proiect_cebuc_gabriel_catalin_1079.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class UserProp implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String userName;
    private String email;
    private String password;
    private String tipChirias2;

    public UserProp(String userName, String email, String password, String tipChirias2) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.tipChirias2 = tipChirias2;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipChirias2() {
        return tipChirias2;
    }

    public void setTipChirias2(String tipChirias2) {
        this.tipChirias2 = tipChirias2;
    }

    @Override
    public String toString() {
        return "UserProp{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipChirias2='" + tipChirias2 + '\'' +
                '}';
    }
}
