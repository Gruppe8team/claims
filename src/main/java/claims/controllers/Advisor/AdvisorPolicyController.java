package claims.controllers.Advisor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AdvisorPolicyController implements Initializable {
    
	@FXML
	public DatePicker start_date;
	
	@FXML
	public DatePicker end_date;
	
	@FXML
	public TextField premuim_field;
	
	@FXML
	public TextField deductible_field;
	
	@FXML
	public TextField name_field;
	
	@FXML
	public TextField policy_number_field;
	
	@FXML
	public ChoiceBox<String> coverage_picker = new ChoiceBox<>();
	
	@FXML
	public ChoiceBox<String> status_picker = new ChoiceBox<>();
	
	private String[] coverages = {"Liability", "Collision", "Comprehensive", 
			"Personal Injury Protection", "Uninsured Motorist"};
	
	private String[] status = {"Active", "Inactive"}; //More statuses can be cancelled, lapsed, suspended, pending 
	
	@FXML
	public TextArea description_textarea;
	
	@FXML
	public TextArea notes_textarea;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void onSubmit() {
		
	}
	
	public void toListView() {
		
	}
	
}
