/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entitites.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author caiomartins
 */
@Stateless
public class ProductTypesBean {

    @PersistenceContext(unitName = "TP2PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Products> getProductTypes() {
        return (List<Products>) em.createNamedQuery("ProductTypes.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
