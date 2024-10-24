package exerciciotelas.classesobjetostelas.objetosPraDepois;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NotebookController {

    private Notebook notebook;

    @FXML
    private Button btnAbrirFechar;

    @FXML
    private Button btnLigarDesligar;

    @FXML
    private Button btnTocarMusica;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtMusica;

    @FXML
    public void initialize() {
        notebook = new Notebook(false, "", false);
    }

    @FXML
    public void ligarDesligar() {
        notebook.ligarDesligar();
        lblResultado.setText("Notebook: " + (notebook.isLigado() ? "Ligado" : "Desligado"));
    }

    @FXML
    public void abrirFechar() {
        notebook.abrirFechar();
        lblResultado.setText("Notebook: " + (notebook.isAberto() ? "Aberto" : "Fechado"));
    }

    @FXML
    public void tocarMusica() {
        String musica = txtMusica.getText();
        notebook.tocarMusica(musica);
        lblResultado.setText("Tocando a música: " + musica);
    }

}
