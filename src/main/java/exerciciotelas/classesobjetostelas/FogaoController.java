package exerciciotelas.classesobjetostelas;

import exerciciotelas.classesobjetostelas.DAO.RefeicaoDAO;
import exerciciotelas.classesobjetostelas.DAO.TentativaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class FogaoController {

    private Fogao fogao = new Fogao();
    private RefeicaoDAO refeicaoDAO = new RefeicaoDAO();
    private TentativaDAO tentativaDAO = new TentativaDAO();
    private ObservableList<Refeicao> refeicoesDisponiveis = FXCollections.observableArrayList();
    private Timer timer;

    @FXML
    private Button btnAbrir;

    @FXML
    private Button btnFechar;

    @FXML
    private ComboBox<Refeicao> cmbRefeicao;

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
        sldTemp.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (fogao.isLigado()) {
                int temperatura = newValue.intValue();
                fogao.ajustarTemperatura(temperatura);
                lblTemp.setText(temperatura + "°C");
                atualizarImagemFogao();
                comecarTimer(temperatura);
            } else {
                lblTemp.setText("0°C");
            }
        });

        atualizarImagemFogao();
        atualizarEstadoBotao();
        lblTemp.setText("0°C");

        // Load Refeicao values into ComboBox
        refeicoesDisponiveis.addAll(refeicaoDAO.getAllRefeicoes());
        cmbRefeicao.setItems(refeicoesDisponiveis);
        cmbRefeicao.setDisable(true);
    }

    @FXML
    void abrirFogao(ActionEvent event) {
        if (!fogao.isAberto()) {
            fogao.abrir();
            atualizarImagemFogao();
            cmbRefeicao.setDisable(false);
        }
    }

    @FXML
    void fecharFogao(ActionEvent event) {
        if (fogao.isAberto()) {
            fogao.fechar();
            atualizarImagemFogao();
            cmbRefeicao.setDisable(true);
        }
    }

    @FXML
    void turnOnOff(ActionEvent event) {
        if (fogao.isLigado()) {
            fogao.desligar();
            if (timer != null) {
                timer.cancel();
            }
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

        if (temperatura >= 300) {
            imgFogao.setImage(new Image(getClass().getResource("/assets/pegandoFogo.jpg").toExternalForm()));
        } else if (fogao.isAberto()) {
            imgFogao.setImage(new Image(getClass().getResource("/assets/fogaoAberto.jpg").toExternalForm()));
        } else {
            imgFogao.setImage(new Image(getClass().getResource("/assets/fogaoFechado.jpg").toExternalForm()));
        }
    }

    private void atualizarEstadoBotao() {
        if (fogao.isLigado()) {
            btnTurnOnOff.setText("Desligar");
            btnTurnOnOff.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        } else {
            btnTurnOnOff.setText("Ligar");
            btnTurnOnOff.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        }
    }

    private void comecarTimer(int initialTemperature) {
        if (cmbRefeicao.getSelectionModel().getSelectedItem() != null) {
            int cookTemp = cmbRefeicao.getSelectionModel().getSelectedItem().getTemperaturaDePreparo();
            if (initialTemperature >= cookTemp) {
                if (timer != null) {
                    timer.cancel();
                }
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() -> {
                            int finalTemperature = fogao.getTemperatura();
                            mostrarResultado(finalTemperature, cookTemp);
                        });
                    }
                }, 5000);
            }
        }
    }

    private void mostrarResultado(int temperatura, int tempoCozimento) {
        String imagePath;
        String resultMessage;

        if (temperatura < tempoCozimento) {
            imagePath = "/assets/comidaCrua.jpg";
            resultMessage = "Ficou Cru!";
        } else if (temperatura <= tempoCozimento + 10) {
            imagePath = "/assets/comidaPerfeita.jpg";
            resultMessage = "Master Chef!";
        } else {
            imagePath = "/assets/comidaQueimada.jpg";
            resultMessage = "Queimou tudo -_-";
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultado");
        alert.setHeaderText("sua comida ficou pronta");
        alert.setContentText(resultMessage);

        ImageView imageView = new ImageView(new Image(getClass().getResource(imagePath).toExternalForm()));
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        alert.setGraphic(imageView);

        alert.showAndWait();

        Refeicao selectedRefeicao = cmbRefeicao.getSelectionModel().getSelectedItem();
        if (selectedRefeicao != null) {
            tentativaDAO.registrarTentativa(selectedRefeicao.getId(), resultMessage);
        }

        resetarEstado();
    }

    private void resetarEstado() {
        cmbRefeicao.getSelectionModel().clearSelection();
        fogao.desligar();
        sldTemp.setValue(0);
        lblTemp.setText("0°C");
        atualizarImagemFogao();
        atualizarEstadoBotao();
    }
}