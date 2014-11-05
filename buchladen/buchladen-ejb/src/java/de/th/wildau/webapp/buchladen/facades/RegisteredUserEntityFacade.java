/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import de.th.wildau.webapp.buchladen.entities.UserGroupEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jan
 */
@Stateless
public class RegisteredUserEntityFacade extends AbstractFacade<RegisteredUserEntity> implements de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote {
    @PersistenceContext(unitName = "buchladen-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegisteredUserEntityFacade() {
        super(RegisteredUserEntity.class);
    }

    @Override
    public RegisteredUserEntity findByEmailAddress(String emailAddress) {
        try {
            Query query = em.createNamedQuery("RegisteredUserEntity.findByEmailAddress");
            return (RegisteredUserEntity) query.setParameter("emailAddress", emailAddress).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
