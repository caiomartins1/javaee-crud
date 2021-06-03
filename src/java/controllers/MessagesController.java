/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.MessagesBean;
import beans.ProductTypesBean;
import entitites.Messages;
import entitites.ProductTypes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author caiomartins
 */
@Named(value = "MessagesController")
@RequestScoped
public class MessagesController {

    @EJB
    private ProductTypesBean productTypesBean;

    @EJB
    private MessagesBean messagesBean;
    private List<Messages> messagesList = new ArrayList();
    
    
    
    public List<Messages> getMessagesList() {
        messagesList = messagesBean.getMessagesList();
        return messagesList;
    }
    
    public String generateMessages() {
        Messages m = new Messages();
        List<ProductTypes> productTypesList = productTypesBean.getProductTypes();
        
        for (ProductTypes p: productTypesList) {
            if (p.getStock() < p.getMinStock()) {
                m.setMessage("Product: " + p.getTypeName() + " is below minimum stock!" );
                m.setReveivedAt(new Date());
                messagesBean.createMessage(m);     
            }
        }
        
        return "listMessages";
    }
  
}
