/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote;
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

    private List<BookEntity> cart;

    public CartSessionBean() {
        this.cart = new ArrayList<>();
    }

    @Override
    public void addBook(int id) {
        BookEntity bookEntity = this.bookEntityFacade.find(id);
        if(bookEntity != null) {
            this.cart.add(bookEntity);
        }
    }

    @Override
    public void removeBook(int id) {
        Iterator<BookEntity> iteratorBookEntity = this.cart.iterator();
        while(iteratorBookEntity.hasNext()) {
            if(id == iteratorBookEntity.next().getId()) {
                iteratorBookEntity.remove();
                break;
            }
        }
    }

    @Override
    public List<BookEntity> getContent() {
        return this.cart;
    }

    @Override
    public int count() {
        if(this.cart.isEmpty()) {
            return 0;
        }
        else {
            return this.cart.size();
        }
    }

    @Override
    public double getTotal() {
        Iterator<BookEntity> iteratorBookEntity = this.cart.iterator();
        double total = 0.0;
        while(iteratorBookEntity.hasNext()) {
            total += iteratorBookEntity.next().getPrice();
        }
        return total;
    }
    
}
