package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import claims.Claims;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ClaimCellController implements Initializable {
    @FXML
    private Label accident_lbl;

    @FXML
    private Label claimid_lbl;

    @FXML
    private Label claimstat_lbl;

    @FXML
    private Label clientid_lbl;

    @FXML
    private Label damage_lbl;

    @FXML
    private Label datefiled_lbl;

    @FXML
    private Label name_lbl;

    private final Claims claim;

    public ClaimCellController(Claims claim) {
        this.claim = claim;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

}
