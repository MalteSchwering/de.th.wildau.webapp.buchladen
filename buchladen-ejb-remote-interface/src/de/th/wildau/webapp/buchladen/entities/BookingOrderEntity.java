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
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Entity
@Table(name = "BOOKING_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingOrderEntity.findAll", query = "SELECT b FROM BookingOrderEntity b"),
    @NamedQuery(name = "BookingOrderEntity.findById", query = "SELECT b FROM BookingOrderEntity b WHERE b.id = :id"),
    @NamedQuery(name = "BookingOrderEntity.findAllByRegisteredUserId", query = "SELECT b FROM BookingOrderEntity b WHERE b.fkRegisteredUserId.id = :registeredUserId")})
public class BookingOrderEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'booking_order'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * Referenz der 'BookingOrderDetailEntity' zur 'BookingOrderEntity'.
     */
    @OneToMany(mappedBy = "fkBookingOrderId")
    private Collection<BookingOrderDetailEntity> bookingOrderDetailEntityCollection;
    
    /**
     * Referenz der 'BookingOrderEntity' zur 'RegistredUserEntity'.
     */
    @JoinColumn(name = "FK_REGISTERED_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private RegisteredUserEntity fkRegisteredUserId;
    
    /**
     * Referenz der 'BookingOrderEntity' zur 'PaymentTransferEntity'.
     */
    @JoinColumn(name = "FK_PAYMENT_TRANSFER", referencedColumnName = "ID")
    @ManyToOne
    private PaymentTransferEntity fkPaymentTransfer;
    
    /**
     * Referenz der 'BookingOrderEntity' zur 'PaymentCreditCardEntity'.
     */
    @JoinColumn(name = "FK_PAYMENT_CREDIT_CARD", referencedColumnName = "ID")
    @ManyToOne
    private PaymentCreditCardEntity fkPaymentCreditCard;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public BookingOrderEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID einer Buchungs-Entität
     */
    public BookingOrderEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID der Buchung
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID der Buchung
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert Buchungsdetail-Entitäten zurück.
     * @return Buchungsdetails der Buchung
     */
    @XmlTransient
    public Collection<BookingOrderDetailEntity> getBookingOrderDetailEntityCollection() {
        return bookingOrderDetailEntityCollection;
    }

    /**
     * Setzt Buchungsdetail-Entitäten.
     * @param bookingOrderDetailEntityCollection Buchungsdetails der Buchung
     */
    public void setBookingOrderDetailEntityCollection(Collection<BookingOrderDetailEntity> bookingOrderDetailEntityCollection) {
        this.bookingOrderDetailEntityCollection = bookingOrderDetailEntityCollection;
    }

    /**
     * Liefert Benutzer-Entität zurück.
     * @return Benutzer der Buchung
     */
    public RegisteredUserEntity getFkRegisteredUserId() {
        return fkRegisteredUserId;
    }

    /**
     * Setzt Benutzer-Entität.
     * @param fkRegisteredUserId Benutzer der Buchung
     */
    public void setFkRegisteredUserId(RegisteredUserEntity fkRegisteredUserId) {
        this.fkRegisteredUserId = fkRegisteredUserId;
    }

    /**
     * Liefert Kontoüberweisungs-Entität zurück.
     * @return Kontoüberweisung der Buchung
     */
    public PaymentTransferEntity getFkPaymentTransfer() {
        return fkPaymentTransfer;
    }

    /**
     * Setzt Kontoüberweisungs-Entität.
     * @param fkPaymentTransfer Kontoüberweisung der Buchung
     */
    public void setFkPaymentTransfer(PaymentTransferEntity fkPaymentTransfer) {
        this.fkPaymentTransfer = fkPaymentTransfer;
    }

    /**
     * Liefert Kreditkarten-Entität zurück.
     * @return Kreditkartezahlung der Buchung
     */
    public PaymentCreditCardEntity getFkPaymentCreditCard() {
        return fkPaymentCreditCard;
    }

    /**
     * Setzt Kreditkarten-Entität.
     * @param fkPaymentCreditCard Kreditkartenzahlung der Buchung
     */
    public void setFkPaymentCreditCard(PaymentCreditCardEntity fkPaymentCreditCard) {
        this.fkPaymentCreditCard = fkPaymentCreditCard;
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
     * Vergleicht 2 Buchungs-Entitäten miteinander.
     * @param object Buchungs-Entität
     * @return true für gleich, false für ungleich
     */
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

    /**
     * Liefert einen String mit der ID der Entität zurück.
     * @return String mit der ID der Entität
     */
    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.BookingOrderEntity[ id=" + id + " ]";
    }
    
}
