package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Rule;
import model.services.RuleService;

public class RuleListController implements Initializable {

	private RuleService service;
	
	@FXML
	private TableView<Rule> tableViewRule;
	
	@FXML
	private TableColumn<Rule, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Rule, String> tableColumnRuleName;
	
	@FXML
	private TableColumn<Rule, String> tableColumnBooleanExpression;
	
	@FXML
	private TableColumn<Rule, String> tableColumnValueReturn;
	
	@FXML
	private TableColumn<Rule, String> tableColumnDescription;
	
	@FXML
	private TableColumn<Rule, String> tableColumnActiveRule;
	
	@FXML
	private TableColumn<Rule, String> tableColumnGroup;
	
	@FXML
	private Button btnNew;
	
	private ObservableList<Rule> obsList;
	
	@FXML
	public void onBtnNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Rule obj = new Rule();
		createDialogForm(obj, "/gui/RulesForm.fxml", parentStage);
	}
	
	public void setRuleService(RuleService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		
		// Colocar o nome do grupo
		//tableColumnId.setCellValueFactory(new PropertyValueFactory<>("GroupName"));
		
		//String rlId = "rlId";
		//tableColumnId.setText("AJB");
		//tableColumnId.setCellValueFactory(new PropertyValueFactory<>(rlId));
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("rlId"));
		tableColumnRuleName.setCellValueFactory(new PropertyValueFactory<>("rlName"));
		tableColumnBooleanExpression.setCellValueFactory(new PropertyValueFactory<>("rlExpression"));
		tableColumnValueReturn.setCellValueFactory(new PropertyValueFactory<>("rlValueReturn"));
		tableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("rlDescription"));
		tableColumnActiveRule.setCellValueFactory(new PropertyValueFactory<>("rlActiveRule"));
		tableColumnGroup.setCellValueFactory(new PropertyValueFactory<>("rlGroup"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewRule.prefHeightProperty().bind(stage.heightProperty());
		//tableViewRule.prefHeightProperty().bind(stage.widthProperty());
		
		tableViewRule.setPlaceholder(new Label("There is no content in the table"));
		
	}
	
	public void updateTableView() {
		
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		
		List<Rule> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewRule.setItems(obsList);
		
	}
	
	public void createDialogForm(Rule obj, String absoluteName, Stage parentStage) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			RuleFormController controller = loader.getController();
			controller.setRule(obj);
			controller.setRuleService(new RuleService());
			controller.updateFormData();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter Rule data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
