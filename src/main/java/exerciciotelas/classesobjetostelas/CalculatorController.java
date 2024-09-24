package exerciciotelas.classesobjetostelas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private Button btnDividir;

    @FXML
    private Button btnMultiplicar;

    @FXML
    private Button btnSoma;

    @FXML
    private Button btnSubtrair;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtDenominador;

    @FXML
    private TextField txtNumerador;


    private Calculadora calculadora = new Calculadora();

    @FXML
    public void initialize() {
        btnSoma.setOnAction(event -> realizarOperacao("soma"));
        btnSubtrair.setOnAction(event -> realizarOperacao("subtracao"));
        btnMultiplicar.setOnAction(event -> realizarOperacao("multiplicacao"));
        btnDividir.setOnAction(event -> realizarOperacao("divisao"));
    }

    private void realizarOperacao(String operacao) {
        try {
            double numerador = Double.parseDouble(txtNumerador.getText());
            double denominador = Double.parseDouble(txtDenominador.getText());

            calculadora.setNumerador(numerador);
            calculadora.setDenominador(denominador);

            double resultado = 0;

            switch (operacao) {
                case "soma":
                    resultado = calculadora.soma();
                    break;
                case "subtracao":
                    resultado = calculadora.subtracao();
                    break;
                case "multiplicacao":
                    resultado = calculadora.multiplicacao();
                    break;
                case "divisao":
                    if (denominador == 0) {
                        lblResultado.setText("Erro: Divisão por zero!");
                        return;
                    }
                    resultado = calculadora.divisao();
                    break;
            }

            lblResultado.setText(String.valueOf(resultado));

        } catch (NumberFormatException e) {
            lblResultado.setText("Erro: Insira números válidos.");
        }
    }
}
