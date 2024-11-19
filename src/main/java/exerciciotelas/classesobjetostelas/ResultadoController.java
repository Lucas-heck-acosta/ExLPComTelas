package exerciciotelas.classesobjetostelas;

import exerciciotelas.classesobjetostelas.DAO.TentativaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.util.List;
import java.util.stream.Collectors;

public class ResultadoController {

    @FXML
    private TextField filterField;

    @FXML
    private TableView<Tentativa> resultTable;

    @FXML
    private TableColumn<Tentativa, Integer> idColumn;

    @FXML
    private TableColumn<Tentativa, String> refeicaoColumn;

    @FXML
    private TableColumn<Tentativa, String> resultColumn;

    @FXML
    private TableColumn<Tentativa, String> dateTimeColumn;

    private ObservableList<Tentativa> tentativaList = FXCollections.observableArrayList();
    private TentativaDAO tentativaDAO = new TentativaDAO();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        refeicaoColumn.setCellValueFactory(new PropertyValueFactory<>("refeicao"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        dateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));

        loadTentativas();
    }

    private void loadTentativas() {
        List<Tentativa> tentativas = tentativaDAO.getAllTentativas();
        tentativaList.setAll(tentativas);
        resultTable.setItems(tentativaList);
    }

    @FXML
    private void filterResults(KeyEvent event) {
        String filter = filterField.getText();
        List<Tentativa> filteredList = tentativaList.stream()
                .filter(t -> t.getRefeicao().toLowerCase().contains(filter.toLowerCase()) ||
                        t.getResult().toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
        resultTable.setItems(FXCollections.observableArrayList(filteredList));
    }
}