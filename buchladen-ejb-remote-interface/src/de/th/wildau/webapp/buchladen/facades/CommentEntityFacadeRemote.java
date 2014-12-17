/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.entities.CommentEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface CommentEntityFacadeRemote {
    
    void createBookComment(int bookId, String comment);

    void create(CommentEntity commentEntity);

    void edit(CommentEntity commentEntity);

    void remove(CommentEntity commentEntity);

    CommentEntity find(Object id);

    List<CommentEntity> findAll();

    List<CommentEntity> findRange(int[] range);
    
    List<CommentEntity> findByBookId(int id);

    int count();
    
}
