/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Jan
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
    @NamedQuery(name = "BookEntity.findByNumberOfPages", query = "SELECT b FROM BookEntity b WHERE b.numberOfPages = :numberOfPages"),
    @NamedQuery(name = "BookEntity.findByPrice", query = "SELECT b FROM BookEntity b WHERE b.price = :price"),
    @NamedQuery(name = "BookEntity.findByQuantity", query = "SELECT b FROM BookEntity b WHERE b.quantity = :quantity")})
public class BookEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ISBN_13")
    private String isbn13;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "EDITION")
    private Integer edition;
    @Column(name = "NUMBER_OF_PAGES")
    private Integer numberOfPages;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @OneToMany(mappedBy = "fkBookId")
    private Collection<BookingOrderDetailEntity> bookingOrderDetailEntityCollection;
    @OneToMany(mappedBy = "fkBookId")
    private Collection<CommentEntity> commentEntityCollection;
    @JoinColumn(name = "FK_PUBLISHER_ID", referencedColumnName = "ID")
    @ManyToOne
    private PublisherEntity fkPublisherId;
    @JoinColumn(name = "FK_AUTHOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private AuthorEntity fkAuthorId;

    public BookEntity() {
    }

    public BookEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public Collection<BookingOrderDetailEntity> getBookingOrderDetailEntityCollection() {
        return bookingOrderDetailEntityCollection;
    }

    public void setBookingOrderDetailEntityCollection(Collection<BookingOrderDetailEntity> bookingOrderDetailEntityCollection) {
        this.bookingOrderDetailEntityCollection = bookingOrderDetailEntityCollection;
    }

    @XmlTransient
    public Collection<CommentEntity> getCommentEntityCollection() {
        return commentEntityCollection;
    }

    public void setCommentEntityCollection(Collection<CommentEntity> commentEntityCollection) {
        this.commentEntityCollection = commentEntityCollection;
    }

    public PublisherEntity getFkPublisherId() {
        return fkPublisherId;
    }

    public void setFkPublisherId(PublisherEntity fkPublisherId) {
        this.fkPublisherId = fkPublisherId;
    }

    public AuthorEntity getFkAuthorId() {
        return fkAuthorId;
    }

    public void setFkAuthorId(AuthorEntity fkAuthorId) {
        this.fkAuthorId = fkAuthorId;
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
        if (!(object instanceof BookEntity)) {
            return false;
        }
        BookEntity other = (BookEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.BookEntity[ id=" + id + " ]";
    }
    
}
