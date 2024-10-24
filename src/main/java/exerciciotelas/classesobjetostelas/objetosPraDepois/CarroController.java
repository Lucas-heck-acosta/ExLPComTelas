package exerciciotelas.classesobjetostelas.objetosPraDepois;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CarroController {

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtAno;

    @FXML
    private Button btnAcelerar;

    @FXML
    private Button btnFrear;

    @FXML
    private Button btnBuzinar;

    @FXML
    private Label lblResultado;

    private Carro carro;

    private void createCarro() {
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        int ano = Integer.parseInt(txtAno.getText());
        carro = new Carro(marca, modelo, ano);
    }

    @FXML
    public void acelerar() {
        if (carro == null) {
            createCarro();
        }
        carro.acelerar();
        lblResultado.setText("Carro está acelerando!");
    }

    @FXML
    public void frear() {
        if (carro == null) {
            createCarro();
        }
        carro.freair();
        lblResultado.setText("Carro está freiando!");
    }

    @FXML
    public void buzinar() {
        if (carro == null) {
            createCarro();
        }
        carro.buzinar();
        lblResultado.setText("Carro está buzinando!");
    }
}
