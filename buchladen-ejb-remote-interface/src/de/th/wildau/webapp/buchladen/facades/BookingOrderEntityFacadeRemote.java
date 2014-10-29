/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookingOrderEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface BookingOrderEntityFacadeRemote {

    void create(BookingOrderEntity bookingOrderEntity);

    void edit(BookingOrderEntity bookingOrderEntity);

    void remove(BookingOrderEntity bookingOrderEntity);

    BookingOrderEntity find(Object id);

    List<BookingOrderEntity> findAll();

    List<BookingOrderEntity> findRange(int[] range);

    int count();
    
}
