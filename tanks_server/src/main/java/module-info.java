module com.example.tanks_server {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.example.tanks_protocol;


    opens com.example.tanks_server to javafx.fxml;
    exports com.example.tanks_server;
}