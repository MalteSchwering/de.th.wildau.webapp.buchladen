/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.entities;

import de.th.wildau.webapp.buchladen.validator.CreditCardNumberValidator;
import de.th.wildau.webapp.buchladen.validator.CreditCardValidationCodeValidator;
import de.th.wildau.webapp.buchladen.validator.NameValidator;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Size(max = 16)
    @Column(name = "CREDIT_CARD_NUMBER")
    @NotNull
    @Pattern(regexp = CreditCardNumberValidator.CREDITCARDNUMBER_REGEX)
    private String creditCardNumber;
    @Size(max = 4)
    @Column(name = "CARD_VALIDATION_CODE")
    @NotNull
    @Pattern(regexp = CreditCardValidationCodeValidator.CVV_REGEX)
    private String cardValidationCode;
    @Size(max = 255)
    @Column(name = "CARD_HOLDER")
    @NotNull
    @Pattern(regexp = NameValidator.NAME_REGEX)
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
