package exerciciotelas.classesobjetostelas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FogaoController {

    private Fogao fogao = new Fogao(false, false, 0);

    @FXML
    private Button btnLigarDesligar;

    @FXML
    private Button btnAbrirFechar;

    @FXML
    private Button btnAumentarTemperatura;

    @FXML
    private Label lblStatus;

    @FXML
    public void ligarDesligar() {
        fogao.ligarDesligar();
        lblStatus.setText("Fogão: " + (fogao.isLigado() ? "Ligado" : "Desligado"));
    }

    @FXML
    public void abrirFecharTampa() {
        fogao.abrirFecharTampa();
        lblStatus.setText("Tampa: " + (fogao.isAberto() ? "Aberta" : "Fechada"));
    }

    @FXML
    public void aumentarTemperatura() {
        fogao.aumentarTemperatura();
        lblStatus.setText("Temperatura: " + fogao.getTemperatura() + "°C");
    }
}
