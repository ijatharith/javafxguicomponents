module com.mycompany.javafxguicomponents {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.mycompany.javafxguicomponents to javafx.fxml;
    exports com.mycompany.javafxguicomponents;
}