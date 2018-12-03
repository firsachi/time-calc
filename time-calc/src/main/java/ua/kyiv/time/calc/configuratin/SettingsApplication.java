/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.time.calc.configuratin;

import java.util.Locale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ua.kyiv.time.calc.configuratin.programfolder.FolederProgramm;
import ua.kyiv.time.calc.dao.AirlineDao;
import ua.kyiv.time.calc.entities.Airline;

/**
 *
 * @author firsov
 */
public class SettingsApplication {

	public final static String DATABSE_APPLICATION_NAME = "TimeCalc.db";

	public final static String USER_APLICATION_FOLDER;

	private static ObservableList<Airline> observableListAirline = FXCollections.observableArrayList();
	
	private static Locale locale;

	static {
		FolederProgramm folder = new FolederProgramm();
		USER_APLICATION_FOLDER = folder.pachProgamm();
		locale = new Locale("uk");
		observableListAirline.addAll(new AirlineDao().all());
	}

	public static Locale getLocale() {
		return locale;
	}

	public static ObservableList<Airline> getObservableList() {
		return observableListAirline;
	}

	public static ObservableList<Airline> getObservableListAirline() {
		return observableListAirline;
	}

	public static void setObservableListAirline(ObservableList<Airline> observableListAirline) {
		SettingsApplication.observableListAirline = observableListAirline;
	}

	public static void setObservableAirline(Airline airline) {
		observableListAirline.add(airline);
	}

}
