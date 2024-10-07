package exerciciotelas.classesobjetostelas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class TestaClasseMenuController {

    @FXML
    private Button btnCachorro;

    @FXML
    private Button btnCalculadora;

    @FXML
    private Button btnCarro;

    @FXML
    private Button btnCelular;

    @FXML
    private Button btnFogao;

    @FXML
    private Button btnGato;

    @FXML
    private Button btnMonitor;

    @FXML
    private Button btnMouse;

    @FXML
    private Button btnNotebook;

    @FXML
    private Button btnPessoa;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnVideogame;

    @FXML
    public void openCachorroView() {
        loadView("CachorroView.fxml", "Cachorro");
    }

    @FXML
    public void openCalculadoraView() {
        loadView("CalculadoraView.fxml", "Calculadora");
    }

    @FXML
    public void openCarroView() {
        loadView("CarroView.fxml", "Carro");
    }

    @FXML
    public void openCelularView() {
        loadView("CelularView.fxml", "Celular");
    }

    @FXML
    public void openFogaoView() {
        loadView("FogaoView.fxml", "Fogão");
    }

    @FXML
    public void openGatoView() {
        loadView("GatoView.fxml", "Gato");
    }

    @FXML
    public void openMonitorView() {
        loadView("MonitorView.fxml", "Monitor");
    }

    @FXML
    public void openMouseView() {
        loadView("MouseView.fxml", "Mouse");
    }

    @FXML
    public void openNotebookView() {
        loadView("NotebookView.fxml", "Notebook");
    }

    @FXML
    public void openPessoaView() {
        loadView("PessoaView.fxml", "Pessoa");
    }

    @FXML
    public void openVideogameView() {
        loadView("VideogameView.fxml", "Videogame");
    }

    // Method to exit the application
    @FXML
    public void exitApplication() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }

    // Helper method to load FXML views
    private void loadView(String fxmlFile, String nomeTela) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setTitle(nomeTela);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
