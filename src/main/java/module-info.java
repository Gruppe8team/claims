module claims {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires java.sql;
    exports claims;
    exports claims.controllers;
    opens claims.controllers to javafx.fxml;
}
