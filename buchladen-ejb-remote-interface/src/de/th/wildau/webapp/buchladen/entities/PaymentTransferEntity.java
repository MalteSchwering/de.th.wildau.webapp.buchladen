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
@Table(name = "PAYMENT_TRANSFER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentTransferEntity.findAll", query = "SELECT p FROM PaymentTransferEntity p"),
    @NamedQuery(name = "PaymentTransferEntity.findById", query = "SELECT p FROM PaymentTransferEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PaymentTransferEntity.findByIban", query = "SELECT p FROM PaymentTransferEntity p WHERE p.iban = :iban"),
    @NamedQuery(name = "PaymentTransferEntity.findByBic", query = "SELECT p FROM PaymentTransferEntity p WHERE p.bic = :bic"),
    @NamedQuery(name = "PaymentTransferEntity.findByAccountHolder", query = "SELECT p FROM PaymentTransferEntity p WHERE p.accountHolder = :accountHolder")})
public class PaymentTransferEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IBAN")
    private String iban;
    @Column(name = "BIC")
    private String bic;
    @Column(name = "ACCOUNT_HOLDER")
    private String accountHolder;
    @OneToMany(mappedBy = "fkPaymentTransfer")
    private Collection<BookingOrderEntity> bookingOrderEntityCollection;
    @JoinColumn(name = "FK_REGISTERED_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private RegisteredUserEntity fkRegisteredUserId;

    public PaymentTransferEntity() {
    }

    public PaymentTransferEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    @XmlTransient
    public Collection<BookingOrderEntity> getBookingOrderEntityCollection() {
        return bookingOrderEntityCollection;
    }

    public void setBookingOrderEntityCollection(Collection<BookingOrderEntity> bookingOrderEntityCollection) {
        this.bookingOrderEntityCollection = bookingOrderEntityCollection;
    }

    public RegisteredUserEntity getFkRegisteredUserId() {
        return fkRegisteredUserId;
    }

    public void setFkRegisteredUserId(RegisteredUserEntity fkRegisteredUserId) {
        this.fkRegisteredUserId = fkRegisteredUserId;
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
        if (!(object instanceof PaymentTransferEntity)) {
            return false;
        }
        PaymentTransferEntity other = (PaymentTransferEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.PaymentTransferEntity[ id=" + id + " ]";
    }
    
}
