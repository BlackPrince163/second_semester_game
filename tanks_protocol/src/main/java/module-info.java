module com.example.tanks_protocol {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tanks_protocol to javafx.fxml;
    exports com.example.tanks_protocol;
}