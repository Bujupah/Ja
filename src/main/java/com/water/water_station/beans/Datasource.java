package com.water.water_station.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="datasource_SD")
public class Datasource{
     
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "label", columnDefinition="VARCHAR(128)")
    private String label;

    @Column(name = "longitude", columnDefinition="FLOAT")
    private float longitude;
    
    @Column(name = "latitude", columnDefinition="FLOAT")
    private float latitude;
    
    @Column(name = "ip", columnDefinition="int")
    private int ip;
    
    @Column(name = "port", columnDefinition="VARCHAR(128)")
    private String port;
    
    @Column(name = "etat", columnDefinition="VARCHAR(128)")
    private String etat;
    
    @Column(name = "date_mem", columnDefinition="DATE")
    private Date date_mem;
    
    @Column(name = "caracteristique_SD_id", columnDefinition="int")
	private int caracteristique_SD_id;

    @Column(name = "gateway_SD_id", columnDefinition="int")
	private int gateway_SD_id;

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
     * @return the longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the ip
     */
    public int getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(int ip) {
        this.ip = ip;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * @return the date_mem
     */
    public Date getDate_mem() {
        return date_mem;
    }

    /**
     * @param date_mem the date_mem to set
     */
    public void setDate_mem(Date date_mem) {
        this.date_mem = date_mem;
    }

    /**
     * @return the caracteristique_SD_id
     */
    public int getCaracteristique_SD_id() {
        return caracteristique_SD_id;
    }

    /**
     * @param caracteristique_SD_id the caracteristique_SD_id to set
     */
    public void setCaracteristique_SD_id(int caracteristique_SD_id) {
        this.caracteristique_SD_id = caracteristique_SD_id;
    }

    /**
     * @return the gateway_SD_id
     */
    public int getGateway_SD_id() {
        return gateway_SD_id;
    }

    /**
     * @param gateway_SD_id the gateway_SD_id to set
     */
    public void setGateway_SD_id(int gateway_SD_id) {
        this.gateway_SD_id = gateway_SD_id;
    }


}