/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entitites.TransactionsFinal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author caiomartins
 */
@Stateless
public class TransactionsBean {

    @PersistenceContext(unitName = "TP2PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public TransactionsFinal registerTransaction(TransactionsFinal t) {
        em.persist(t);
        return t;
    }
    
    public List<TransactionsFinal> getUserTransactionList(int userID) {
        List<TransactionsFinal> transactionList = (List<TransactionsFinal>) em.createNamedQuery("TransactionsFinal.findByBuyerId")
                .setParameter("buyerId", userID).getResultList();
        
        return transactionList;
    }

//    public void updateSellStock() {
//        em.createNamedQuery("")
//    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
