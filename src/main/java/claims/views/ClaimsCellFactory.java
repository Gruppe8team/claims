package claims.views;

import claims.Claims;
import claims.controllers.ClaimCellController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class ClaimsCellFactory extends ListCell<Claims> {
    
    @Override
    protected void updateItem(Claims claim, boolean empty) {
        super.updateItem(claim, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/ClaimCell.fxml"));
            ClaimCellController controller = new ClaimCellController(claim);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
