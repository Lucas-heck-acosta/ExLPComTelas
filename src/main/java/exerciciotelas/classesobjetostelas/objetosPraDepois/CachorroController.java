package exerciciotelas.classesobjetostelas.objetosPraDepois;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CachorroController {

    private Cachorro cachorro;

    @FXML
    private Button btnCriarCachorro;

    @FXML
    private Button btnLatir;

    @FXML
    private Button btnDormir;

    @FXML
    private Button btnCorrer;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtRaca;

    @FXML
    public void criarCachorro() {
        String nome = txtNome.getText();
        String raca = txtRaca.getText();
        double peso = Double.parseDouble(txtPeso.getText());

        cachorro = new Cachorro(nome, raca, peso);
        lblResultado.setText("Cachorro criado: " + nome + ", Raça: " + raca + ", Peso: " + peso + " kg");
    }

    @FXML
    public void latir() {
        if (cachorro != null) {
            cachorro.latir();
            lblResultado.setText(cachorro.getNome() + " está latindo!");
        } else {
            lblResultado.setText("Crie o cachorro primeiro!");
        }
    }

    @FXML
    public void dormir() {
        if (cachorro != null) {
            cachorro.dormir();
            lblResultado.setText(cachorro.getNome() + " está dormindo!");
        } else {
            lblResultado.setText("Crie o cachorro primeiro!");
        }
    }

    @FXML
    public void correr() {
        if (cachorro != null) {
            cachorro.correr();
            lblResultado.setText(cachorro.getNome() + " está correndo!");
        } else {
            lblResultado.setText("Crie o cachorro primeiro!");
        }
    }
}
