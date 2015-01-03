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
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
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
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'payment_credit_card'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * Kreditkartennummer der Tabelle 'payment_credit_card'.
     */
    @Size(max = 16)
    @Column(name = "CREDIT_CARD_NUMBER")
    @NotNull
    @Pattern(regexp = CreditCardNumberValidator.CREDITCARDNUMBER_REGEX)
    private String creditCardNumber;
    
    /**
     * Kreditkarten-Validationscode der Tabelle 'payment_credit_card'.
     */
    @Size(max = 4)
    @Column(name = "CARD_VALIDATION_CODE")
    @NotNull
    @Pattern(regexp = CreditCardValidationCodeValidator.CVV_REGEX)
    private String cardValidationCode;
    
    /**
     * Kreditkarteninhaber der Tabelle 'payment_credit_card'.
     */
    @Size(max = 255)
    @Column(name = "CARD_HOLDER")
    @NotNull
    @Pattern(regexp = NameValidator.NAME_REGEX)
    private String cardHolder;
    
    /**
     * Ablauf Monat der Tabelle 'payment_credit_card'.
     */
    @Column(name = "EXPIRATION_MONTH")
    private Integer expirationMonth;
    
    /**
     * Ablauf Jahr der Tabelle 'payment_credit_card'.
     */
    @Column(name = "EXPIRATION_YEAR")
    private Integer expirationYear;
    
    /**
     * Referenz der 'BookingOrderEntity' zur 'PaymentCreditCardEntity'.
     */
    @OneToMany(mappedBy = "fkPaymentCreditCard")
    private Collection<BookingOrderEntity> bookingOrderEntityCollection;
    
    /**
     * Referenz der 'PaymentCreditCardEntity' zur 'RegistredUserEntity'.
     */
    @JoinColumn(name = "FK_REGISTERED_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private RegisteredUserEntity fkRegisteredUserId;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public PaymentCreditCardEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID einer Kreditkarten-Entität
     */
    public PaymentCreditCardEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID der Kreditkartenzahlung
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID der Kreditkartenzahlung
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die Kreditkartennummer zurück.
     * @return Kreditkartennummer der Kreditkartenzahlung
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Setzt die Kreditkartennummer.
     * @param creditCardNumber Kreditkartennummer der Kreditkartenzahlung
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Liefert den Kreditkarten-Validationscode zurück.
     * @return Kreditkarten-Validationscode der Kreditkartenzahlung
     */
    public String getCardValidationCode() {
        return cardValidationCode;
    }

    /**
     * Setzt den Kreditkarten-Validationscode.
     * @param cardValidationCode Kreditkarten-Validationscode der Kreditkartenzahlung
     */
    public void setCardValidationCode(String cardValidationCode) {
        this.cardValidationCode = cardValidationCode;
    }

    /**
     * Liefert den Kreditkarteninhaber zurück.
     * @return Kreditkarteninhaber der Kreditkartenzahlung
     */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
     * Setzt den Kreditkarteninhaber.
     * @param cardHolder Kreditkarteninhaber der Kreditkartenzahlung
     */
    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
     * Liefert den Ablauf Monat zurück.
     * @return Ablauf Monat der Kreditkartenzahlung
     */
    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * Setzt den Ablauf Monat.
     * @param expirationMonth Ablauf Monat der Kreditkartenzahlung
     */
    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    /**
     * Liefert das Ablauf Jahr zurück.
     * @return Ablauf Jahr der Kreditkartenzahlung
     */
    public Integer getExpirationYear() {
        return expirationYear;
    }

    /**
     * Setzt das Ablauf Jahr.
     * @param expirationYear Ablauf Jahr der Kreditkartenzahlung
     */
    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    /**
     * Liefert Buchungs-Entitäten zurück.
     * @return Buchungen der Kreditkartenzahlung
     */
    @XmlTransient
    public Collection<BookingOrderEntity> getBookingOrderEntityCollection() {
        return bookingOrderEntityCollection;
    }

    /**
     * Setzt die Buchungs-Entitäten.
     * @param bookingOrderEntityCollection Buchungen der Kreditkartenzahlung
     */
    public void setBookingOrderEntityCollection(Collection<BookingOrderEntity> bookingOrderEntityCollection) {
        this.bookingOrderEntityCollection = bookingOrderEntityCollection;
    }

    /**
     * Liefert Benutzer-Entitäten zurück.
     * @return Benutzer der Kreditkartenzahlung
     */
    public RegisteredUserEntity getFkRegisteredUserId() {
        return fkRegisteredUserId;
    }

    /**
     * Setzt Benutzer-Entitäten.
     * @param fkRegisteredUserId Benutzer der Kreditkartenzahlung
     */
    public void setFkRegisteredUserId(RegisteredUserEntity fkRegisteredUserId) {
        this.fkRegisteredUserId = fkRegisteredUserId;
    }

    /**
     * Generiert einen ID basierten Hashwert.
     * @return Hashwert der ID
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Vergleicht 2 Kreditkarten-Entitäten miteinander.
     * @param object Kreditkarten-Entität
     * @return true für gleich, false für ungleich
     */
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

    /**
     * Liefert einen String mit der ID der Entität zurück.
     * @return String mit der ID der Entität
     */
    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity[ id=" + id + " ]";
    }
    
}
