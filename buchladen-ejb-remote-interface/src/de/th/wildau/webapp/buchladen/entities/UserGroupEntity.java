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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "USER_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGroupEntity.findAll", query = "SELECT u FROM UserGroupEntity u"),
    @NamedQuery(name = "UserGroupEntity.findById", query = "SELECT u FROM UserGroupEntity u WHERE u.id = :id"),
    @NamedQuery(name = "UserGroupEntity.findByGroupName", query = "SELECT u FROM UserGroupEntity u WHERE u.groupName = :groupName")})
public class UserGroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "GROUP_NAME")
    private String groupName;
    @OneToMany(mappedBy = "fkUserGroupId")
    private Collection<RegisteredUserGroupMappingEntity> registeredUserGroupMappingEntityCollection;

    public UserGroupEntity() {
    }

    public UserGroupEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlTransient
    public Collection<RegisteredUserGroupMappingEntity> getRegisteredUserGroupMappingEntityCollection() {
        return registeredUserGroupMappingEntityCollection;
    }

    public void setRegisteredUserGroupMappingEntityCollection(Collection<RegisteredUserGroupMappingEntity> registeredUserGroupMappingEntityCollection) {
        this.registeredUserGroupMappingEntityCollection = registeredUserGroupMappingEntityCollection;
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
        if (!(object instanceof UserGroupEntity)) {
            return false;
        }
        UserGroupEntity other = (UserGroupEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.UserGroupEntity[ id=" + id + " ]";
    }
    
}
