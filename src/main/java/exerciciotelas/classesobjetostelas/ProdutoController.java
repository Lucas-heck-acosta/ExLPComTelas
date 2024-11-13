package exerciciotelas.classesobjetostelas;

import exerciciotelas.classesobjetostelas.DAO.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProdutoController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private ImageView imgProduto;

    @FXML
    private TextField txtNome;

    private final ObservableList<String> categorias = FXCollections.observableArrayList(
            "Bebidas", "Carnes", "Doces", "Enlatados", "Verduras/Legumes"
    );

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }

    @FXML
    public void initialize() {
        cmbCategoria.setItems(categorias);
        cmbCategoria.setOnAction(event -> atualizarImagemProduto());
    }

    private void atualizarImagemProduto() {
        String categoria = cmbCategoria.getSelectionModel().getSelectedItem();
        String caminhoImagem = "";

        switch (categoria) {
            case "Bebidas":
                caminhoImagem = "/assets/bebidas.png";
                break;
            case "Carnes":
                caminhoImagem = "/assets/carnes.jpg";
                break;
            case "Doces":
                caminhoImagem = "/assets/doces.jpeg";
                break;
            case "Enlatados":
                caminhoImagem = "/assets/enlatados.jpg";
                break;
            case "Verduras/Legumes":
                caminhoImagem = "/assets/verduraLegume.jpg";
                break;
            default:
                caminhoImagem = "/assets/default.png";
                break;
        }

        imgProduto.setImage(new Image(getClass().getResource(caminhoImagem).toExternalForm()));
    }

    @FXML
    void cadastrar(ActionEvent event) {
        String nome = txtNome.getText();
        String categoria = cmbCategoria.getSelectionModel().getSelectedItem();

        if (nome != null && !nome.isEmpty() && categoria != null) {
            Produto produto = new Produto(nome, categoria);
            try {
                produtoDAO.addProduto(produto);
                showAlert(Alert.AlertType.INFORMATION, "Cadastro de Produto", "Produto cadastrado com sucesso!");
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Erro ao Cadastrar Produto", "Erro: " + e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Erro de Cadastro", "Por favor, preencha todos os campos para cadastrar o produto.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}