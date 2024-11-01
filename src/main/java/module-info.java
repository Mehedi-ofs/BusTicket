module com.example.busticket {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.busticket to javafx.fxml;
    exports com.example.busticket;
}