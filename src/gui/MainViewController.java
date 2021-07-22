package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.RuleService;

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
		loadView("/gui/RulesList.fxml", (RuleListController controller) -> {
			controller.setRuleService(new RuleService());
			controller.updateTableView();
		});
	}
	
	@FXML
	public void onMenuItemSettingsAction() {
		System.out.println("onMenuItemSettingsAction");
	}
			
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml", x -> {});
	}
	
	@FXML
	public void onMenuQuitAction() {
		System.exit(0);
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
			 
	}
	
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		
		try {
			/*
			  ObservableList cursors = FXCollections.observableArrayList(
				      Cursor.DEFAULT,
				      Cursor.CROSSHAIR,
				      Cursor.WAIT,
				      Cursor.TEXT,
				      Cursor.HAND,
				      Cursor.MOVE,
				      Cursor.N_RESIZE,
				      Cursor.NE_RESIZE,
				      Cursor.E_RESIZE,
				      Cursor.SE_RESIZE,
				      Cursor.S_RESIZE,
				      Cursor.SW_RESIZE,
				      Cursor.W_RESIZE,
				      Cursor.NW_RESIZE,
				      Cursor.NONE
				    ); 
				    
				ChoiceBox choiceBoxRef = ChoiceBoxBuilder.create().items(cursors).build();
				
				scene.cursorProperty().bind(choiceBoxRef.getSelectionModel().selectedItemProperty());
			*/
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
						
			Scene mainScene = Main.getMainScene();
			//mainScene.setCursor(Cursor.DEFAULT);
			//mainScene.cursorProperty().bind(cursor);
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller); 
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
			e.printStackTrace();
		}
		
	}
	
}
