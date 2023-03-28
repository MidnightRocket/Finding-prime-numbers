module midnightrocket.java {
    requires javafx.controls;
    requires javafx.fxml;


    opens midnightrocket.java to javafx.fxml;
    exports midnightrocket.java;
}