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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Entity
@Table(name = "BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookEntity.findAll", query = "SELECT b FROM BookEntity b"),
    @NamedQuery(name = "BookEntity.findById", query = "SELECT b FROM BookEntity b WHERE b.id = :id"),
    @NamedQuery(name = "BookEntity.findByIsbn13", query = "SELECT b FROM BookEntity b WHERE b.isbn13 = :isbn13"),
    @NamedQuery(name = "BookEntity.findByTitle", query = "SELECT b FROM BookEntity b WHERE b.title = :title"),
    @NamedQuery(name = "BookEntity.findByEdition", query = "SELECT b FROM BookEntity b WHERE b.edition = :edition"),
    @NamedQuery(name = "BookEntity.findByYearOfRelease", query = "SELECT b FROM BookEntity b WHERE b.yearOfRelease = :yearOfRelease"),
    @NamedQuery(name = "BookEntity.findByLanguage", query = "SELECT b FROM BookEntity b WHERE b.language = :language"),
    @NamedQuery(name = "BookEntity.findByNumberOfPages", query = "SELECT b FROM BookEntity b WHERE b.numberOfPages = :numberOfPages"),
    @NamedQuery(name = "BookEntity.findByPrice", query = "SELECT b FROM BookEntity b WHERE b.price = :price"),
    @NamedQuery(name = "BookEntity.findByQuantity", query = "SELECT b FROM BookEntity b WHERE b.quantity = :quantity")})
public class BookEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'book'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * ISBN-13 der Tabelle 'book'.
     */
    @Size(max = 13)
    @Column(name = "ISBN_13")
    private String isbn13;
    
    /**
     * Titel der Tabelle 'book'.
     */
    @Size(max = 255)
    @Column(name = "TITLE")
    private String title;
    
    /**
     * Auflage der Tabelle 'book'.
     */
    @Column(name = "EDITION")
    private Integer edition;
    
    /**
     * Veröffentlichungsjahr der Tabelle 'book'.
     */
    @Column(name = "YEAR_OF_RELEASE")
    private Integer yearOfRelease;
    
    /**
     * Sprache der Tabelle 'book'.
     */
    @Size(max = 255)
    @Column(name = "LANGUAGE")
    private String language;
    
    /**
     * Seitenanzahl der Tabelle 'book'.
     */
    @Column(name = "NUMBER_OF_PAGES")
    private Integer numberOfPages;
    
    /**
     * Preis der Tabelle 'book'.
     */
    @Column(name = "PRICE")
    private Double price;
    
    /**
     * Anzahl der Tabelle 'book'.
     */
    @Column(name = "QUANTITY")
    private Integer quantity;
    
    /**
     * Referenz der 'BookingOrderDetailEntity' zur 'BookEntity'.
     */
    @OneToMany(mappedBy = "fkBookId")
    private Collection<BookingOrderDetailEntity> bookingOrderDetailEntityCollection;
    
    /**
     * Referenz der 'CommentEntity' zur 'BookEntity'.
     */
    @OneToMany(mappedBy = "fkBookId")
    private Collection<CommentEntity> commentEntityCollection;
    
    /**
     * Referenz der 'BookEntity' zur 'PublisherEntity'.
     */
    @JoinColumn(name = "FK_PUBLISHER_ID", referencedColumnName = "ID")
    @ManyToOne
    private PublisherEntity fkPublisherId;
    
    /**
     * Referenz der 'BookEntity' zur 'AuthorEntity'.
     */
    @JoinColumn(name = "FK_AUTHOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private AuthorEntity fkAuthorId;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public BookEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID einer Buch-Entität
     */
    public BookEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID des Buches
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID des Buches
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ISBN-13 zurück.
     * @return ISBN-13 des Buches
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     * Setzt die ISBN-13.
     * @param isbn13 ISBN-13 des Buches
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     * Liefert den Titel zurück.
     * @return Titel des Buches
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setzt den Titel.
     * @param title Titel des Buches
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Liefert die Auflage zurück.
     * @return Auflage des Buches
     */
    public Integer getEdition() {
        return edition;
    }

    /**
     * Setzt die Auflage.
     * @param edition Auflage des Buches
     */
    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    /**
     * Liefert das Veröffentlichungsjahr zurück.
     * @return Veröffentlichungsjahr des Buches
     */
    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    /**
     * Setzt das Veröffentlichungsjahr.
     * @param yearOfRelease Veröffentlichungsjahr des Buches
     */
    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    /**
     * Liefert die Sprache zurück.
     * @return Sprache des Buches
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Setzt die Sprache.
     * @param language Sprache des Buches
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Liefert die Seitenanzahl zurück.
     * @return Seitenanzahl des Buches
     */
    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Setzt die Seitenanzahl.
     * @param numberOfPages Seitenanzahl des Buches
     */
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Liefert den Preis zurück.
     * @return Preis des Buches
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Setzt den Preis.
     * @param price Preis des Buches
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Liefert die Anzahl zurück.
     * @return Anzahl des Buches
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Setzt die Anzahl.
     * @param quantity Anzahl des Buches
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Liefert Buchungsdetail-Entitäten zurück.
     * @return Buchungsdetails des Buches
     */
    @XmlTransient
    public Collection<BookingOrderDetailEntity> getBookingOrderDetailEntityCollection() {
        return bookingOrderDetailEntityCollection;
    }

    /**
     * Setzt Buchungsdetail-Entitäten.
     * @param bookingOrderDetailEntityCollection Buchungsdetails des Buches
     */
    public void setBookingOrderDetailEntityCollection(Collection<BookingOrderDetailEntity> bookingOrderDetailEntityCollection) {
        this.bookingOrderDetailEntityCollection = bookingOrderDetailEntityCollection;
    }

    /**
     * Liefert Kommentar-Entitäten zurück.
     * @return Kommentare des Buches
     */
    @XmlTransient
    public Collection<CommentEntity> getCommentEntityCollection() {
        return commentEntityCollection;
    }

    /**
     * Setzt Kommentar-Entitäten.
     * @param commentEntityCollection Kommentare des Buches
     */
    public void setCommentEntityCollection(Collection<CommentEntity> commentEntityCollection) {
        this.commentEntityCollection = commentEntityCollection;
    }

    /**
     * Liefert Verlags-Entität zurück.
     * @return Verlag des Buches
     */
    public PublisherEntity getFkPublisherId() {
        return fkPublisherId;
    }

    /**
     * Setzt Verlags-Entität.
     * @param fkPublisherId Verlag des Buches
     */
    public void setFkPublisherId(PublisherEntity fkPublisherId) {
        this.fkPublisherId = fkPublisherId;
    }

    /**
     * Liefert Autor-Entität zurück.
     * @return Autor des Buches
     */
    public AuthorEntity getFkAuthorId() {
        return fkAuthorId;
    }

    /**
     * Setzt Autor-Entität.
     * @param fkAuthorId Autor des Buches
     */
    public void setFkAuthorId(AuthorEntity fkAuthorId) {
        this.fkAuthorId = fkAuthorId;
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
     * Vergleicht 2 Buch-Entitäten miteinander.
     * @param object Buch-Entität
     * @return true für gleich, false für ungleich
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookEntity)) {
            return false;
        }
        BookEntity other = (BookEntity) object;
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
        return "de.th.wildau.webapp.buchladen.entities.BookEntity[ id=" + id + " ]";
    }
    
}
