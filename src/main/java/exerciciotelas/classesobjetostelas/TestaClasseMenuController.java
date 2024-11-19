package exerciciotelas.classesobjetostelas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TestaClasseMenuController {

    @FXML
    private Button btnFogao;

    @FXML
    private Button btnProduto;

    @FXML
    private Button btnRefeicao;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnResultados;

    @FXML
    public void openFogaoView() {
        loadView("FogaoView.fxml", "Fogão");
    }


    @FXML
    void openProdutoView(ActionEvent event) {
        loadView("ProdutoView.fxml", "Produto");
    }

    @FXML
    void openRefeicaoView(ActionEvent event) {
        loadView("RefeicaoView.fxml", "Refeição");
    }

    @FXML
    public void exitApplication() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }

    @FXML
    void openResultView(ActionEvent event) {
        loadView("ResultadosView.fxml", "Resultados");
    }
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
