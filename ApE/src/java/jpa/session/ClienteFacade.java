/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Cliente;

/**
 *
 * @author verito
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
    @PersistenceContext(unitName = "ApEPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public boolean ClienteLogin(Cliente cliente) {
        List lista = em.createNamedQuery("Cliente.findByLogin")
                .setParameter("email", cliente.getEmail())
                .setParameter("clave", cliente.getClave())
                .getResultList();
        if(lista.size() > 0)
            return true;
        return false;
    }
    
}
