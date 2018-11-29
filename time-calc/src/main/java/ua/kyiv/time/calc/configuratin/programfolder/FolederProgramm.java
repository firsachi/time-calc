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
public class FolederProgramm {
    
    private PachProgram pachProgramm;
    private final String NAME_OS = "windows";
    private String pach;
    
      public String pachProgamm(){
        String os = System.getProperty("os.name").split(" ")[0].toLowerCase();
        if (os.equals(NAME_OS)){
            pachProgramm = new WindowsPach();
            pach = pachProgramm.getPachDetabase();
        }else{
            pachProgramm = new LinuxPach();
            pach = pachProgramm.getPachDetabase();
        }
        mkdir(pach);
        return pach;
    }
    
    private void mkdir(String pach) {
    	File pathFile = new File(pach);
        pathFile.mkdirs();
    }
    
}
