/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.AuthorEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface AuthorEntityFacadeRemote {

    void create(AuthorEntity authorEntity);

    void edit(AuthorEntity authorEntity);

    void remove(AuthorEntity authorEntity);

    AuthorEntity find(Object id);

    List<AuthorEntity> findAll();

    List<AuthorEntity> findRange(int[] range);

    int count();
    
}
