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

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Entity
@Table(name = "PUBLISHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PublisherEntity.findAll", query = "SELECT p FROM PublisherEntity p"),
    @NamedQuery(name = "PublisherEntity.findById", query = "SELECT p FROM PublisherEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PublisherEntity.findByPublisherName", query = "SELECT p FROM PublisherEntity p WHERE p.publisherName = :publisherName")})
public class PublisherEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'publisher'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * Verlagsname der Tabelle 'publisher'.
     */
    @Size(max = 255)
    @Column(name = "PUBLISHER_NAME")
    private String publisherName;
    @OneToMany(mappedBy = "fkPublisherId")
    private Collection<BookEntity> bookEntityCollection;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public PublisherEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID einer Verlag-Entität
     */
    public PublisherEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID des Verlages
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID des Verlages.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert den Verlagsnamen zurück.
     * @return Verlagsname des Verlages
     */
    public String getPublisherName() {
        return publisherName;
    }

    /**
     * Setzt den Verlagsnamen.
     * @param publisherName Verlagsname des Verlages
     */
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    /**
     * Liefert Buch-Entitäten zurück.
     * @return Bücher des Verlages
     */
    @XmlTransient
    public Collection<BookEntity> getBookEntityCollection() {
        return bookEntityCollection;
    }

    /**
     * Setzt Buch-Entitäten.
     * @param bookEntityCollection Bücher des Verlages
     */
    public void setBookEntityCollection(Collection<BookEntity> bookEntityCollection) {
        this.bookEntityCollection = bookEntityCollection;
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
        if (!(object instanceof PublisherEntity)) {
            return false;
        }
        PublisherEntity other = (PublisherEntity) object;
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
        return "de.th.wildau.webapp.buchladen.entities.PublisherEntity[ id=" + id + " ]";
    }
    
}
