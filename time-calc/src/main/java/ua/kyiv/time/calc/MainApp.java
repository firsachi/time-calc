package ua.kyiv.time.calc;

import javafx.application.Application;
import static javafx.application.Application.launch;

import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.kyiv.time.calc.configuratin.SettingsApplication;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/fxml/Scene.fxml"));
		fXMLLoader.setResources(ResourceBundle.getBundle("i18n.Main", SettingsApplication.getLocale()));
		Parent root = fXMLLoader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/Styles.css");

		stage.setTitle(fXMLLoader.getResources().getString("key.title"));
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application. main()
	 * serves only as fallback in case the application can not be launched through
	 * deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores
	 * main().
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
