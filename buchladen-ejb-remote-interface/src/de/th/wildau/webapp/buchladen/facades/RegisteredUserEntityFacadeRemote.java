/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface RegisteredUserEntityFacadeRemote {

    void create(RegisteredUserEntity registeredUserEntity);

    void edit(RegisteredUserEntity registeredUserEntity);

    void remove(RegisteredUserEntity registeredUserEntity);

    RegisteredUserEntity find(Object id);

    List<RegisteredUserEntity> findAll();

    List<RegisteredUserEntity> findRange(int[] range);

    int count();
    
}
