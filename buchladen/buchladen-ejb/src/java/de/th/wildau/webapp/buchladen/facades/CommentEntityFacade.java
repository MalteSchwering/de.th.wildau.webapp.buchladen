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
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
@Stateless
public class CommentEntityFacade extends AbstractFacade<CommentEntity> implements de.th.wildau.webapp.buchladen.facades.CommentEntityFacadeRemote {
    
    /**
     * Enterprise Java Bean registeredUserEntityFacade mit einem Remote Interface.
     */
    @EJB
    private RegisteredUserEntityFacadeRemote registeredUserEntityFacade;
    
    /**
     * Enterprise Java Bean bookEntityFacade mit einem Remote Interface.
     */
    @EJB
    private BookEntityFacadeRemote bookEntityFacade;
    
    /**
     * Der Entitäten-Manager.
     */
    @PersistenceContext(unitName = "buchladen-ejbPU")
    private EntityManager em;

    /**
     * Liefert den Entitäten-Manager zurück.
     * @return Entitäten-Manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Konstruktor der den Konstruktor der abstrakten Klasse aufruft.
     */
    public CommentEntityFacade() {
        super(CommentEntity.class);
    }

    /**
     * Liefert eine Liste aller Kommentare zu einem Buch zurück.
     * @param id ID des Buches
     * @return Liste vom Typ CommentEntity
     */
    @Override
    public List<CommentEntity> findByBookId(int id) {
        return em.createNamedQuery("CommentEntity.findByBookId").setParameter("bookId", id).getResultList();
    }

    /**
     * Erstellt ein Kommentar zu einem Buch.
     * @param bookId ID des Buches
     * @param comment Text des Kommentares
     */
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
