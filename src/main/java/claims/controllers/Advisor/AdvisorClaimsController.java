package claims.controllers.Advisor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdvisorClaimsController implements Initializable {
    @FXML
    private TableColumn<?, ?> atfault_col;

    @FXML
    private TableColumn<?, ?> cliID_col;

    @FXML
    private Label clientname_lbl;

    @FXML
    private TableColumn<?, ?> clmID_col;

    @FXML
    private TableView<?> clm_table;

    @FXML
    private TableColumn<?, ?> dam_col;

    @FXML
    private Label dam_lbl;

    @FXML
    private TableColumn<?, ?> datefil_col;

    @FXML
    private Label datefilled_lbl;

    @FXML
    private Label descript_lbl;

    @FXML
    private Label notes_lbl;

    @FXML
    private TableColumn<?, ?> polID_col;

    @FXML
    private TableColumn<?, ?> sta_col;

    @FXML
    private TableColumn<?, ?> time_col;

    @FXML
    private TableColumn<?, ?> tol_col;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
