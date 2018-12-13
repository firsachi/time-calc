/**
 * 
 */
package ua.kyiv.time.calc.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ua.kyiv.time.calc.configuratin.SettingsApplication;
import ua.kyiv.time.calc.entities.Airline;

/**
 * @author firsov
 *
 */
public class ControllerAirlines implements Initializable {
	
	private ObservableList<Airline> modelAirlinesTable;
	
	@FXML
	private Button buttonAddAirline;
	
	@FXML
	private TableView<Airline> tableAirlie;
	
	@FXML
	private TableColumn<Airline, String> idAirlline;

	@FXML 
	private TableColumn<Airline, String> nameAirlane;
	
	@FXML
	private TableColumn<Airline, String> timeFrame;
	
	
	
	public ControllerAirlines(ObservableList<Airline> modelAirlinesTable) {
		super();
		this.modelAirlinesTable = modelAirlinesTable;
	}

	@FXML
	private void actionAddAirline() {
		String pachSceneAirline = "/fxml/DialogAirline.fxml";
		String localeAirline = "i18n.DialogAirlane";
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setControllerFactory(c -> {
	        	return new ContorllerDialogAddAirline(modelAirlinesTable);
	        });
	        fxmlLoader.setLocation(getClass().getResource(pachSceneAirline));
	        fxmlLoader.setResources(ResourceBundle.getBundle(localeAirline,
	               SettingsApplication.getLocale()));
	        Stage stage = new Stage();
	        Parent root = fxmlLoader.load();
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add("/styles/Styles.css");
	        stage.setScene(scene);
	        stage.setTitle(fxmlLoader.getResources().getString("key.title"));
	        stage.sizeToScene();
	        stage.initModality(Modality.APPLICATION_MODAL);
	        stage.initOwner(buttonAddAirline.getScene().getWindow());
	        stage.show();
	    } catch (IOException ex) {
	        Logger.getLogger(ControllerAirlines.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idAirlline.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameAirlane.setCellValueFactory(new PropertyValueFactory<>("name"));
		timeFrame.setCellValueFactory(new PropertyValueFactory<>("timeFrame"));
		tableAirlie.setItems(modelAirlinesTable);
	}


}
