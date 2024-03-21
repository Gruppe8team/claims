module claims {
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    exports claims.controllers;
    opens claims.controllers to javafx.fxml;
    opens claims.controllers.Customer to javafx.fxml;
    opens claims.controllers.Advisor to javafx.fxml;
    opens claims.controllers.Admin to javafx.fxml;
    exports claims;
    opens claims to javafx.graphics;
}