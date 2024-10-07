package exerciciotelas.classesobjetostelas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GatoController {

    @FXML
    private Button btnCorrer;

    @FXML
    private Button btnDormir;

    @FXML
    private Button btnMiar;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtRaca;

    private Gato gato;

    @FXML
    void correr(ActionEvent event) {
        if (gato != null) {
            gato.correr();
            lblResultado.setText("O gato " + gato.getNome() + " está correndo!");
        } else {
            lblResultado.setText("Por favor, crie o gato primeiro!");
        }
    }

    @FXML
    void dormir(ActionEvent event) {
        if (gato != null) {
            gato.dormir();
            lblResultado.setText("O gato " + gato.getNome() + " está dormindo!");
        } else {
            lblResultado.setText("Por favor, crie o gato primeiro!");
        }
    }

    @FXML
    void miar(ActionEvent event) {
        if (gato != null) {
            gato.miar();
            lblResultado.setText("O gato " + gato.getNome() + " está miando!");
        } else {
            lblResultado.setText("Por favor, crie o gato primeiro!");
        }
    }

    @FXML
    public void criarGato() {
        String nome = txtNome.getText();
        String raca = txtRaca.getText();
        double peso = Double.parseDouble(txtPeso.getText());

        gato = new Gato(nome, raca, peso);
        lblResultado.setText("Gato criado: " + nome + ", Raça: " + raca + ", Peso: " + peso + "kg");
    }
}
