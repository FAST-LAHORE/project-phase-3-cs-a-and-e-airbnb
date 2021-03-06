/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class User implements Serializable {
    String name;
    String userId;
    String nationalId;
    String picture;
    String phone;
    
    String email;
    String password;
    String status = "ok";

    public User(String name, String userId, String nationalId, String picture, String phone, String email, String password) {
        this.name = name;
        this.userId = userId;
        this.nationalId = nationalId;
        this.picture = picture;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    
    // Active or Inactive
    public String getStatus()  {
        return this.status;
    }

    public User(String name, String userId, String nationalId, String picture) {
        this.name = name;
        this.userId = userId;
        this.nationalId = nationalId;
        this.picture = picture;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
}
