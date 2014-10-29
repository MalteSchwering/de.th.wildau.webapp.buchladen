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
@Table(name = "PUBLISHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PublisherEntity.findAll", query = "SELECT p FROM PublisherEntity p"),
    @NamedQuery(name = "PublisherEntity.findById", query = "SELECT p FROM PublisherEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PublisherEntity.findByPublisherName", query = "SELECT p FROM PublisherEntity p WHERE p.publisherName = :publisherName")})
public class PublisherEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PUBLISHER_NAME")
    private String publisherName;
    @OneToMany(mappedBy = "fkPublisherId")
    private Collection<BookEntity> bookEntityCollection;

    public PublisherEntity() {
    }

    public PublisherEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @XmlTransient
    public Collection<BookEntity> getBookEntityCollection() {
        return bookEntityCollection;
    }

    public void setBookEntityCollection(Collection<BookEntity> bookEntityCollection) {
        this.bookEntityCollection = bookEntityCollection;
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
        if (!(object instanceof PublisherEntity)) {
            return false;
        }
        PublisherEntity other = (PublisherEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.PublisherEntity[ id=" + id + " ]";
    }
    
}
