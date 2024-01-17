module com.example.currencyexchange {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.currencyexchange to javafx.fxml;
    exports com.example.currencyexchange;
}