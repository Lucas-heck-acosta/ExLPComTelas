module exerciciotelas.classesobjetostelas {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens exerciciotelas.classesobjetostelas to javafx.fxml;
    exports exerciciotelas.classesobjetostelas;
}