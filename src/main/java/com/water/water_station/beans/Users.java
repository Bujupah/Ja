package com.water.water_station.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="user_SD")
public class Users {
    @Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "label", columnDefinition="VARCHAR(128)")
    private String label;
    
    @Column(name = "username", columnDefinition="VARCHAR(128)")
    private String username;
    
    @Column(name = "password", columnDefinition="VARCHAR(128)")
    private String password;
    
    @Column(name = "email", columnDefinition="VARCHAR(128)")
    private String email;
    
    @Column(name = "photo", columnDefinition="LONGBLOB")
    private Blob photo;
    
    @Column(name = "telephone", columnDefinition="VARCHAR(128)")
    private String telephone;
    
    @Column(name = "type", columnDefinition="int")
    private String role;
    
    @Column(name = "client_SD_id", columnDefinition="int")
	private String client_sd_id;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the photo
     */
    @Lob
    public Blob getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    
    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the client_sd_id
     */
    public String getClient_sd_id() {
        return client_sd_id;
    }

    /**
     * @param client_sd_id the client_sd_id to set
     */
    public void setClient_sd_id(String client_sd_id) {
        this.client_sd_id = client_sd_id;
    }

}