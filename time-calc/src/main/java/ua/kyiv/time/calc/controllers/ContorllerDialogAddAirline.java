/**
 * 
 */
package ua.kyiv.time.calc.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ua.kyiv.time.calc.dao.AirlineDao;
import ua.kyiv.time.calc.entities.Airline;
import ua.kyiv.time.calc.validators.ValidatorForm;

/**
 * @author firsov
 *
 */
public class ContorllerDialogAddAirline implements Initializable{
	
	
	private AirlineDao airlineDao = new AirlineDao();
	
	private ValidatorForm validatorForm = new ValidatorForm(); 
	
	private Airline airline;
	
	@FXML
	private TextField textFiledId;
	
	@FXML
	private Label labelNameAirline;
	
	@FXML
	TextField textFiledNameAirline;
	
	@FXML
	private TextField textFiledTimeFrame;
	
	@FXML
	private Button buttonOk;
	
	@FXML
	private Button buttonCancel;
	
	@FXML
	private Label errorNameAirline;
	
	{
		airline = new Airline();
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	@FXML
	private void actionButtonOK(ActionEvent event) {		
		boolean name = validatorForm.textFiledNotEmpty(textFiledNameAirline, errorNameAirline, "jgdfjgl");
	//	boolean validTime = validatorForm.textFiledNotEmpty(textFiledTimeFrame, )
		if(name) {
			Airline tmp = new Airline();
			tmp.setId(new Integer(textFiledId.getText()));
			tmp.setName(textFiledNameAirline.getText());
			tmp.setTimeFrame(new Integer(textFiledTimeFrame.getText()));
			if(null == airlineDao.findName(tmp.getName())) {
				airlineDao.add(tmp);
				actionButtonCancel();
			}else {
				labelNameAirline.setStyle("-fx-text-fill: red;");
				errorNameAirline.setText("%key.errorNameAirline");
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	@FXML
    private void actionButtonCancel(){
		Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

}
