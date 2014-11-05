package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserGroupMappingEntity;
import de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.RegisteredUserGroupMappingEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.UserGroupEntityFacadeRemote;
import java.io.Serializable;
import javax.ejb.EJB;

public class RegisteredUserManagedBean implements Serializable {
    
    /**
     * Enterprise Java Bean userGroupEntityFacade mit einem Remote Interface.
     */
    @EJB
    private UserGroupEntityFacadeRemote userGroupEntityFacade;
    
    /**
     * Enterprise Java Bean registeredUserGroupMappingEntityFacade mit einem Remote Interface.
     */
    @EJB
    private RegisteredUserGroupMappingEntityFacadeRemote registeredUserGroupMappingEntityFacade;
    
    /**
     * Enterprise Java Bean registeredUserEntityFacade mit einem Remote Interface.
     */
    @EJB
    private RegisteredUserEntityFacadeRemote registeredUserEntityFacade;
    
    /**
     * Die E-Mail Adresse des Benutzers.
     */
    private String emailAddress;
    
    /**
     * Das Passwort des Benutzers.
     */
    private String password;
    
    /**
     * Der Vorname des Benutzers.
     */
    private String firstName;
    
    /**
     * Der Nachname des Benutzers.
     */
    private String lastName;
    
    /**
     * Die Straße in der der Benutzer wohnt.
     */
    private String street;
    
    /**
     * Die Hausnummer in der der Benutzer wohnt.
     */
    private String houseNumber;
    
    /**
     * Postleitzahl des Wohnorts des Benutzers.
     */
    private String zipCode;
    
    /**
     * Name der Stadt in der der Benutzer wohnt.
     */
    private String city;
    
    /**
     * Der Benutzer mit der Benutzergruppe 'User' wird angelegt.
     */
    public void registerUser() {
        RegisteredUserEntity registeredUserEntity = new RegisteredUserEntity();
        registeredUserEntity.setEmailAddress(this.emailAddress);
        registeredUserEntity.setPassword(this.password);
        registeredUserEntity.setFirstName(this.firstName);
        registeredUserEntity.setLastName(this.lastName);
        registeredUserEntity.setStreet(this.street);
        registeredUserEntity.setHouseNumber(this.houseNumber);
        registeredUserEntity.setZipCode(this.zipCode);
        registeredUserEntity.setCity(this.city);
        registeredUserEntityFacade.create(registeredUserEntity);
        RegisteredUserGroupMappingEntity registeredUserGroupMappingEntity = new RegisteredUserGroupMappingEntity();
        registeredUserGroupMappingEntity.setFkRegisteredUserId(registeredUserEntityFacade.findByEmailAddress(this.emailAddress));
        registeredUserGroupMappingEntity.setFkUserGroupId(userGroupEntityFacade.findByGroupName("user"));
        registeredUserGroupMappingEntityFacade.create(registeredUserGroupMappingEntity);
    }

    /**
     * Liefert die E-Mail Adresse zurück.
     * @return E-Mail Adresse des Benutzers
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setzt die E-Mail Adresse.
     * @param emailAddress E-Mail Adresse des Benutzers
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Liefert das Password zurück.
     * @return Passwort des Benutzers
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setzt das Password.
     * @param password Passwort des Benutzers
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Liefert den Vornamen zurück.
     * @return Vorname des Benutzers
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setzt den Vornamen.
     * @param firstName Vorname des Benutzers
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Liefert den Nachnamen zurück.
     * @return Nachname des Benutzers
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setzt den Nachnamen.
     * @param lastName Nachname des Benutzers
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Liefert die Straße zurück.
     * @return Straße des Benutzers
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setzt die Straße.
     * @param street Straße des Benutzers
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Liefert die Hausnummer zurück.
     * @return Hausnummer des Benutzers
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Setzt die Hausnummer.
     * @param houseNumber Hausnummer des Benutzers
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Liefert die Postleitzahl zurück.
     * @return Postleitzahl des Benutzers
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setzt die Postleitzahl.
     * @param zipCode Postleitzahl des Benutzers
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Liefert die Stadt zurück.
     * @return Stadt des Benutzers
     */
    public String getCity() {
        return city;
    }

    /**
     * Setzt die Stadt.
     * @param city Stadt des Benutzers
     */
    public void setCity(String city) {
        this.city = city;
    }
    
}
