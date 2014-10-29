/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.UserGroupEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface UserGroupEntityFacadeRemote {

    void create(UserGroupEntity userGroupEntity);

    void edit(UserGroupEntity userGroupEntity);

    void remove(UserGroupEntity userGroupEntity);

    UserGroupEntity find(Object id);

    List<UserGroupEntity> findAll();

    List<UserGroupEntity> findRange(int[] range);

    int count();
    
}
