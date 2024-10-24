package exerciciotelas.classesobjetostelas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class FogaoController {

    private Fogao fogao = new Fogao();

    @FXML
    private Button btnAbrir;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnTurnOnOff;

    @FXML
    private ImageView imgFogao;

    @FXML
    private Label lblTemp;

    @FXML
    private Slider sldTemp;

    @FXML
    public void initialize() {
        sldTemp.valueProperty().addListener((observable, oldValue, newValue) ->
        {
            if (fogao.isLigado())
            {
                int temperatura = newValue.intValue();
                fogao.ajustarTemperatura(temperatura);
                lblTemp.setText(temperatura + "°C");
                atualizarImagemFogao();
            }
            else
            {
                lblTemp.setText("0°C");
            }
        });

        atualizarImagemFogao();
        atualizarEstadoBotao();
        lblTemp.setText("0°C");
    }

    @FXML
    void abrirFogao(ActionEvent event) {
        if (!fogao.isAberto()) {
            fogao.abrir();
            atualizarImagemFogao();
        }
    }

    @FXML
    void fecharFogao(ActionEvent event) {
        if (fogao.isAberto()) {
            fogao.fechar();
            atualizarImagemFogao();
        }
    }

    @FXML
    void turnOnOff(ActionEvent event) {
        if (fogao.isLigado()) {
            fogao.desligar();
        } else {
            fogao.ligar();
        }

        atualizarEstadoBotao();

        if (fogao.isLigado()) {
            lblTemp.setText(sldTemp.getValue() + "°C");
        } else {
            lblTemp.setText("0°C");
        }
    }

    private void atualizarImagemFogao() {
        int temperatura = fogao.getTemperatura();

        if (temperatura >= 300)
        {
            imgFogao.setImage(new Image(getClass().getResource("/assets/pegandoFogo.jpg").toExternalForm()));
        }
        else if (fogao.isAberto())
        {
            imgFogao.setImage(new Image(getClass().getResource("/assets/fogaoAberto.jpg").toExternalForm()));
        }
        else
        {
            imgFogao.setImage(new Image(getClass().getResource("/assets/fogaoFechado.jpg").toExternalForm()));
        }
    }

    private void atualizarEstadoBotao() {
        if (fogao.isLigado()) {
            btnTurnOnOff.setText("Desligar");
            btnTurnOnOff.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        }
        else {
            btnTurnOnOff.setText("Ligar");
            btnTurnOnOff.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        }
    }
}
