/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserGroupMappingEntity;
import de.th.wildau.webapp.buchladen.entities.UserGroupEntity;
import de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.RegisteredUserGroupMappingEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.UserGroupEntityFacadeRemote;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Jan
 */
public class RegisteredUserManagedBean implements Serializable {
    @EJB
    private UserGroupEntityFacadeRemote userGroupEntityFacade;
    @EJB
    private RegisteredUserGroupMappingEntityFacadeRemote registeredUserGroupMappingEntityFacade;
    
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    
    @EJB
    private RegisteredUserEntityFacadeRemote registeredUserEntityFacade;

    /**
     * Creates a new instance of RegisteredUserManagedBean
     */
    public RegisteredUserManagedBean() {
    }
    
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
        this.password = password;
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
    
}
