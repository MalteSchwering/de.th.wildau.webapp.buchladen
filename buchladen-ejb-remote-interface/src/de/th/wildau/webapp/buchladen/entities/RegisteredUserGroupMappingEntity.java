/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Jan
 */
@Entity
@Table(name = "REGISTERED_USER_GROUP_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegisteredUserGroupMappingEntity.findAll", query = "SELECT r FROM RegisteredUserGroupMappingEntity r"),
    @NamedQuery(name = "RegisteredUserGroupMappingEntity.findById", query = "SELECT r FROM RegisteredUserGroupMappingEntity r WHERE r.id = :id")})
public class RegisteredUserGroupMappingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "FK_USER_GROUP_ID", referencedColumnName = "ID")
    @ManyToOne
    private UserGroupEntity fkUserGroupId;
    @JoinColumn(name = "FK_REGISTERED_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private RegisteredUserEntity fkRegisteredUserId;

    public RegisteredUserGroupMappingEntity() {
    }

    public RegisteredUserGroupMappingEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserGroupEntity getFkUserGroupId() {
        return fkUserGroupId;
    }

    public void setFkUserGroupId(UserGroupEntity fkUserGroupId) {
        this.fkUserGroupId = fkUserGroupId;
    }

    public RegisteredUserEntity getFkRegisteredUserId() {
        return fkRegisteredUserId;
    }

    public void setFkRegisteredUserId(RegisteredUserEntity fkRegisteredUserId) {
        this.fkRegisteredUserId = fkRegisteredUserId;
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
        if (!(object instanceof RegisteredUserGroupMappingEntity)) {
            return false;
        }
        RegisteredUserGroupMappingEntity other = (RegisteredUserGroupMappingEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.RegisteredUserGroupMappingEntity[ id=" + id + " ]";
    }
    
}
