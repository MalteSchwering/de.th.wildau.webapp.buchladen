package de.th.wildau.webapp.buchladen.entities;

import de.th.wildau.webapp.buchladen.validator.BICValidator;
import de.th.wildau.webapp.buchladen.validator.IBANValidator;
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
@Table(name = "PAYMENT_TRANSFER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentTransferEntity.findAll", query = "SELECT p FROM PaymentTransferEntity p"),
    @NamedQuery(name = "PaymentTransferEntity.findById", query = "SELECT p FROM PaymentTransferEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PaymentTransferEntity.findByIban", query = "SELECT p FROM PaymentTransferEntity p WHERE p.iban = :iban"),
    @NamedQuery(name = "PaymentTransferEntity.findByBic", query = "SELECT p FROM PaymentTransferEntity p WHERE p.bic = :bic"),
    @NamedQuery(name = "PaymentTransferEntity.findByAccountHolder", query = "SELECT p FROM PaymentTransferEntity p WHERE p.accountHolder = :accountHolder")})
public class PaymentTransferEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'payment_transfer'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * IBAN der Tabelle 'payment_transfer'.
     */
    @Size(max = 22)
    @Column(name = "IBAN")
    @NotNull
    @Pattern(regexp = IBANValidator.IBAN_REGEX)
    private String iban;
    
    /**
     * BIC der Tabelle 'payment_transfer'.
     */
    @Size(max = 11)
    @Column(name = "BIC")
    @NotNull
    @Pattern(regexp = BICValidator.BIC_REGEX)
    private String bic;
    
    /**
     * Kontoinhaber der Tabelle 'payment_transfer'.
     */
    @Size(max = 255)
    @Column(name = "ACCOUNT_HOLDER")
    @NotNull
    @Pattern(regexp = NameValidator.NAME_REGEX)
    private String accountHolder;
    
    /**
     * Referenz der 'BookingOrderEntity' zur 'PaymentTransferEntity'.
     */
    @OneToMany(mappedBy = "fkPaymentTransfer")
    private Collection<BookingOrderEntity> bookingOrderEntityCollection;
    
    /**
     * Referenz der 'PaymentTransferEntity' zur 'RegistredUserEntity'.
     */
    @JoinColumn(name = "FK_REGISTERED_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private RegisteredUserEntity fkRegisteredUserId;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public PaymentTransferEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID einer Kontoüberweisungs-Entität
     */
    public PaymentTransferEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID der Kontoüberweisung
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID der Kontoüberweisung
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die IBAN zurück.
     * @return IBAN der Kontoüberweisung
     */
    public String getIban() {
        return iban;
    }

    /**
     * Setzt die IBAN.
     * @param iban IBAN der Kontoüberweisung
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * Liefert die BIC zurück.
     * @return BIC der Kontoüberweisung
     */
    public String getBic() {
        return bic;
    }

    /**
     * Setzt die BIC.
     * @param bic BIC der Kontoüberweisung
     */
    public void setBic(String bic) {
        this.bic = bic;
    }

    /**
     * Liefert den Kontoinhaber zurück.
     * @return Kontoinhaber der Kontoüberweisung
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * Setzt den Kontoinhaber.
     * @param accountHolder Kontoinhaber der Kontoüberweisung
     */
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    /**
     * Liefert Buchungs-Entitäten zurück.
     * @return Buchungen der Kontoüberweisung
     */
    @XmlTransient
    public Collection<BookingOrderEntity> getBookingOrderEntityCollection() {
        return bookingOrderEntityCollection;
    }

    /**
     * Setzt Buchungs-Entitäten.
     * @param bookingOrderEntityCollection Buchungen der Kontoüberweisung
     */
    public void setBookingOrderEntityCollection(Collection<BookingOrderEntity> bookingOrderEntityCollection) {
        this.bookingOrderEntityCollection = bookingOrderEntityCollection;
    }

    /**
     * Liefert Benutzer-Entitäten zurück.
     * @return Benutzer der Kontoüberweisung
     */
    public RegisteredUserEntity getFkRegisteredUserId() {
        return fkRegisteredUserId;
    }

    /**
     * Setzt die Benutzer-Entitäten.
     * @param fkRegisteredUserId Benutzer der Kontoüberweisung
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
     * Vergleicht 2 Kontoüberweisungs-Entitäten miteinander.
     * @param object Kontoüberweisung-Entität
     * @return true für gleich, false für ungleich
     */
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

    /**
     * Liefert einen String mit der ID der Entität zurück.
     * @return String mit der ID der Entität
     */
    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.PaymentTransferEntity[ id=" + id + " ]";
    }
    
}
