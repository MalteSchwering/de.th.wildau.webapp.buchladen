package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.CommentEntity;
import de.th.wildau.webapp.buchladen.facades.CommentEntityFacadeRemote;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

public class CommentManagedBean implements Serializable {
    
    @EJB
    private CommentEntityFacadeRemote commentEntityFacade;
    
    public List<CommentEntity> getBookComments(int id) {
        return this.commentEntityFacade.findByBookId(id);
    }
    
}
