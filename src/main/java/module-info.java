module exerciciotelas.classesobjetostelas {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens exerciciotelas.classesobjetostelas to javafx.fxml;
    exports exerciciotelas.classesobjetostelas;
    exports exerciciotelas.classesobjetostelas.objetosPraDepois;
    opens exerciciotelas.classesobjetostelas.objetosPraDepois to javafx.fxml;
}