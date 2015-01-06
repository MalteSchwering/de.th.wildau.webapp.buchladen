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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Entity
@Table(name = "COMMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommentEntity.findAll", query = "SELECT c FROM CommentEntity c"),
    @NamedQuery(name = "CommentEntity.findById", query = "SELECT c FROM CommentEntity c WHERE c.id = :id"),
    @NamedQuery(name = "CommentEntity.findByBookId", query = "SELECT c FROM CommentEntity c WHERE c.fkBookId.id = :bookId"),
    @NamedQuery(name = "CommentEntity.findByCommentText", query = "SELECT c FROM CommentEntity c WHERE c.commentText = :commentText")})
public class CommentEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'comment'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * Kommentartext der Tabelle 'comment'.
     */
    @Size(max = 250)
    @Column(name = "COMMENT_TEXT")
    private String commentText;
    
    /**
     * Referenz der 'CommentEntity' zur 'RegisteredUserEntity'.
     */
    @JoinColumn(name = "FK_REGISTERED_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private RegisteredUserEntity fkRegisteredUserId;
    
    /**
     * Referenz der 'CommentEntity' zur 'BookEntity'.
     */
    @JoinColumn(name = "FK_BOOK_ID", referencedColumnName = "ID")
    @ManyToOne
    private BookEntity fkBookId;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public CommentEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID einer Kommentar-Entität
     */
    public CommentEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID des Kommentars
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID des Kommentars
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert den Kommentartext zurück.
     * @return Kommentartext des Kommentars
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * Setzt den Kommentartext.
     * @param commentText Kommentartext des Kommentars
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    /**
     * Liefert Benutzer-Entität zurück.
     * @return Benutzer-Entität des Kommentars
     */
    public RegisteredUserEntity getFkRegisteredUserId() {
        return fkRegisteredUserId;
    }

    /**
     * Setzt Benutzer-Entität.
     * @param fkRegisteredUserId Benutzer-Entität des Kommentars
     */
    public void setFkRegisteredUserId(RegisteredUserEntity fkRegisteredUserId) {
        this.fkRegisteredUserId = fkRegisteredUserId;
    }

    /**
     * Liefert Buch-Entität zurück.
     * @return Buch-Entität des Kommentars
     */
    public BookEntity getFkBookId() {
        return fkBookId;
    }

    /**
     * Setzt die Buch-Entität.
     * @param fkBookId Buch-Entität des Kommentars
     */
    public void setFkBookId(BookEntity fkBookId) {
        this.fkBookId = fkBookId;
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
     * Vergleicht 2 Kommentar-Entitäten miteinander.
     * @param object Kommentar-Entitäten
     * @return true für gleich, false für ungleich
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentEntity)) {
            return false;
        }
        CommentEntity other = (CommentEntity) object;
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
        return "de.th.wildau.webapp.buchladen.entities.CommentEntity[ id=" + id + " ]";
    }
    
}
