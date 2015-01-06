package de.th.wildau.webapp.buchladen.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Entity
@Table(name = "REGISTERED_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegisteredUserEntity.findAll", query = "SELECT r FROM RegisteredUserEntity r"),
    @NamedQuery(name = "RegisteredUserEntity.findById", query = "SELECT r FROM RegisteredUserEntity r WHERE r.id = :id"),
    @NamedQuery(name = "RegisteredUserEntity.findByEmailAddress", query = "SELECT r FROM RegisteredUserEntity r WHERE r.emailAddress = :emailAddress"),
    @NamedQuery(name = "RegisteredUserEntity.findByPassword", query = "SELECT r FROM RegisteredUserEntity r WHERE r.password = :password"),
    @NamedQuery(name = "RegisteredUserEntity.findByFirstName", query = "SELECT r FROM RegisteredUserEntity r WHERE r.firstName = :firstName"),
    @NamedQuery(name = "RegisteredUserEntity.findByLastName", query = "SELECT r FROM RegisteredUserEntity r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "RegisteredUserEntity.findByStreet", query = "SELECT r FROM RegisteredUserEntity r WHERE r.street = :street"),
    @NamedQuery(name = "RegisteredUserEntity.findByHouseNumber", query = "SELECT r FROM RegisteredUserEntity r WHERE r.houseNumber = :houseNumber"),
    @NamedQuery(name = "RegisteredUserEntity.findByZipCode", query = "SELECT r FROM RegisteredUserEntity r WHERE r.zipCode = :zipCode"),
    @NamedQuery(name = "RegisteredUserEntity.findByCity", query = "SELECT r FROM RegisteredUserEntity r WHERE r.city = :city")})
public class RegisteredUserEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'registered_user'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * E-Mail Adresse der Tabelle 'registered_user'.
     */
    @Size(max = 255)
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    
    /**
     * Passwort der Tabelle 'registered_user'.
     */
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    
    /**
     * Salt der Tabelle 'registered_user'.
     */
    @Size(max = 4)
    @Column(name = "SALT")
    private String salt;
    
    /**
     * Vorname der Tabelle 'registered_user'.
     */
    @Size(max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    /**
     * Nachname der Tabelle 'registered_user'.
     */
    @Size(max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    /**
     * Straße der Tabelle 'registered_user'.
     */
    @Size(max = 255)
    @Column(name = "STREET")
    private String street;
    
    /**
     * Hausnummer der Tabelle 'registered_user'.
     */
    @Size(max = 5)
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    
    /**
     * Postleitzahl der Tabelle 'registered_user'.
     */
    @Size(max = 5)
    @Column(name = "ZIP_CODE")
    private String zipCode;
    
    /**
     * Stadt der Tabelle 'registered_user'.
     */
    @Size(max = 255)
    @Column(name = "CITY")
    private String city;
    
    /**
     * Referenz der 'CommentEntity' zur 'RegisteredUserEntity'.
     */
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<CommentEntity> commentEntityCollection;
    
    /**
     * Referenz der 'BookingOrderEntity' zur 'RegisteredUserEntity'.
     */
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<BookingOrderEntity> bookingOrderEntityCollection;
    
    /**
     * Referenz der 'PaymentTransferEntity' zur 'RegisteredUserEntity'.
     */
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<PaymentTransferEntity> paymentTransferEntityCollection;
    
    /**
     * Referenz der 'RegisteredUserGroupMappingEntity' zur 'RegisteredUserEntity'.
     */
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<RegisteredUserGroupMappingEntity> registeredUserGroupMappingEntityCollection;
    
    /**
     * Referenz der 'PaymentCreditCardEntity' zur 'RegisteredUserEntity'.
     */
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<PaymentCreditCardEntity> paymentCreditCardEntityCollection;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public RegisteredUserEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID einer Benutzer-Entität
     */
    public RegisteredUserEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID des Benutzers
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID des Benutzers
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die E-Mail Adresse zurück.
     * @return E-Mail Adresse des Benutzers
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setzt die E-Mail Adresse.
     * @param emailAddress E-Mail Adresse des Benutzers
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Liefert das Passwort zurück.
     * @return Passwort des Benutzers
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setzt das Passwort (inkl. Salt & Pepper).
     * @param password Passwort des Benutzers
     */
    public void setPassword(String password) {
        this.salt = RandomStringUtils.randomAlphanumeric(4);
        String pepper = "DeR$uLtImAtIvE%pEpPeR";
        String part1 = password.substring(0, 4);
        String part2 = password.substring(4);
        String passwordWithSaltAndPepper = part1.concat(pepper).concat(part2).concat(this.salt);
        this.password = DigestUtils.sha256Hex(passwordWithSaltAndPepper);
    }
    
    /**
     * Liefert das Salt zurück.
     * @return Salt des Benutzers
     */
    public String getSalt() {
        return salt;
    }

    /**
     * Setzt das Salt.
     * @param salt Salt des Benutzers
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Liefert den Vornamen zurück.
     * @return Vorname des Benutzers
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setzt den Vornamen.
     * @param firstName Vorname des Benutzers
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Liefert den Nachnamen zurück.
     * @return Nachname des Benutzers
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setzt den Nachnamen.
     * @param lastName Nachname des Benutzers
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Liefert die Straße zurück.
     * @return Straße des Benutzers
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setzt die Straße.
     * @param street Straße des Benutzers
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Liefert die Hausnummer zurück.
     * @return Hausnummer des Benutzers
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Setzt die Hausnummer.
     * @param houseNumber Hausnummer des Benutzers
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Liefert die Postleitzahl zurück.
     * @return Postleitzahl des Benutzers
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setzt die Postleitzahl.
     * @param zipCode Postleitzahl des Benutzers
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Liefert die Stadt zurück.
     * @return Stadt des Benutzers
     */
    public String getCity() {
        return city;
    }

    /**
     * Setzt die Stadt.
     * @param city Stadt des Benutzers
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Liefert Kommentar-Entitäten zurück.
     * @return Kommentare des Benutzers
     */
    @XmlTransient
    public Collection<CommentEntity> getCommentEntityCollection() {
        return commentEntityCollection;
    }

    /**
     * Setzt Kommentar-Entitäten.
     * @param commentEntityCollection Kommentare des Benutzers
     */
    public void setCommentEntityCollection(Collection<CommentEntity> commentEntityCollection) {
        this.commentEntityCollection = commentEntityCollection;
    }

    /**
     * Liefert Buchungs-Entitäten zurück.
     * @return Buchungen des Benutzers
     */
    @XmlTransient
    public Collection<BookingOrderEntity> getBookingOrderEntityCollection() {
        return bookingOrderEntityCollection;
    }

    /**
     * Setzt Buchungs-Entitäten.
     * @param bookingOrderEntityCollection Buchungen des Benutzers
     */
    public void setBookingOrderEntityCollection(Collection<BookingOrderEntity> bookingOrderEntityCollection) {
        this.bookingOrderEntityCollection = bookingOrderEntityCollection;
    }

    /**
     * Liefert Kontoüberweisungs-Entitäten zurück.
     * @return Kontoüberweisungen des Benutzers
     */
    @XmlTransient
    public Collection<PaymentTransferEntity> getPaymentTransferEntityCollection() {
        return paymentTransferEntityCollection;
    }

    /**
     * Setzt Kontoüberweisungs-Entitäten.
     * @param paymentTransferEntityCollection Kontoüberweisungen des Benutzers
     */
    public void setPaymentTransferEntityCollection(Collection<PaymentTransferEntity> paymentTransferEntityCollection) {
        this.paymentTransferEntityCollection = paymentTransferEntityCollection;
    }

    /**
     * Liefert Benutzer/Benutzer-Gruppen Zuordnungs-Entitäten zurück.
     * @return Benutzer/Benutzer-Gruppen Zuordnung des Benutzers
     */
    @XmlTransient
    public Collection<RegisteredUserGroupMappingEntity> getRegisteredUserGroupMappingEntityCollection() {
        return registeredUserGroupMappingEntityCollection;
    }

    /**
     * Setzt Benutzer/Benutzer-Gruppen Zuordnungs-Entitäten.
     * @param registeredUserGroupMappingEntityCollection Benutzer/Benutzer-Gruppen Zuordnung des Benutzers
     */
    public void setRegisteredUserGroupMappingEntityCollection(Collection<RegisteredUserGroupMappingEntity> registeredUserGroupMappingEntityCollection) {
        this.registeredUserGroupMappingEntityCollection = registeredUserGroupMappingEntityCollection;
    }

    /**
     * Liefert Kreditkarten-Entitäten zurück.
     * @return Kreditkartenzahlungen des Benutzers
     */
    @XmlTransient
    public Collection<PaymentCreditCardEntity> getPaymentCreditCardEntityCollection() {
        return paymentCreditCardEntityCollection;
    }

    /**
     * Setzt Kreditkarten-Entitäten.
     * @param paymentCreditCardEntityCollection Kreditkartenzahlungen des Benutzers
     */
    public void setPaymentCreditCardEntityCollection(Collection<PaymentCreditCardEntity> paymentCreditCardEntityCollection) {
        this.paymentCreditCardEntityCollection = paymentCreditCardEntityCollection;
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
     * Vergleicht 2 Benutzer-Entitäten miteinander.
     * @param object Benutzer-Entität
     * @return true für gleich, false für ungleich
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegisteredUserEntity)) {
            return false;
        }
        RegisteredUserEntity other = (RegisteredUserEntity) object;
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
        return "de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity[ id=" + id + " ]";
    }
    
}
