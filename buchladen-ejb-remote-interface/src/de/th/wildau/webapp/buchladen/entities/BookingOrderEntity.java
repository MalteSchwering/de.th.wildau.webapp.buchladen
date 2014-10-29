/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "BOOKING_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingOrderEntity.findAll", query = "SELECT b FROM BookingOrderEntity b"),
    @NamedQuery(name = "BookingOrderEntity.findById", query = "SELECT b FROM BookingOrderEntity b WHERE b.id = :id")})
public class BookingOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @OneToMany(mappedBy = "fkBookOrderId")
    private Collection<BookingOrderDetailEntity> bookingOrderDetailEntityCollection;
    @JoinColumn(name = "FK_REGISTERED_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private RegisteredUserEntity fkRegisteredUserId;
    @JoinColumn(name = "FK_PAYMENT_TRANSFER", referencedColumnName = "ID")
    @ManyToOne
    private PaymentTransferEntity fkPaymentTransfer;
    @JoinColumn(name = "FK_PAYMENT_CREDIT_CARD", referencedColumnName = "ID")
    @ManyToOne
    private PaymentCreditCardEntity fkPaymentCreditCard;

    public BookingOrderEntity() {
    }

    public BookingOrderEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<BookingOrderDetailEntity> getBookingOrderDetailEntityCollection() {
        return bookingOrderDetailEntityCollection;
    }

    public void setBookingOrderDetailEntityCollection(Collection<BookingOrderDetailEntity> bookingOrderDetailEntityCollection) {
        this.bookingOrderDetailEntityCollection = bookingOrderDetailEntityCollection;
    }

    public RegisteredUserEntity getFkRegisteredUserId() {
        return fkRegisteredUserId;
    }

    public void setFkRegisteredUserId(RegisteredUserEntity fkRegisteredUserId) {
        this.fkRegisteredUserId = fkRegisteredUserId;
    }

    public PaymentTransferEntity getFkPaymentTransfer() {
        return fkPaymentTransfer;
    }

    public void setFkPaymentTransfer(PaymentTransferEntity fkPaymentTransfer) {
        this.fkPaymentTransfer = fkPaymentTransfer;
    }

    public PaymentCreditCardEntity getFkPaymentCreditCard() {
        return fkPaymentCreditCard;
    }

    public void setFkPaymentCreditCard(PaymentCreditCardEntity fkPaymentCreditCard) {
        this.fkPaymentCreditCard = fkPaymentCreditCard;
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
        if (!(object instanceof BookingOrderEntity)) {
            return false;
        }
        BookingOrderEntity other = (BookingOrderEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.BookingOrderEntity[ id=" + id + " ]";
    }
    
}
