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
public class Admin  extends User implements Serializable {

    public Admin(String name, String userId, String nationalId, String picture) {
        super(name, userId, nationalId, picture);
    }
    Boolean reviewReport(Report r){
        throw new UnsupportedOperationException();
    }
    Boolean DeleteReport(Report r){
        throw new UnsupportedOperationException();
    }
    Boolean banUser(User u){
        throw new UnsupportedOperationException();
    }

    public Admin(String name, String userId, String nationalId, String picture, String phone, String email, String password) {
        super(name, userId, nationalId, picture, phone, email, password);
    }
        
}
