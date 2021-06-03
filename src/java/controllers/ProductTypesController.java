/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.ProductTypesBean;
import entitites.ProductTypes;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author caiomartins
 */
@Named(value = "ProductTypesController")
@RequestScoped
public class ProductTypesController {

    @EJB
    private ProductTypesBean productTypesBean;
    private List<ProductTypes> productTypesList = new ArrayList();
    
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
    
    
    
    public List<ProductTypes> getProductTypesList() {
        productTypesList = productTypesBean.getProductTypes();
        
        return productTypesList;
    } 
    
    public String deleteProduct(int id) {
        
        productTypesBean.deleteProduct(id);
        return "listProducts.xhtml";
    }
    
    public String updateProduct(int id) {
        List<ProductTypes> p = productTypesBean.getProductTypeById(id);
        p.get(0).setTypeName(typeName);
        p.get(0).setPrice(price);
        p.get(0).setStock(stock);
        p.get(0).setMinStock(minStock);
        
        productTypesBean.updateProduct(p.get(0));
        
        return "listProducts.xhtml";
    }
    
}
