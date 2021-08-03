package gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import gui.util.Constraints;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.entities.Rule;

public class RuleFormController implements Initializable {

	private Rule entity;
	
	@FXML
	private TextField txtRlId;
	
	@FXML
	private TextField txtRlName;
	
	@FXML
	private TextArea txaRlExpression;
	
	@FXML
	private ComboBox<String> cboRlValueReturn;
	
	@FXML
	private TextArea txaRlDescription;
	
	@FXML
	private CheckBox chkRlActiveRule;
	
	@FXML
	private ComboBox<String> cboGroupName; // Show groups names
	
	@FXML
	private Button btnSave;
	
	@FXML
	private Button btnCancel;
	
	public void setRule(Rule entity) {
		this.entity = entity;
	}
	
	@FXML
	public void onBtnSaveAction() {
		System.out.println("onBtnSaveAction");
	}
	
	@FXML
	public void onBtnCancelAction(ActionEvent event) {
		System.out.println("onBtnCancelAction");		
	}
	
	public RuleFormController() {
	}
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtRlId);
		//Constraints.setTextfieldMaxLength(txtRlName, 50);
		ValidationSupport validation = new ValidationSupport();
		validation.registerValidator(txtRlName, Validator.createEmptyValidator("Rule name is mandatory", Severity.ERROR));
		
		validation.registerValidator(txaRlExpression, Validator.createEmptyValidator("Expression is mandatory", Severity.ERROR));
		
		cboRlValueReturn.getItems().addAll("true", "false");
		validation.registerValidator(cboRlValueReturn, Validator.createEmptyValidator("Choose an item", Severity.ERROR));
		
		validation.registerValidator(txaRlDescription, Validator.createEmptyValidator("Description is mandatory", Severity.ERROR));
		
		cboGroupName.getItems().addAll("Comparativo de nomes", "Padrão de CNS", "Padrão de CPF");
		validation.registerValidator(cboGroupName, Validator.createEmptyValidator("Choose an item", Severity.ERROR));
		//Constraints.setTextfieldMaxLength(txaRlExpression, 100);
		
		btnSave.disableProperty().bind(validation.invalidProperty());
		
	}
	
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtRlId.setText(String.valueOf(entity.getRlId()));
		txtRlName.setText(entity.getRlName());
		txaRlExpression.setText(entity.getRlExpression());
		cboRlValueReturn.getSelectionModel().select(entity.getRlValueReturn());
		txaRlDescription.setText(entity.getRlDescription());
		chkRlActiveRule.setSelected(Boolean.parseBoolean(entity.getRlValueReturn()));
		cboGroupName.getSelectionModel().select(entity.getRlGroup());
	}

}
