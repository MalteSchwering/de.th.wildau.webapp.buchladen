package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.CommentEntity;
import de.th.wildau.webapp.buchladen.facades.CommentEntityFacadeRemote;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class CommentManagedBean implements Serializable {
    
    private String commentText;
    
    @EJB
    private CommentEntityFacadeRemote commentEntityFacade;
    
    public List<CommentEntity> getBookComments(int id) {
        return this.commentEntityFacade.findByBookId(id);
    }
    
    public void createBookComment() {
        this.commentEntityFacade.createBookComment(this.getId(), this.commentText);
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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    
}
