package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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
		System.out.println("onMenuItemRulesAction");
	}
	
	@FXML
	public void onMenuItemSettingsAction() {
		System.out.println("onMenuItemSettingsAction");
	}
	
	@FXML
	public void onMenuQuitAction() {
		System.out.println("onMenuQuitAction");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("onMenuItemAboutAction");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
			
	}

}
