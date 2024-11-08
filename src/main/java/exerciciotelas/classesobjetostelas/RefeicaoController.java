package exerciciotelas.classesobjetostelas;

import exerciciotelas.classesobjetostelas.DAO.ProdutoDAO;
import exerciciotelas.classesobjetostelas.DAO.RefeicaoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.util.Comparator;

public class RefeicaoController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnRemover;

    @FXML
    private ListView<Produto> lvProdutos;

    @FXML
    private ListView<Produto> lvReceita;

    @FXML
    private TextField txtNome;

    @FXML
    private Slider sldTemperatura;

    private ProdutoDAO produtoDAO;
    private RefeicaoDAO refeicaoDAO;
    private ObservableList<Produto> produtosDisponiveis;
    private ObservableList<Produto> produtosSelecionados;

    public RefeicaoController() {
        this.produtoDAO = new ProdutoDAO();
        this.refeicaoDAO = new RefeicaoDAO();
        this.produtosDisponiveis = FXCollections.observableArrayList();
        this.produtosSelecionados = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        produtosDisponiveis.addAll(produtoDAO.getAllProdutos());
        produtosDisponiveis.sort(Comparator.comparing(Produto::getNome));
        lvProdutos.setItems(produtosDisponiveis);
        lvReceita.setItems(produtosSelecionados);
    }

    @FXML
    void adicionar(ActionEvent event) {
        Produto selectedProduto = lvProdutos.getSelectionModel().getSelectedItem();
        if (selectedProduto != null) {
            produtosDisponiveis.remove(selectedProduto);
            produtosSelecionados.add(selectedProduto);
            produtosSelecionados.sort(Comparator.comparing(Produto::getNome));
        }
    }

    @FXML
    void remover(ActionEvent event) {
        Produto selectedProduto = lvReceita.getSelectionModel().getSelectedItem();
        if (selectedProduto != null) {
            produtosSelecionados.remove(selectedProduto);
            produtosDisponiveis.add(selectedProduto);
            produtosDisponiveis.sort(Comparator.comparing(Produto::getNome));
        }
    }

    @FXML
    void cadastrarRefeicao(ActionEvent event) {
        String nome = txtNome.getText();
        int temperaturaDePreparo = (int) sldTemperatura.getValue();
        if (nome != null && !nome.isEmpty() && !produtosSelecionados.isEmpty()) {
            Refeicao refeicao = new Refeicao(produtosSelecionados, nome, temperaturaDePreparo);
            refeicaoDAO.addRefeicao(refeicao);
            System.out.println("Refeicao cadastrada: " + refeicao.getNome() + " com " + refeicao.getProdutos().size() + " produtos e temperatura de preparo: " + refeicao.getTemperaturaDePreparo());
        } else {
            System.out.println("Erro: Nome da refeição ou lista de produtos está vazia.");
        }
    }
}