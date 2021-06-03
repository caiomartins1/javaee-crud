/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entitites.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author caiomartins
 */
@Stateless
public class UsersBean {

    @PersistenceContext(unitName = "TP2PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Users> getUsers () {
        return (List<Users>) em.createNamedQuery("Users.findAll").getResultList();
    }
    
    public Users registerUser(Users user) {
        em.persist(user);
        return user;
    }
    
    public List<Users> findUserByUsername(String username) {
        List<Users> u = (List<Users>) em.createNamedQuery("Users.findByUsername").setParameter("username", username).getResultList();
        return u;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
