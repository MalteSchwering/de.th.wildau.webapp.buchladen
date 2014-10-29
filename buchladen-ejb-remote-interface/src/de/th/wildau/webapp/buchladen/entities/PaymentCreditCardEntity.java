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
@Table(name = "PAYMENT_CREDIT_CARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentCreditCardEntity.findAll", query = "SELECT p FROM PaymentCreditCardEntity p"),
    @NamedQuery(name = "PaymentCreditCardEntity.findById", query = "SELECT p FROM PaymentCreditCardEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PaymentCreditCardEntity.findByCreditCardNumber", query = "SELECT p FROM PaymentCreditCardEntity p WHERE p.creditCardNumber = :creditCardNumber"),
    @NamedQuery(name = "PaymentCreditCardEntity.findByCardValidationCode", query = "SELECT p FROM PaymentCreditCardEntity p WHERE p.cardValidationCode = :cardValidationCode"),
    @NamedQuery(name = "PaymentCreditCardEntity.findByCardHolder", query = "SELECT p FROM PaymentCreditCardEntity p WHERE p.cardHolder = :cardHolder"),
    @NamedQuery(name = "PaymentCreditCardEntity.findByExpirationMonth", query = "SELECT p FROM PaymentCreditCardEntity p WHERE p.expirationMonth = :expirationMonth"),
    @NamedQuery(name = "PaymentCreditCardEntity.findByExpirationYear", query = "SELECT p FROM PaymentCreditCardEntity p WHERE p.expirationYear = :expirationYear")})
public class PaymentCreditCardEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CREDIT_CARD_NUMBER")
    private String creditCardNumber;
    @Column(name = "CARD_VALIDATION_CODE")
    private String cardValidationCode;
    @Column(name = "CARD_HOLDER")
    private String cardHolder;
    @Column(name = "EXPIRATION_MONTH")
    private Integer expirationMonth;
    @Column(name = "EXPIRATION_YEAR")
    private Integer expirationYear;
    @OneToMany(mappedBy = "fkPaymentCreditCard")
    private Collection<BookingOrderEntity> bookingOrderEntityCollection;
    @JoinColumn(name = "FK_REGISTERED_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private RegisteredUserEntity fkRegisteredUserId;

    public PaymentCreditCardEntity() {
    }

    public PaymentCreditCardEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCardValidationCode() {
        return cardValidationCode;
    }

    public void setCardValidationCode(String cardValidationCode) {
        this.cardValidationCode = cardValidationCode;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
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
        if (!(object instanceof PaymentCreditCardEntity)) {
            return false;
        }
        PaymentCreditCardEntity other = (PaymentCreditCardEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity[ id=" + id + " ]";
    }
    
}
