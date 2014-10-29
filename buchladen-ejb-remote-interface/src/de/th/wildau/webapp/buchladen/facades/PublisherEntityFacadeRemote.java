/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.PublisherEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface PublisherEntityFacadeRemote {

    void create(PublisherEntity publisherEntity);

    void edit(PublisherEntity publisherEntity);

    void remove(PublisherEntity publisherEntity);

    PublisherEntity find(Object id);

    List<PublisherEntity> findAll();

    List<PublisherEntity> findRange(int[] range);

    int count();
    
}
