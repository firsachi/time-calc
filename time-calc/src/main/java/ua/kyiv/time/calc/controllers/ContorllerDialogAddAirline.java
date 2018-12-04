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

/**
 * @author firsov
 *
 */
public class ContorllerDialogAddAirline implements Initializable{
	
	
	private AirlineDao airlineDao;
	private Airline airline;
	
	@FXML
	private TextField id;
	
	@FXML
	private Label nameAirline;
	
	private TextField nameAirlane;
	
	@FXML
	private TextField timeFrame;
	
	@FXML
	private Button butoonOk;
	
	@FXML
	private Button buttonCancel;
	
	@FXML
	private Label errorNameAirline;
	
	{
		airline = new Airline();
		airlineDao = new AirlineDao();
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	@FXML
	private void actionButtonOK(ActionEvent event) {
		Airline tmp = new Airline();
		tmp.setId(new Integer(id.getText()));
		tmp.setName(nameAirlane.getText());
		tmp.setTimeFrame(new Integer(timeFrame.getText()));
		if(null == airlineDao.findName(nameAirlane.getText())) {
			airlineDao.add(tmp);
			actionButtonCancel();
		}else {
			nameAirline.setStyle("-fx-text-fill: red");
			errorNameAirline.setText("%key.errorNameAirline");
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
