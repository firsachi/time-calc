/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.time.calc.configuratin.programfolder;

import java.io.File;

/**
 *
 * @author firsov
 */
public class WindowsPach implements PachProgram{
    
    private final String FOLDER_APPLICATION = "\\TimeCalc\\";

    @Override
    public String getPachDetabase() {
        String path = System.getenv("APPDATA") + FOLDER_APPLICATION;
        File pathFile = new File(path);
        pathFile.mkdirs();
        return path;
    }
    
    
    
}
