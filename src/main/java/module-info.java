module com.juiceline.farklescoring {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.juiceline.farklescoring to javafx.fxml;
    exports com.juiceline.farklescoring;
}
