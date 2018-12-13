package ua.kyiv.time.calc.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import ua.kyiv.time.calc.configuratin.SettingsApplication;
import ua.kyiv.time.calc.dao.AirlineDao;
import ua.kyiv.time.calc.entities.Airline;
import ua.kyiv.time.calc.models.ModelMain;


public class ControllerMain implements Initializable {
	
	private final ObservableList<Integer> listTimeZone;
	private ModelMain modelMain;
	
	private AirlineDao airlineDao = new AirlineDao();
	
	@FXML
	private MenuItem itemAirline;
	
	@FXML 
	private MenuItem itemClose;

	@FXML
	private TextField textRsult;
	
	@FXML
	private TextField textFiledHour;
	
	@FXML
	private TextField textFiledMinute;

	@FXML
	private DatePicker dateDeparture;

	@FXML
	private ComboBox<Integer> comboBoxTimeZone;
	
	@FXML 
	private ComboBox<Airline> comboboxAirline;

	@FXML
	private Button buttonCount;
	
	{
		listTimeZone = FXCollections.observableArrayList(-12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2,-1, 0, +1, +2, +3, +4, +5, +6, +7, +8, +9, +10, +11, +12);
		modelMain = new ModelMain();
		ObservableList<Airline> listAirline = FXCollections.observableArrayList();
		listAirline.addAll(airlineDao.all());
		modelMain.setObservableListAirline(listAirline);
	}
	
	@FXML
	private void closeButtonAction() {
		Platform.exit();
		System.exit(0);
	}
	
	@FXML
	private void actionItemAirline(ActionEvent event) {
		String localeAirline = "i18n.DialogAirlanes";
		String pachSceneAirline = "/fxml/Airline.fxml";
		try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(cf -> {return new ControllerAirlines(modelMain.getObservableListAirline());});
            fxmlLoader.setLocation(getClass().getResource(pachSceneAirline));
            fxmlLoader.setResources(ResourceBundle.getBundle(localeAirline,
                    SettingsApplication.getLocale()));
            Stage stage = new Stage();
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            //stage.setTitle(fxmlLoader.getResources().getString("key.tittle"));
            stage.sizeToScene();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ControllerAirlines.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	@FXML
	private void actionButtonCount(ActionEvent event) {
		LocalDate ld = dateDeparture.getValue();
		Calendar c = new GregorianCalendar();
		Integer hour = new Integer(textFiledHour.getText());
		Integer minute = new Integer(textFiledMinute.getText());
		c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), hour, minute);
		int clock = comboboxAirline.getValue().getTimeFrame();
		clock = -1 * clock;
		c.add(c.HOUR, clock);
		Date date = c.getTime();
		textRsult.setText(date.toString());
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		String pattern = "yyyy-MM-dd";
		this.dateDeparture.setPromptText(pattern.toLowerCase());
		this.dateDeparture.setConverter(new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		});
		this.dateDeparture.setValue(LocalDate.now());
		this.comboBoxTimeZone.setItems(listTimeZone);
		this.comboBoxTimeZone.setValue(listTimeZone.get(12));
		this.comboboxAirline.setItems(modelMain.getObservableListAirline());
		if(0 != modelMain.getObservableListAirline().size()) {
			this.comboboxAirline.setValue(modelMain.getObservableListAirline().get(0));
		}
		this.textFiledHour.setText("0");
		this.textFiledMinute.setText("0");
	}
}
