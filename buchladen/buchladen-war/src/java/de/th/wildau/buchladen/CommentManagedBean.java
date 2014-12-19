package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.CommentEntity;
import de.th.wildau.webapp.buchladen.facades.CommentEntityFacadeRemote;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class CommentManagedBean implements Serializable {
    
    /**
     * Enterprise Java Bean commentEntityFacade mit einem Remote Interface.
     */
    @EJB
    private CommentEntityFacadeRemote commentEntityFacade;
    
    /**
     * Der Kommentar des Benutzers zu einem Buch.
     */
    private String commentText;
    
    /**
     * Die maximale Länge des Kommentars.
     */
    private int maxLengthOfCommentText = 250;
    
    /**
     * Die aktuelle Länge des Kommentars.
     */
    private int currentLengthOfCommentText = 0;
    
    /**
     * Liefert alle Kommentare zu einem Buch zurück.
     * @param id ID des Buches
     * @return Liste vom Typ CommentEntity
     */
    public List<CommentEntity> getBookComments(int id) {
        return this.commentEntityFacade.findByBookId(id);
    }
    
    /**
     * Erstellt ein Kommentar zu einem Buch.
     */
    public void createBookComment() {
        this.commentEntityFacade.createBookComment(this.getId(), this.commentText);
    }
    
    /**
     * Zählt die Länge des Kommentars.
     */
    public void countLengthOfCommentText() {
        this.currentLengthOfCommentText = this.commentText.length();
    }
    
    /**
     * Liefert den Parameter 'id' des GET-Request zurück.
     * @return GET-Request Parameter 'id'
     */
    public int getId() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        Map<String, String> params = extContext.getRequestParameterMap();
        return Integer.parseInt(params.get("id"));
    }

    /**
     * Liefert den Kommentar zurück
     * @return Kommentar des Buches
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * Setzt den Kommentar.
     * @param commentText Kommentar des Buches
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    /**
     * Liefert die maximale Länge des Kommentars zurück.
     * @return max. Länge des Kommentars
     */
    public int getMaxLengthOfCommentText() {
        return maxLengthOfCommentText;
    }

    /**
     * Setzt die maximale Länge des Kommentars.
     * @param maxLengthOfCommentText max. Länge des Kommentars
     */
    public void setMaxLengthOfCommentText(int maxLengthOfCommentText) {
        this.maxLengthOfCommentText = maxLengthOfCommentText;
    }

    /**
     * Liefert die aktuelles Länge des Kommentars zurück.
     * @return akt. Länge des Kommentars
     */
    public int getCurrentLengthOfCommentText() {
        return currentLengthOfCommentText;
    }

    /**
     * Setzt die aktuelles Länge des Kommentars.
     * @param currentLengthOfCommentText akt. Länge des Kommentars
     */
    public void setCurrentLengthOfCommentText(int currentLengthOfCommentText) {
        this.currentLengthOfCommentText = currentLengthOfCommentText;
    }
    
}
