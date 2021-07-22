package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableColumn<Rule, Boolean> tableColumnActiveRule;
	
	@FXML
	private Button btnNew;
	
	private ObservableList<Rule> obsList;
	
	@FXML
	public void onBtnNewAction() {
		System.out.println("onBtnNewAction");
	}
	
	public void setRuleServide(RuleService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnRuleName.setCellValueFactory(new PropertyValueFactory<>("ruleName"));
		tableColumnBooleanExpression.setCellValueFactory(new PropertyValueFactory<>("booleanExpression"));
		tableColumnValueReturn.setCellValueFactory(new PropertyValueFactory<>("valueReturn"));
		tableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
		tableColumnActiveRule.setCellValueFactory(new PropertyValueFactory<>("activeRule"));
		
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

}
