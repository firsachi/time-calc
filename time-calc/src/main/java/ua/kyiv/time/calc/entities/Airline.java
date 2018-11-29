/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.time.calc.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author firsov
 */
@Entity
@Table
public class Airline implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3503154267687059173L;

	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
	private UUID uuid;
    
    private String name;
    
    private String encoding;
    
    private String timeFrame;
    
    private String nuancesRegistration;
    
    private String selectionImprovedLocation;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}

	public String getNuancesRegistration() {
		return nuancesRegistration;
	}

	public void setNuancesRegistration(String nuancesRegistration) {
		this.nuancesRegistration = nuancesRegistration;
	}

	public String getSelectionImprovedLocation() {
		return selectionImprovedLocation;
	}

	public void setSelectionImprovedLocation(String selectionImprovedLocation) {
		this.selectionImprovedLocation = selectionImprovedLocation;
	}

}
