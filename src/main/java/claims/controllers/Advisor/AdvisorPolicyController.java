package claims.controllers.Advisor;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import claims.models.Policy;
import claims.models.Drivers.ClaimsDatabaseDriver;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdvisorPolicyController implements Initializable {
    
	@FXML
    private TableView<Policy> table;
	
	@FXML
    private TableColumn<Policy, String> clm_coverage;

    @FXML
    private TableColumn<Policy, String> clm_deductible;

    @FXML
    private TableColumn<Policy, String> clm_end;

    @FXML
    private TableColumn<Policy, String> clm_name;

    @FXML
    private TableColumn<Policy, String> clm_number;

    @FXML
    private TableColumn<Policy, String> clm_premium;

    @FXML
    private TableColumn<Policy, String> clm_start;

    @FXML
    private TableColumn<Policy, String> clm_status;
    
    @FXML
    public Button submit_btn;
	
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
	
	
	

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		submit_btn.setOnAction(event -> onSubmit());
		
		coverage_picker.getItems().addAll(coverages);
		status_picker.getItems().addAll(status);
		
		toTableView();
	}
	
	// List of policies
	private ObservableList<Policy> initialData(){
		
		ClaimsDatabaseDriver dbDriver = new ClaimsDatabaseDriver();
		ObservableList<Policy> policies = FXCollections.observableArrayList();
		
	        try {
	            ResultSet resultSet = dbDriver.getAllPolicies();
	            while (resultSet.next()) {
	                Policy policy = new Policy(
	                        resultSet.getInt("PolicyNumber"),
	                        resultSet.getString("PolicyName"),
	                        resultSet.getString("StartDate"),
	                        resultSet.getString("EndDate"),
	                        resultSet.getString("CoverageType"),
	                        resultSet.getString("PolicyStatus"),
	                        resultSet.getDouble("Premium"),
	                        resultSet.getDouble("Deductible")
	                );
	                policies.add(policy);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return policies;
	}
	
	public void onSubmit() {
		String name = name_field.getText();
		int number = Integer.parseInt(policy_number_field.getText());
		double premium = Double.parseDouble(premuim_field.getText());
		double deductible = Double.parseDouble(deductible_field.getText());
		String start = start_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String end = end_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		String status = status_picker.getValue();
		String coverage = coverage_picker.getValue();
		
		registerPolicy(name, number, premium, deductible,start,end,status, coverage);
		
		Policy newPolicy = new Policy(number, name, start, end, coverage, status, premium, deductible);

		    
		ObservableList<Policy> currentPolicies = table.getItems();

		currentPolicies.add(newPolicy);

		table.setItems(currentPolicies);
		
		name_field.clear();
		policy_number_field.clear();
		premuim_field.clear();
		deductible_field.clear();
		start_date.getEditor().clear();
		end_date.getEditor().clear();
		
		
		
	}
	
	private void registerPolicy(String name,int number,double premium,double deductible,
			String start,String end,String status,String coverage) {
		
		try {
			Policy policy = new Policy();
			policy.setPolicyName(name);
			policy.setPolicyNumber(number);
			policy.setPremium(premium);
			policy.setDeductible(deductible);
			policy.setStartDate(start);
			policy.setEndDate(end);
			policy.setPolicyStatus(status);
			policy.setCoverageType(coverage);
			ClaimsDatabaseDriver.getInstance().addPolicy(policy);
			
		}catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	public void toTableView() {
		clm_number.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getPolicyNumber())));
	    clm_name.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPolicyName()));
	    clm_start.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStartDate()));
	    clm_end.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndDate()));
	    clm_coverage.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCoverageType()));
	    clm_status.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPolicyStatus()));
	    clm_premium.setCellValueFactory(data -> new SimpleStringProperty(Double.toString(data.getValue().getPremium())));
	    clm_deductible.setCellValueFactory(data -> new SimpleStringProperty(Double.toString(data.getValue().getDeductible())));

	    table.setItems(initialData());
		
	}
	
}
