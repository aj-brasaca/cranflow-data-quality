package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemImportCSV;
	@FXML
	private MenuItem menuItemRules;
	@FXML
	private MenuItem menuItemSettings;
	@FXML
	private MenuItem menuItemQuit;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemImportCSVAction() {
		System.out.println("onMenuItemImportCSVAction");
	}
	
	@FXML
	public void onMenuItemRulesAction() {
		loadView("/gui/RulesList.fxml");
	}
	
	@FXML
	public void onMenuItemSettingsAction() {
		System.out.println("onMenuItemSettingsAction");
	}
	
	@FXML
	public void onMenuQuitAction() {
		System.exit(0);
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
			
	}
	
	private synchronized void loadView(String absoluteName) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
			e.printStackTrace();
		}
		
	}

}