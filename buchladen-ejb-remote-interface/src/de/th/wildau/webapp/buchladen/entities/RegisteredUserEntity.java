/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.entities;

import org.apache.commons.codec.digest.DigestUtils;
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
 *
 * @author Jan
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
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 255)
    @Column(name = "STREET")
    private String street;
    @Size(max = 10)
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    @Size(max = 5)
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Size(max = 255)
    @Column(name = "CITY")
    private String city;
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<CommentEntity> commentEntityCollection;
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<BookingOrderEntity> bookingOrderEntityCollection;
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<PaymentTransferEntity> paymentTransferEntityCollection;
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<RegisteredUserGroupMappingEntity> registeredUserGroupMappingEntityCollection;
    @OneToMany(mappedBy = "fkRegisteredUserId")
    private Collection<PaymentCreditCardEntity> paymentCreditCardEntityCollection;

    public RegisteredUserEntity() {
    }

    public RegisteredUserEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.sha256Hex(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<CommentEntity> getCommentEntityCollection() {
        return commentEntityCollection;
    }

    public void setCommentEntityCollection(Collection<CommentEntity> commentEntityCollection) {
        this.commentEntityCollection = commentEntityCollection;
    }

    @XmlTransient
    public Collection<BookingOrderEntity> getBookingOrderEntityCollection() {
        return bookingOrderEntityCollection;
    }

    public void setBookingOrderEntityCollection(Collection<BookingOrderEntity> bookingOrderEntityCollection) {
        this.bookingOrderEntityCollection = bookingOrderEntityCollection;
    }

    @XmlTransient
    public Collection<PaymentTransferEntity> getPaymentTransferEntityCollection() {
        return paymentTransferEntityCollection;
    }

    public void setPaymentTransferEntityCollection(Collection<PaymentTransferEntity> paymentTransferEntityCollection) {
        this.paymentTransferEntityCollection = paymentTransferEntityCollection;
    }

    @XmlTransient
    public Collection<RegisteredUserGroupMappingEntity> getRegisteredUserGroupMappingEntityCollection() {
        return registeredUserGroupMappingEntityCollection;
    }

    public void setRegisteredUserGroupMappingEntityCollection(Collection<RegisteredUserGroupMappingEntity> registeredUserGroupMappingEntityCollection) {
        this.registeredUserGroupMappingEntityCollection = registeredUserGroupMappingEntityCollection;
    }

    @XmlTransient
    public Collection<PaymentCreditCardEntity> getPaymentCreditCardEntityCollection() {
        return paymentCreditCardEntityCollection;
    }

    public void setPaymentCreditCardEntityCollection(Collection<PaymentCreditCardEntity> paymentCreditCardEntityCollection) {
        this.paymentCreditCardEntityCollection = paymentCreditCardEntityCollection;
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
        if (!(object instanceof RegisteredUserEntity)) {
            return false;
        }
        RegisteredUserEntity other = (RegisteredUserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity[ id=" + id + " ]";
    }
    
}
