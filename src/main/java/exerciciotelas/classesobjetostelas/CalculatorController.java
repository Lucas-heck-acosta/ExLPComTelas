package exerciciotelas.classesobjetostelas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField denominadorField;

    @FXML
    private Button dividirBtn;

    @FXML
    private Button multiplicarBtn;

    @FXML
    private TextField numeradorField;

    @FXML
    private Label resultadoLabel;

    @FXML
    private Button somaBtn;

    @FXML
    private Button subtrairBtn;

    private Calculadora calculadora = new Calculadora();

    @FXML
    public void initialize() {
        somaBtn.setOnAction(event -> realizarOperacao("soma"));
        subtrairBtn.setOnAction(event -> realizarOperacao("subtracao"));
        multiplicarBtn.setOnAction(event -> realizarOperacao("multiplicacao"));
        dividirBtn.setOnAction(event -> realizarOperacao("divisao"));
    }

    private void realizarOperacao(String operacao) {
        try {
            double numerador = Double.parseDouble(numeradorField.getText());
            double denominador = Double.parseDouble(denominadorField.getText());

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
                        resultadoLabel.setText("Erro: Divisão por zero!");
                        return;
                    }
                    resultado = calculadora.divisao();
                    break;
            }

            resultadoLabel.setText(String.valueOf(resultado));

        } catch (NumberFormatException e) {
            resultadoLabel.setText("Erro: Insira números válidos.");
        }
    }
}
