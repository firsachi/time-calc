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
import javafx.scene.control.TextField;
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
	private TextField nameAirlane;
	
	@FXML
	private TextField timeFrame;
	
	@FXML
	private Button butoonOk;
	
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
		airlineDao.add(tmp);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id.setText(Integer.toString(airline.getId()));
		nameAirlane.setText(airline.getName());
		timeFrame.setText(Integer.toString(airline.getTimeFrame()));
	}

}
