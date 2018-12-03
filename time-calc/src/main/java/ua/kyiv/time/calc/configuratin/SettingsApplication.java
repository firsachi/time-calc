/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.time.calc.configuratin;

import java.util.Locale;

import ua.kyiv.time.calc.configuratin.programfolder.FolederProgramm;

/**
 *
 * @author firsov
 */
public class SettingsApplication {

	public final static String DATABSE_APPLICATION_NAME = "TimeCalc.db";

	public final static String USER_APLICATION_FOLDER;

	private static Locale locale;

	static {
		FolederProgramm folder = new FolederProgramm();
		USER_APLICATION_FOLDER = folder.pachProgamm();
		locale = new Locale("uk");
	}

	public static Locale getLocale() {
		return locale;
	}

}
