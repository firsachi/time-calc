/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.time.calc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	private String name;

	private String timeFrame;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}

}
