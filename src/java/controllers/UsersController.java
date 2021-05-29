package controllers;


import beans.UsersBean;
import entitites.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.security.enterprise.identitystore.*;
// hashing passwords https://javaee.github.io/security-api/apidocs/javax/security/enterprise/identitystore/PasswordHash.html

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caiomartins
 */
@Named (value = "UsersController")
@RequestScoped
public class UsersController {
    
    @EJB
    private UsersBean userBean;
    List<Users> userList = new ArrayList<>();
    
    private int abc;
    

    public List<Users> getUserList() {
        userList = userBean.getUsers();
        
        return userList;
    }
    
    public int getAbc() {
        abc = 20;
        return abc;
    }
    
 
    
}
