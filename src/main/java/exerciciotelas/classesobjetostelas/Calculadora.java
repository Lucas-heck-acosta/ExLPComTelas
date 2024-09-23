package exerciciotelas.classesobjetostelas;

import java.util.Scanner;

public class Calculadora {
    private double numerador;
    private  double denominador;

    public double getNumerador() {
        return numerador;
    }

    public double getDenominador() {
        return denominador;
    }

    public void setNumerador(double numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(double denominador) {
        this.denominador = denominador;
    }


    public Calculadora() {
        this.denominador = 0;
        this.numerador = 0;
    }

    public double soma()
    {
        return numerador + denominador;
    }
    public double subtracao()
    {
        return  numerador - denominador;
    }
    public double multiplicacao()
    {
        return numerador * denominador;
    }
    public double divisao()
    {
        return numerador / denominador;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n--- Menu Calculadora ---");
            System.out.println("1. Atribuir valores");
            System.out.println("2. Soma");
            System.out.println("3. Subtração");
            System.out.println("4. Multiplicação");
            System.out.println("5. Divisão");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o numerador: ");
                    double numerador = scanner.nextDouble();
                    System.out.print("Digite o denominador: ");
                    double denominador = scanner.nextDouble();
                    setNumerador(numerador);
                    setDenominador(denominador);
                    System.out.println("\nValores atribuidos com sucesso.");
                    break;
                case 2:
                    System.out.println("\nResultado da soma: " + soma());
                    break;
                case 3:
                    System.out.println("\nResultado da subtração: " + subtracao());
                    break;
                case 4:
                    System.out.println("\nResultado da multiplicação: " + multiplicacao());
                    break;
                case 5:
                    try {
                        System.out.println("\nResultado da divisão: " + divisao());
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Saindo da calculadora...\n\n\n");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
