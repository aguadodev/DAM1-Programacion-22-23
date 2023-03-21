module com.example01 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example01 to javafx.fxml;
    exports com.example01;
}
