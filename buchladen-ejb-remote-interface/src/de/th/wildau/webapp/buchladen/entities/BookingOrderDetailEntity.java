/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "BOOKING_ORDER_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingOrderDetailEntity.findAll", query = "SELECT b FROM BookingOrderDetailEntity b"),
    @NamedQuery(name = "BookingOrderDetailEntity.findById", query = "SELECT b FROM BookingOrderDetailEntity b WHERE b.id = :id")})
public class BookingOrderDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private int quantity;
    @JoinColumn(name = "FK_BOOK_ORDER_ID", referencedColumnName = "ID")
    @ManyToOne
    private BookingOrderEntity fkBookOrderId;
    @JoinColumn(name = "FK_BOOK_ID", referencedColumnName = "ID")
    @ManyToOne
    private BookEntity fkBookId;

    public BookingOrderDetailEntity() {
    }

    public BookingOrderDetailEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookingOrderEntity getFkBookOrderId() {
        return fkBookOrderId;
    }

    public void setFkBookOrderId(BookingOrderEntity fkBookOrderId) {
        this.fkBookOrderId = fkBookOrderId;
    }

    public BookEntity getFkBookId() {
        return fkBookId;
    }

    public void setFkBookId(BookEntity fkBookId) {
        this.fkBookId = fkBookId;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingOrderDetailEntity)) {
            return false;
        }
        BookingOrderDetailEntity other = (BookingOrderDetailEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity[ id=" + id + " ]";
    }
    
}
