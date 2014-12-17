/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.entities.CommentEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
@Stateless
public class CommentEntityFacade extends AbstractFacade<CommentEntity> implements de.th.wildau.webapp.buchladen.facades.CommentEntityFacadeRemote {
    @EJB
    private RegisteredUserEntityFacadeRemote registeredUserEntityFacade;
    @EJB
    private BookEntityFacadeRemote bookEntityFacade;
    @PersistenceContext(unitName = "buchladen-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentEntityFacade() {
        super(CommentEntity.class);
    }

    @Override
    public List<CommentEntity> findByBookId(int id) {
        return em.createNamedQuery("CommentEntity.findByBookId").setParameter("bookId", id).getResultList();
    }

    @Override
    public void createBookComment(int bookId, String comment) {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        if(username != null) {
            RegisteredUserEntity registeredUserEntity = registeredUserEntityFacade.findByEmailAddress(username);
            BookEntity bookEntity = bookEntityFacade.find(bookId);
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setFkRegisteredUserId(registeredUserEntity);
            commentEntity.setFkBookId(bookEntity);
            commentEntity.setCommentText(comment);
            this.create(commentEntity);
        }
    }
    
}
