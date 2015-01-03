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
@Table(name = "USER_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGroupEntity.findAll", query = "SELECT u FROM UserGroupEntity u"),
    @NamedQuery(name = "UserGroupEntity.findById", query = "SELECT u FROM UserGroupEntity u WHERE u.id = :id"),
    @NamedQuery(name = "UserGroupEntity.findByGroupName", query = "SELECT u FROM UserGroupEntity u WHERE u.groupName = :groupName")})
public class UserGroupEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'user_group'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * Gruppenname der Tabelle 'user_group'.
     */
    @Size(max = 255)
    @Column(name = "GROUP_NAME")
    private String groupName;
    
    /**
     * Referenz der 'RegisteredUserGroupMappingEntity' zur 'UserGroupEntity'.
     */
    @OneToMany(mappedBy = "fkUserGroupId")
    private Collection<RegisteredUserGroupMappingEntity> registeredUserGroupMappingEntityCollection;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public UserGroupEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID einer Benutzer-Gruppe
     */
    public UserGroupEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID der Benutzer-Gruppe
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID der Benutzer-Gruppe
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert den Gruppennamen zurück.
     * @return Gruppenname der Benutzer-Gruppe
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Setzt den Gruppennamen.
     * @param groupName Gruppenname der Benutzer-Gruppe
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Liefert Entitäten von Benutzer/Benutzer-Gruppen Zuordnungen zurück.
     * @return Entitäten von Benutzer/Benutzer-Gruppen Zuordnungen
     */
    @XmlTransient
    public Collection<RegisteredUserGroupMappingEntity> getRegisteredUserGroupMappingEntityCollection() {
        return registeredUserGroupMappingEntityCollection;
    }

    /**
     * Setzt Entitäten von Benutzer/Benutzer-Gruppen Zuordnungen.
     * @param registeredUserGroupMappingEntityCollection Entitäten von Benutzer/Benutzer-Gruppen Zuordnungen
     */
    public void setRegisteredUserGroupMappingEntityCollection(Collection<RegisteredUserGroupMappingEntity> registeredUserGroupMappingEntityCollection) {
        this.registeredUserGroupMappingEntityCollection = registeredUserGroupMappingEntityCollection;
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
     * Vergleicht 2 Benutzer-Gruppen-Entitäten miteinander.
     * @param object Benutzer-Gruppe
     * @return true für gleich, false für ungleich
     */
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

    /**
     * Liefert einen String mit der ID der Entität zurück.
     * @return String mit der ID der Entität
     */
    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.UserGroupEntity[ id=" + id + " ]";
    }
    
}
