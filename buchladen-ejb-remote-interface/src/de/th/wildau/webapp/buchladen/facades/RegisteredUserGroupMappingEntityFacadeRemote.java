/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserGroupMappingEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface RegisteredUserGroupMappingEntityFacadeRemote {

    void create(RegisteredUserGroupMappingEntity registeredUserGroupMappingEntity);

    void edit(RegisteredUserGroupMappingEntity registeredUserGroupMappingEntity);

    void remove(RegisteredUserGroupMappingEntity registeredUserGroupMappingEntity);

    RegisteredUserGroupMappingEntity find(Object id);

    List<RegisteredUserGroupMappingEntity> findAll();

    List<RegisteredUserGroupMappingEntity> findRange(int[] range);

    int count();
    
}
