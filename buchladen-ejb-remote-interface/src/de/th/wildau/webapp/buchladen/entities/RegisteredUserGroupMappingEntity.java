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
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Entity
@Table(name = "REGISTERED_USER_GROUP_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegisteredUserGroupMappingEntity.findAll", query = "SELECT r FROM RegisteredUserGroupMappingEntity r"),
    @NamedQuery(name = "RegisteredUserGroupMappingEntity.findById", query = "SELECT r FROM RegisteredUserGroupMappingEntity r WHERE r.id = :id")})
public class RegisteredUserGroupMappingEntity implements Serializable {
    
    /**
     * Versionsnummer der Serialisierung.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Auto increment ID der Tabelle 'registered_user_group_mapping'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    /**
     * Referenz der 'RegisteredUserGroupMappingEntity' zur 'UserGroupEntity'.
     */
    @JoinColumn(name = "FK_USER_GROUP_ID", referencedColumnName = "ID")
    @ManyToOne
    private UserGroupEntity fkUserGroupId;
    
    /**
     * Referenz der 'RegisteredUserGroupMappingEntity' zur 'RegisteredUserEntity'.
     */
    @JoinColumn(name = "FK_REGISTERED_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private RegisteredUserEntity fkRegisteredUserId;

    /**
     * Konstruktor der Entitäten-Klasse.
     */
    public RegisteredUserGroupMappingEntity() {
    }

    /**
     * Konstruktor der Entitäten-Klasse.
     * @param id ID der Benutzer/Benutzer-Gruppen Zuordnungs-Entität
     */
    public RegisteredUserGroupMappingEntity(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die ID zurück.
     * @return ID der Benutzer/Benutzer-Gruppen Zuordnung
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param id ID der Benutzer/Benutzer-Gruppen Zuordnung
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Liefert die Benutzer-Gruppen-Entität zurück.
     * @return Benutzer-Gruppe der Benutzer/Benutzer-Gruppen Zuordnung
     */
    public UserGroupEntity getFkUserGroupId() {
        return fkUserGroupId;
    }

    /**
     * Setzt die Benutzer-Gruppen-Entität.
     * @param fkUserGroupId Benutzer-Gruppe der Benutzer/Benutzer-Gruppen Zuordnung
     */
    public void setFkUserGroupId(UserGroupEntity fkUserGroupId) {
        this.fkUserGroupId = fkUserGroupId;
    }

    /**
     * Liefert die Benutzer-Entität zurück.
     * @return Benutzer der Benutzer/Benutzer-Gruppen Zuordnung
     */
    public RegisteredUserEntity getFkRegisteredUserId() {
        return fkRegisteredUserId;
    }

    /**
     * Setzt die Benutzer-Entität.
     * @param fkRegisteredUserId Benutzer der Benutzer/Benutzer-Gruppen Zuordnung
     */
    public void setFkRegisteredUserId(RegisteredUserEntity fkRegisteredUserId) {
        this.fkRegisteredUserId = fkRegisteredUserId;
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
     * Vergleicht 2 Benutzer/Benutzer-Gruppen Zuordnungs-Entitäten miteinander.
     * @param object Benutzer/Benutzer-Gruppen Zuordnungs-Entität
     * @return true für gleich, false für ungleich
     */
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

    /**
     * Liefert einen String mit der ID der Entität zurück.
     * @return String mit der ID der Entität
     */
    @Override
    public String toString() {
        return "de.th.wildau.webapp.buchladen.entities.RegisteredUserGroupMappingEntity[ id=" + id + " ]";
    }
    
}
