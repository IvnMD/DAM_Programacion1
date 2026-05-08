module es.ies.puerto {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.ies.puerto.controllers to javafx.fxml;

    exports es.ies.puerto;
    exports es.ies.puerto.models;
    exports es.ies.puerto.services;
    exports es.ies.puerto.repositories;
}
