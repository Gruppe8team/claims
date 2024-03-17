module claims {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    exports claims.controllers;
    opens claims.controllers to javafx.fxml;
    exports claims;
    opens claims to javafx.graphics;
}