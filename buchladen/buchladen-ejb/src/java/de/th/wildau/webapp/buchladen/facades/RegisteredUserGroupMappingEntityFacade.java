/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserGroupMappingEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
@Stateless
public class RegisteredUserGroupMappingEntityFacade extends AbstractFacade<RegisteredUserGroupMappingEntity> implements de.th.wildau.webapp.buchladen.facades.RegisteredUserGroupMappingEntityFacadeRemote {
    @PersistenceContext(unitName = "buchladen-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegisteredUserGroupMappingEntityFacade() {
        super(RegisteredUserGroupMappingEntity.class);
    }
    
}
