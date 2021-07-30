package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.services.RuleService;

public class MainViewController implements Initializable {

	@FXML
	private MenuBar menuBar;
	@FXML
	private MenuItem menuItemImportCSV;
	@FXML
	private MenuItem menuItemFilesProperties;
	@FXML
	private MenuItem menuItemRulesGroup;
	@FXML
	private MenuItem menuItemRules;
	@FXML
	private MenuItem menuItemCenters;
	@FXML
	private MenuItem menuItemSettings;
	@FXML
	private MenuItem menuItemQuit;
	@FXML
	private MenuItem menuItemAbout;
			
	private Stage mainStage = null;
	private Scene mainScene = null;
		
	@FXML
	public void onMenuItemImportCSVAction() {
		System.out.println("onMenuItemImportCSVAction");
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open CSV Files");
		mainStage = (Stage)Main.getMainScene().getWindow();
		fileChooser.showOpenDialog(mainStage);
	}
	
	@FXML
	public void onMenuItemRulesGroupAction() {
		System.out.println("onMenuItemRulesGroupAction");
	}
	
	@FXML
	public void onMenuItemRulesListAction() {
		loadView("/gui/RulesListView.fxml", (RuleListController controller) -> {
			controller.setRuleService(new RuleService());
			controller.updateTableView();
		});
	}
	
	@FXML
	public void onMenuItemCentersListAction() {
		loadView("/gui/CenterView.fxml", (RuleListController controller) -> {
			controller.setRuleService(new RuleService());
			controller.updateTableView();
		});
	}
	
	@FXML
	public void onMenuItemSettingsAction() {
		System.out.println("onMenuItemSettingsAction");
//		Connection conn = DbConnection.getConnection();
//		DbConnection.closeConnection();
	}
			
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/AboutView.fxml", x -> {});
	}
	
	@FXML
	public void onMenuQuitAction() {
		Platform.exit();
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		
		
		//Tooltip t = new Tooltip("This is a tooltip");
		
		//Tooltip.install((Node)menuItemCenter, t);
		
		/*				
		menuItemImportCSV.setOnMenuValidation(new EventHandler<Event>() {

			@Override
			public void handle(Event ev) {
				
				String help = "Importar o arquivo CSV a ser analisado";
				
				if (tooltip == null) {
                    tooltip = new Tooltip();
                    tooltip.setWrapText (true);
                    tooltip.setTextAlignment (TextAlignment.LEFT);
                    tooltip.setPrefSize (200, 250);
                    tooltip.setMinSize (200, 200);
                }
                
				tooltip.setText(help);
				
				Window window = ((Node)ev.getTarget()).getScene().getWindow();
				double localX = ((MenuItem)ev.getTarget()).getParentPopup().getWidth();
                double localY = ((MenuItem)ev.getTarget()).getParentPopup().getHeight();
                
                System.out.println(localX + " " + localY); 
                tooltip.show(window, 1250, 100);
			}
			
			
			
			
			
		});
		*/
		/*
		menuBar.setOnMouseEntered(new EventHandler <Event> () {

			@Override
			public void handle(Event ev) {
						
				String help = "This is tooltip!";

				if (tooltip == null) {
                    tooltip = new Tooltip();
                    tooltip.setWrapText (true);
                    tooltip.setTextAlignment (TextAlignment.LEFT);
                    tooltip.setPrefSize (200, 200);
                    tooltip.setMinSize (200, 100);
                }
                tooltip.setText (help);

                Window window = ((Node)ev.getTarget()).getScene().getWindow();  //    getScene().getWindow());     
                
                double localX = ((MenuItem)ev.getTarget()).getParentPopup().getX();
                double localY = ((MenuItem)ev.getTarget()).getParentPopup().getX();
                
                //MenuItem menu = ((MenuItem)event.getTarget()).getParentPopup().
                
                double x = window.getX () + window.getWidth ()-tooltip.getPrefWidth ()-50;
                double y = window.getY () + 50;
                
               // String ajuda = "X = " + localX + " y = " + localY;
               // tooltip.setText(ajuda);
                
                tooltip.show (window, x, y);//Show tooltip in the upper right corner of Window
			}
		});
            
		menuBar.setOnMouseExited(new EventHandler <Event> () {

			@Override
			public void handle(Event ev) {
				
				if (tooltip != null) {
					tooltip.hide();
				}
				
			}
				
			 
			 
		
		
		});
		
          */  

				
			

            /*@Override
            public void handle (Event t) {
                String help = "This is tooltip!";

                if (tooltip == null) {
                    tooltip = new Tooltip ();
                    tooltip.setWrapText (true);
                    tooltip.setTextAlignment (TextAlignment.LEFT);
                    tooltip.setPrefSize (200, 200);
                    tooltip.setMinSize (200, 100);
                }
                tooltip.setText (help);

                Window window = target.getContextPane (). GetScene (). GetWindow ();
                double x = window.getX () + window.getWidth ()-tooltip.getPrefWidth ()-50;
                double y = window.getY () + 50;
                tooltip.show (window, x, y);//Show tooltip in the upper right corner of Window
            }
        });
        menuBar.setOnHidden (new EventHandler <Event> () {

            @Override
            public void handle (Event t) {
               //Here the menu is the same tooltip
                if (tooltip! = null) {
                    tooltip.hide ();
                }
            }
        });	 */
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
						
			mainScene = Main.getMainScene();
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
