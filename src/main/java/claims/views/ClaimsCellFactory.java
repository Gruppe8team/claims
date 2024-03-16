package claims.views;

import claims.controllers.ClaimCellController;
import claims.models.Claims;
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
