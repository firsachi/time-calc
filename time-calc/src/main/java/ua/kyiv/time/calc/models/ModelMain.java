/**
 * 
 */
package ua.kyiv.time.calc.models;

import javafx.collections.ObservableList;
import ua.kyiv.time.calc.entities.Airline;


/**
 * @author firsov
 *
 */
public class ModelMain {
	
	private ObservableList<Airline> observableListAirline;

	public ObservableList<Airline> getObservableListAirline() {
		return observableListAirline;
	}

	public void setObservableListAirline(ObservableList<Airline> observableListAirline) {
		this.observableListAirline = observableListAirline;
	}
}
