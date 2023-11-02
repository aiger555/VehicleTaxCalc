module com.example.vehicletaxcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vehicletaxcalculator to javafx.fxml;
    exports com.example.vehicletaxcalculator;
}