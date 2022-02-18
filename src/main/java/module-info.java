module com.juiceline.farklescoring {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.juiceline.farklescoring to javafx.fxml;
    exports com.juiceline.farklescoring;
}
