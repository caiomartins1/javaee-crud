/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.ProductTypesBean;
import beans.TransactionsBean;
import entitites.ProductTypes;
import entitites.TransactionsFinal;
import java.math.BigInteger;
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
@Named (value = "TransactionsController")
@RequestScoped
public class TransactionsController {

    @EJB
    private ProductTypesBean productTypesBean;

    @EJB
    private TransactionsBean transactionsBean;
    
    TransactionsFinal transaction = new TransactionsFinal();
    
    List<TransactionsFinal> userTransactionList = new ArrayList<>();
    
    String typeName;
    BigInteger price; 
    int stock; 
    int minStock;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }
    
    
    public List<TransactionsFinal> getUserTransactionList(int userID) {
        userTransactionList = transactionsBean.getUserTransactionList(userID);
        
        return userTransactionList;
    }

    public String buyProduct(int soldItemID, BigInteger transactionCost, String productType, int userID) {
             
        List<ProductTypes> p = (List<ProductTypes>) productTypesBean.getProductTypeById(soldItemID);
        
       if (p.size() < 1) {
           return "error.xhtml";
       }
       
       if (p.get(0).getStock() <= 0) {
           return "error.xhtml";
       }
        
        transaction.setCost(transactionCost);
        transaction.setProductType(productType);
        transaction.setBoughtAt(new Date());
        transaction.setBuyerId(userID);
        transactionsBean.registerTransaction(transaction);
        
        productTypesBean.updateSoldItem(soldItemID);
        
    
        return "listProducts.xhtml";
    }
    
    public String addProduct() {
    
        ProductTypes p = new ProductTypes();
        p.setAddedAt(new Date());
        p.setTypeName(typeName);
        p.setPrice(price);
        p.setStock(stock);
        p.setMinStock(minStock);
        
        productTypesBean.addProcutType(p);
        return "listProducts";
    }
}
