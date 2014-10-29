/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.CommentEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
@Stateless
public class CommentEntityFacade extends AbstractFacade<CommentEntity> implements de.th.wildau.webapp.buchladen.facades.CommentEntityFacadeRemote {
    @PersistenceContext(unitName = "buchladen-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentEntityFacade() {
        super(CommentEntity.class);
    }
    
}
