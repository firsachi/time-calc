/**
 * 
 */
package ua.kyiv.time.calc.configuratin.programfolder;

/**
 * @author firsachi
 *
 */
public class LinuxPach implements PachProgram {

	private final String APPLICATION_FOLDER = "/.TimeCalc/";

	@Override
	public String getPachDetabase() {
		return System.getProperty("user.home") + APPLICATION_FOLDER;
	}

}
