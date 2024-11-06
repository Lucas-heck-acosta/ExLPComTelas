package exerciciotelas.classesobjetostelas;

import exerciciotelas.classesobjetostelas.DAO.ProdutoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
            produtoDAO.addProduto(produto);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro de Produto");
            alert.setHeaderText("Produto Cadastrado");
            alert.setContentText("Produto cadastrado com sucesso!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro de Cadastro");
            alert.setHeaderText("Campos Incompletos");
            alert.setContentText("Por favor, preencha todos os campos para cadastrar o produto.");
            alert.showAndWait();
        }
    }
}