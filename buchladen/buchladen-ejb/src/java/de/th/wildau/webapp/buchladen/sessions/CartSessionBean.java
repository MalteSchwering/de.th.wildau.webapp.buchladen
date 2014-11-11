/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.BookingOrderDetailEntityFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Jan
 */
@Stateful
public class CartSessionBean implements CartSessionBeanRemote {

    @EJB
    private BookEntityFacadeRemote bookEntityFacade;

    @EJB
    private BookingOrderDetailEntityFacadeRemote bookingOrderDetailEntityFacade;

    private List<BookingOrderDetailEntity> cart;

    public CartSessionBean() {
        this.cart = new ArrayList<>();
    }
    
    private boolean isBookInTheCart(BookEntity bookEntity) {
        Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
        while(iteratorBookingOrderDetailEntity.hasNext()) {
            if(iteratorBookingOrderDetailEntity.next().getFkBookId().equals(bookEntity)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void addBook(int id) {
        BookEntity bookEntity = this.bookEntityFacade.find(id);
        if(bookEntity != null) {
            Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
            if(this.isBookInTheCart(bookEntity)) {
                while(iteratorBookingOrderDetailEntity.hasNext()) {
                    BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
                    if(next.getFkBookId().equals(bookEntity)) {
                        next.setQuantity(next.getQuantity() + 1);
                    }
                }
            }
            else {
                BookingOrderDetailEntity bookOrderDetailEntity = new BookingOrderDetailEntity();
                bookOrderDetailEntity.setFkBookId(bookEntity);
                bookOrderDetailEntity.setQuantity(1);
                this.cart.add(bookOrderDetailEntity);
            }
        }
    }

    @Override
    public void removeBook(int id) {
        BookEntity bookEntity = this.bookEntityFacade.find(id);
        if(bookEntity != null) {
            Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
            if(this.isBookInTheCart(bookEntity)) {
                while(iteratorBookingOrderDetailEntity.hasNext()) {
                    BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
                    if(next.getFkBookId().equals(bookEntity)) {
                        iteratorBookingOrderDetailEntity.remove();
                    }
                }
            }
        }
    }

    @Override
    public List<BookingOrderDetailEntity> getContent() {
        return this.cart;
    }

    @Override
    public int count() {
        if(this.cart.isEmpty()) {
            return 0;
        }
        else {
            int total = 0;
            Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
            while(iteratorBookingOrderDetailEntity.hasNext()) {
                total += iteratorBookingOrderDetailEntity.next().getQuantity();
            }
            return total;
        }
    }

    @Override
    public double getTotal() {
        Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
        double total = 0.0;
        while(iteratorBookingOrderDetailEntity.hasNext()) {
            BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
            total += next.getFkBookId().getPrice() * next.getQuantity();
        }
        return total;
    }

    @Override
    public void setQuantity(int id, int quantity) {
        if(quantity < 1) {
            this.removeBook(id);
        }
        else {
            BookEntity bookEntity = this.bookEntityFacade.find(id);
            if(bookEntity != null) {
                Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
                if(this.isBookInTheCart(bookEntity)) {
                    while(iteratorBookingOrderDetailEntity.hasNext()) {
                        BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
                        if(next.getFkBookId().equals(bookEntity)) {
                            next.setQuantity(quantity);
                        }
                    }
                }
            }
        }
    }

}
