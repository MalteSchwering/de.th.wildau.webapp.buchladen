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
@Table(name = "AUTHOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthorEntity.findAll", query = "SELECT a FROM AuthorEntity a"),
    @NamedQuery(name = "AuthorEntity.findById", query = "SELECT a FROM AuthorEntity a WHERE a.id = :id"),
    @NamedQuery(name = "AuthorEntity.findByFirstName", query = "SELECT a FROM AuthorEntity a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "AuthorEntity.findByLastName", query = "SELECT a FROM AuthorEntity a WHERE a.lastName = :lastName")})
public class AuthorEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'author'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * Vorname der Tabelle 'author'.
     */
    @Size(max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    /**
     * Nachname der Tabelle 'author'.
     */
    @Size(max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    /**
     * Referenz der 'BookEntity' zur 'AuthorEntity'.
     */
    @OneToMany(mappedBy = "fkAuthorId")
    private Collection<BookEntity> bookEntityCollection;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public AuthorEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID einer Autor-Entität
     */
    public AuthorEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID des Autors
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID des Autors
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert den Vornamen zurück.
     * @return Vorname des Autors
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setzt den Vornamen.
     * @param firstName Vorname des Autors
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Liefert den Nachnamen zurück.
     * @return Nachname des Autors
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setzt den Nachnamen.
     * @param lastName Nachname des Autors
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Liefert Buch-Entitäten zurück.
     * @return Buch-Entitäten des Autors
     */
    @XmlTransient
    public Collection<BookEntity> getBookEntityCollection() {
        return bookEntityCollection;
    }

    /**
     * Setzt Buch-Entitäten.
     * @param bookEntityCollection Buch-Entitäten des Autors
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
     * Vergleicht 2 Autoren-Entitäten miteinander.
     * @param object Autor-Entität
     * @return true für gleich, false für ungleich
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorEntity)) {
            return false;
        }
        AuthorEntity other = (AuthorEntity) object;
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
        return "de.th.wildau.webapp.buchladen.entities.AuthorEntity[ id=" + id + " ]";
    }
    
}
