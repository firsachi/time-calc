package ua.kyiv.time.calc.controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class FXMLController implements Initializable {

	private final ObservableList<Integer> listTimeZone;

	@FXML
	private TextField textRsult;

	@FXML
	private DatePicker dateDeparture;

	@FXML
	private ComboBox<Integer> comboBoxTimeZone;

	@FXML
	private Button buttonCount;

	{
		listTimeZone = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
				18, 19, 20, 21);
	}

	@FXML
	private void actionButtonCount(ActionEvent event) {
		LocalDate ld = dateDeparture.getValue();
		Calendar c = new GregorianCalendar();
		c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
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
		this.comboBoxTimeZone.setValue(listTimeZone.get(0));

		this.textRsult.setText("");
	}
}
