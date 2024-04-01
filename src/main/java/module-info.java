
module claims {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    exports claims.controllers;
    exports claims;

    opens claims.controllers to
            javafx.fxml;
    opens claims.controllers.Customer to
            javafx.fxml;
    opens claims.controllers.Advisor to
            javafx.fxml;
    opens claims.controllers.Admin to
            javafx.fxml;
    opens claims to
            javafx.graphics;
    opens claims.models to javafx.base;
}
