package controllers;


import beans.LoginBean;
import beans.UsersBean;
import entitites.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import pt.ubi.di.security.model.PBKDF2;
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
    private LoginBean loginBean;
    
    @EJB
    private UsersBean userBean;
    
    List<Users> userList = new ArrayList<>();
    Users user = new Users();
    String username;
    String passwordHash;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = PBKDF2.hashPassword("SHA512", passwordHash, 1000, 512);
    }
    
    
    public Users getUser() {
        return user;
    }
    
    public void setUser(Users user) {
        this.user = user;
    }
    
    public List<Users> getUserList() {
        userList = userBean.getUsers();
        
        return userList;
    }
    
    public String registerUser() {
        List<Users> userAlreadyExists = userBean.findUserByUsername(username);
        
        if (userAlreadyExists.size() > 0) {
            return "error.xhtml";
        }  
        
        user.setIsAdmin(false);
        user.setPasswordHash(passwordHash);
        user.setUsername(username);
        userBean.registerUser(user);
        return "index.xhtml";
    }
    
    public String authenticateUser() {
        if (!validCredentials(this.username, this.passwordHash)) {
            return "error.xhtml";
        }
        
        List<Users> userList = userBean.findUserByUsername(username);
        Users user = userList.get(0);
        
        this.loginBean.setIsAdmin(user.getIsAdmin());
        this.loginBean.setUserID(user.getId());
        this.loginBean.setUsername(username);
        
        return "index.xhtml";
    }
    
    private boolean validCredentials(String username, String passwordHash) {
        List<Users> userList = userBean.findUserByUsername(username);
        
        if (userList.size() < 1) {
            return false;
        }
        
        return userList.get(0).getUsername().equals(username) &&  userList.get(0).getPasswordHash().equals(passwordHash);
 
    }
    
    public String logoutUser() {
        this.loginBean.setIsAdmin(false);
        this.loginBean.setUserID(-1);
        this.loginBean.setUsername("");
        return "index.xhtml";
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

}
