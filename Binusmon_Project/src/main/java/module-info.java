module com.example.binusmon_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.binusmon_project to javafx.fxml;
    exports com.example.binusmon_project;
}