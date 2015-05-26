package com.jpa.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CONTACT")
@NamedQueries({
        @NamedQuery(name="getContactsByUserId", query="SELECT c FROM Contact c WHERE c.userId =:userId"),
        @NamedQuery(name="getContactByPlatformId", query="SELECT distinct c FROM Contact c WHERE c.platformId =:platformId")
})
public class Contact implements Serializable {

    @Id
    @Column(name="CNTC_ID")
    private String contactId;

    @Column(name="USER_ID")
    private String userId;

    @Column(name="PLTF_ID")
    private String platformId;

    @Column(name="SELF")
    private String isSelf;

    @Column(name="CNTC_TYPE")
    private String contactType;

    @Column(name="FRST_NAME")
    private String firstName;

    @Column(name="MIDD_NAME")
    private String middleName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="FORM_NAME")
    private String formattedName;

    @Column(name="ORGN_NAME")
    private String contactOrganization;

    @Column(name="IMAG_URL")
    private String contactPictureURL;

    @Column(name="FVRT")
    private String isFavorite;

    @Column(name="MDFY_DATE")
    private Timestamp modifyDate;


    public String getId() {
        return contactId;
    }

    public void setId(String contactId) {
        this.contactId = contactId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getSelf() {
        return isSelf;
    }

    public void setSelf(String self) {
        isSelf = self;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    public String getContactOrganization() {
        return contactOrganization;
    }

    public void setContactOrganization(String contactOrganization) {
        this.contactOrganization = contactOrganization;
    }

    public String getContactPictureURL() {
        return contactPictureURL;
    }

    public void setContactPictureURL(String contactPictureURL) {
        this.contactPictureURL = contactPictureURL;
    }

    public String getFavorite() {
        return isFavorite;
    }

    public void setFavorite(String favorite) {
        isFavorite = favorite;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

}
