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
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Entity
@Table(name = "BOOKING_ORDER_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingOrderDetailEntity.findAll", query = "SELECT b FROM BookingOrderDetailEntity b"),
    @NamedQuery(name = "BookingOrderDetailEntity.findById", query = "SELECT b FROM BookingOrderDetailEntity b WHERE b.id = :id"),
    @NamedQuery(name = "BookingOrderDetailEntity.findByBookingOrderId", query = "SELECT b FROM BookingOrderDetailEntity b WHERE b.fkBookingOrderId = :bookingOrder")})
public class BookingOrderDetailEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'booking_order_detail'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * Anzahl der Tabelle 'booking_order_detail'.
     */
    @Column(name = "QUANTITY")
    private int quantity;
    
    /**
     * Referenz der 'BookingOrderDetailEntity' zur 'BookingOrderEntity'.
     */
    @JoinColumn(name = "FK_BOOKING_ORDER_ID", referencedColumnName = "ID")
    @ManyToOne
    private BookingOrderEntity fkBookingOrderId;
    
    /**
     * Referenz der 'BookingOrderDetailEntity' zur 'BookEntity'.
     */
    @JoinColumn(name = "FK_BOOK_ID", referencedColumnName = "ID")
    @ManyToOne
    private BookEntity fkBookId;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public BookingOrderDetailEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID der Buchungsdetail-Entität
     */
    public BookingOrderDetailEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID der Buchungsdetails
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID der Buchungsdetails
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert Buchungs-Entität zurück.
     * @return Buchung der Buchungsdetails
     */
    public BookingOrderEntity getFkBookingOrderId() {
        return fkBookingOrderId;
    }

    /**
     * Setzt Buchungs-Entität.
     * @param fkBookingOrderId Buchung der Buchungsdetails 
     */
    public void setFkBookingOrderId(BookingOrderEntity fkBookingOrderId) {
        this.fkBookingOrderId = fkBookingOrderId;
    }

    /**
     * Liefert Buch-Entität zurück.
     * @return Buch der Buchungsdetails
     */
    public BookEntity getFkBookId() {
        return fkBookId;
    }

    /**
     * Setzt Buch-Entität.
     * @param fkBookId Buch der Buchungsdetails
     */
    public void setFkBookId(BookEntity fkBookId) {
        this.fkBookId = fkBookId;
    }
    
    /**
     * Liefert die Anzahl zurück.
     * @return Anzahl der Buchungsdetails
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setzt die Anzahl.
     * @param quantity Anzahl der Buchungsdetails
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
     * Vergleicht 2 Buchungsdetail-Entitäten miteinander.
     * @param object Buchungsdetail-Entität
     * @return true für gleich, false für ungleich
     */
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

    /**
     * Liefert einen String mit der ID der Entität zurück.
     * @return String mit der ID der Entität
     */
    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity[ id=" + id + " ]";
    }
    
}
