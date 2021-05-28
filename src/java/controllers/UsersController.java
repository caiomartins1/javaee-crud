package controllers;


import beans.UsersBean;
import entitites.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

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
    

    public List<Users> getUserList() {
        userList = userBean.getUsers();
        return userList;
    }
    
 
    
}
