/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entitites.ProductTypes;
import java.math.BigInteger;
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
    
    public List<ProductTypes> getProductTypes() {
        return (List<ProductTypes>) em.createNamedQuery("ProductTypes.findAll").getResultList();
    }
    
    public List<ProductTypes> getProductTypeById(int id) {
        return (List<ProductTypes>) em.createNamedQuery("ProductTypes.findById").setParameter("id", id).getResultList();
    }
    
    public void updateSoldItem(int productTypeID) {
        List<ProductTypes> p = getProductTypeById(productTypeID);
        em.createNamedQuery("ProductTypes.sellItem").setParameter("id", 1).setParameter("newstock", p.get(0).getStock() - 1).executeUpdate();
    }
    
    public ProductTypes addProcutType(ProductTypes p) {
        em.persist(p);
        return p;
    }
        
   

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
