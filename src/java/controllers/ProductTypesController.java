/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.ProductTypesBean;
import entitites.ProductTypes;
import entitites.Products;
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
    
    public List<ProductTypes> getProductTypesList() {
        productTypesList = productTypesBean.getProductTypes();
        
        return productTypesList;
    } 
    
}
