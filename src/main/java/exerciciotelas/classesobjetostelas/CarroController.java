package exerciciotelas.classesobjetostelas;

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

    // Method to initialize the Carro object based on user input
    private void createCarro() {
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        int ano = Integer.parseInt(txtAno.getText());
        carro = new Carro(marca, modelo, ano);
    }

    // Method to handle the Acelerar button click
    @FXML
    public void acelerar() {
        if (carro == null) {
            createCarro();
        }
        carro.acelerar();
        lblResultado.setText("Carro está acelerando!");
    }

    // Method to handle the Frear button click
    @FXML
    public void frear() {
        if (carro == null) {
            createCarro();
        }
        carro.freair();
        lblResultado.setText("Carro está freiando!");
    }

    // Method to handle the Buzinar button click
    @FXML
    public void buzinar() {
        if (carro == null) {
            createCarro();
        }
        carro.buzinar();
        lblResultado.setText("Carro está buzinando!");
    }
}
