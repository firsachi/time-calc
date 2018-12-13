/**
 * 
 */
package ua.kyiv.time.calc.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	
	
	private AirlineDao airlineDao = new AirlineDao();
	
	private ObservableList<Airline> modelAirlinesTable;
	
	private Airline airline;
	
	private ComboBox<Airline> airlines;
	
	@FXML
	private TextField textFiledId;
	
	@FXML
	private Label labelNameAirline;
	
	@FXML
	private TextField textFiledNameAirline;
	
	@FXML
	private Label errorLabelNameAirline;
	
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
	
	public ContorllerDialogAddAirline(ObservableList<Airline> modelAirlinesTable) {
		super();
		this.modelAirlinesTable = modelAirlinesTable;
	}
	
	public ContorllerDialogAddAirline(ObservableList<Airline> modelAirlinesTable, ComboBox<Airline> airlines) {
		super();
		this.modelAirlinesTable = modelAirlinesTable;
		this.airlines = airlines;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	@FXML
	private void actionButtonOK(ActionEvent event) {
	//	boolean name = validatorForm.textFiledNotEmpty(textFiledNameAirline, errorNameAirline, "jgdfjgl");
	//	boolean validTime = validatorForm.textFiledNotEmpty(textFiledTimeFrame, )
	//	if(name) {
		String regex = "[0-9]+";
		System.out.println();
			if( textFiledNameAirline.getText().isEmpty()) {
				labelNameAirline.setStyle("-fx-text-fill: red;");
				textFiledNameAirline.setStyle("-fx-border-color: red;");
				errorLabelNameAirline.setText("Поле не повинне бути порожнім!");
			}else if(textFiledNameAirline.getText().matches(regex)) {
				labelNameAirline.setStyle("-fx-text-fill: red;");
				textFiledNameAirline.setStyle("-fx-border-color: red;");
				errorLabelNameAirline.setText("Назва введена неправильно!");
			}
			else if(null == airlineDao.findName(textFiledNameAirline.getText())) {
				Airline tmp = new Airline();
				if(textFiledId.getText().isEmpty()) {
					tmp.setId(0);
				}else {
					tmp.setId(new Integer(textFiledId.getText()));
				}
				tmp.setName(textFiledNameAirline.getText());
				tmp.setTimeFrame(new Integer(textFiledTimeFrame.getText()));
				airlineDao.add(tmp);
				modelAirlinesTable.add(tmp);
				airlines.setValue(tmp);
				actionButtonCancel();
			}else {
				labelNameAirline.setStyle("-fx-text-fill: red;");
				textFiledNameAirline.setStyle("-fx-border-color: red;");
				errorLabelNameAirline.setText("Така назва вжеіснує!");
			}
		//}
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
