package claims.controllers.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminClaimsController implements Initializable {
    @FXML
    private TextArea changelog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changelog.setEditable(false);
        loadChangeLogFile();
    }
//
    private void loadChangeLogFile() {
        String filePath = "src/main/resources/claims/changelog.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            changelog.setText(content.toString());
        } catch (IOException e) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Oh balls");
            alert1.setHeaderText("CRITICAL ERROR");
            alert1.setContentText("MISSING_CHANGELOG_ Contact SysAdmin For details.");
            e.printStackTrace();
        }
    }
}
