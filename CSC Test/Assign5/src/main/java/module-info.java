module com.example.assign5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assign5 to javafx.fxml;
    exports com.example.assign5;
}