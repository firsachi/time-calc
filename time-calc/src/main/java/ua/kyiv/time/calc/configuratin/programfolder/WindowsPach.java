/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.time.calc.configuratin.programfolder;

/**
 *
 * @author firsov
 */
public class WindowsPach implements PachProgram{
    
    private final String FOLDER_APPLICATION = "\\TimeCalc\\";

    @Override
    public String getPachDetabase() {
        return System.getenv("APPDATA") + FOLDER_APPLICATION;
    }
      
}
