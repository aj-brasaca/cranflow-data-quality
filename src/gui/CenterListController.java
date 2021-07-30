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
import model.entities.Center;
import model.services.CenterService;

public class CenterListController implements Initializable {

	private CenterService service;
	
	@FXML
	private TableView<Center> tableViewCenter;
	
	@FXML
	private TableColumn<Center, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Center, String> tableColumnCenterName;
	
	@FXML
	private TableColumn<Center, String> tableColumnAccountableName;
	
	@FXML
	private TableColumn<Center, String> tableColumnEmail;
	
	@FXML
	private Button btnNew;
	
	private ObservableList<Center> obsList;
	
	@FXML
	public void onBtnNewAction() {
		System.out.println("onBtnNewAction");
	}
	
	public void setCenterService(CenterService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("ctId"));
		tableColumnCenterName.setCellValueFactory(new PropertyValueFactory<>("ctCenterName"));
		tableColumnAccountableName.setCellValueFactory(new PropertyValueFactory<>("ctAccountableName"));
		tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("ctEmail"));
				
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewCenter.prefHeightProperty().bind(stage.heightProperty());
				
		tableViewCenter.setPlaceholder(new Label("There is no content in the table"));
		
	}
	
	public void updateTableView() {
		
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		
		List<Center> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewCenter.setItems(obsList);
		
	}

}
