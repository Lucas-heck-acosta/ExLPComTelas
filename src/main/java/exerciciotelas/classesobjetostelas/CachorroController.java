package exerciciotelas.classesobjetostelas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CachorroController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtRaca;

    @FXML
    private TextField txtPeso;

    @FXML
    private Button btnLatir;

    @FXML
    private Button btnDormir;

    @FXML
    private Button btnCorrer;

    @FXML
    private Label lblResultado;

    private Cachorro cachorro;

    @FXML
    public void initialize() {
        // Set up action events for the buttons
        btnLatir.setOnAction(event -> {
            criarCachorro();
            cachorro.latir();
            lblResultado.setText("Cachorro " + cachorro.getNome() + ": AU AU AU!");
        });

        btnDormir.setOnAction(event -> {
            criarCachorro();
            cachorro.dormir();
            lblResultado.setText("Cachorro " + cachorro.getNome() + ": dormindo zzz...");
        });

        btnCorrer.setOnAction(event -> {
            criarCachorro();
            cachorro.correr();
            lblResultado.setText("Cachorro " + cachorro.getNome() + ": correndo!");
        });
    }

    // Method to create or update the Cachorro object based on user input
    private void criarCachorro() {
        String nome = txtNome.getText();
        String raca = txtRaca.getText();
        double peso = Double.parseDouble(txtPeso.getText());
        cachorro = new Cachorro(nome, raca, peso);
    }
}
