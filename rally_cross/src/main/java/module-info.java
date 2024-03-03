module com.example.rally_cross {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rally_cross to javafx.fxml;
    exports com.example.rally_cross;
}