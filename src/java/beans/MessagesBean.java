/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entitites.Messages;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author caiomartins
 */
@Stateless
public class MessagesBean {

    @PersistenceContext(unitName = "TP2PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Messages> getMessagesList() {
        return (List<Messages>) em.createNamedQuery("Messages.findAll").getResultList();
    }
    
    public Messages createMessage(Messages m) {
        em.persist(m);
        return m;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
