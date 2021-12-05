module com.example.tanks_client {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.example.tanks_protocol;


    opens com.example.tanks_client to javafx.fxml;
    exports com.example.tanks_client;
}