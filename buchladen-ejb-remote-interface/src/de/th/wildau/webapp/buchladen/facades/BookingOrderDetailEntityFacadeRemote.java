/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface BookingOrderDetailEntityFacadeRemote {

    void create(BookingOrderDetailEntity bookingOrderDetailEntity);

    void edit(BookingOrderDetailEntity bookingOrderDetailEntity);

    void remove(BookingOrderDetailEntity bookingOrderDetailEntity);

    BookingOrderDetailEntity find(Object id);

    List<BookingOrderDetailEntity> findAll();

    List<BookingOrderDetailEntity> findRange(int[] range);

    int count();
    
}
