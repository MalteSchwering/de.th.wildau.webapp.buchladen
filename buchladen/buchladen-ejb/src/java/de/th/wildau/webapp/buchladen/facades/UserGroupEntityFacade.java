/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

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
public class UserGroupEntityFacade extends AbstractFacade<UserGroupEntity> implements de.th.wildau.webapp.buchladen.facades.UserGroupEntityFacadeRemote {
    @PersistenceContext(unitName = "buchladen-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserGroupEntityFacade() {
        super(UserGroupEntity.class);
    }

    @Override
    public UserGroupEntity findByGroupName(String groupName) {
        try {
            Query query = em.createNamedQuery("UserGroupEntity.findByGroupName");
            return (UserGroupEntity) query.setParameter("groupName", groupName).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
