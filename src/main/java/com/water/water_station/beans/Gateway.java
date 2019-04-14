package com.water.water_station.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gateway_SD")
public class Gateway {
 
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
	 
	@Column(name = "ip", columnDefinition="VARCHAR(128)")
    private String ip;
	 
	@Column(name = "port", columnDefinition="int")
	private int port;
	
	@Column(name = "db_name", columnDefinition="VARCHAR(64)")
	private String db_name;
	
	@Column(name = "db_user", columnDefinition="VARCHAR(64)")
    private String db_user;
	
	@Column(name = "db_password", columnDefinition="VARCHAR(64)")
    private String db_password;
	
	@Column(name = "type", columnDefinition="VARCHAR(64)")
    private String type;
	
	@Column(name = "license", columnDefinition="BLOB")
    private String license;
	
	@Column(name = "date", columnDefinition="DATE")
    private Date date;
	
	@Column(name = "caracteristique_SD_id", columnDefinition="int")
	private int caract;

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
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the db_name
	 */
	public String getDb_name() {
		return db_name;
	}

	/**
	 * @param db_name the db_name to set
	 */
	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}

	/**
	 * @return the db_user
	 */
	public String getDb_user() {
		return db_user;
	}

	/**
	 * @param db_user the db_user to set
	 */
	public void setDb_user(String db_user) {
		this.db_user = db_user;
	}

	/**
	 * @return the db_password
	 */
	public String getDb_password() {
		return db_password;
	}

	/**
	 * @param db_password the db_password to set
	 */
	public void setDb_password(String db_password) {
		this.db_password = db_password;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * @param license the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the caract
	 */
	public int getCaract() {
		return caract;
	}

	/**
	 * @param caract the caract to set
	 */
	public void setCaract(int caract) {
		this.caract = caract;
	}
 }