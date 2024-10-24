package exerciciotelas.classesobjetostelas;

public class Fogao {
    private boolean aberto;
    private boolean ligado;
    private int temperatura;

    public Fogao() {
        this.aberto = false;
        this.ligado = false;
        this.temperatura = 0;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Fogão ligado.");
        } else {
            System.out.println("O fogão já está ligado.");
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            temperatura = 0;
            System.out.println("Fogão desligado.");
        } else {
            System.out.println("O fogão já está desligado.");
        }
    }

    public void abrir() {
        if (!aberto) {
            aberto = true;
            System.out.println("Fogão aberto.");
        } else {
            System.out.println("O fogão já está aberto.");
        }
    }

    public void fechar() {
        if (aberto) {
            aberto = false;
            System.out.println("Fogão fechado.");
        } else {
            System.out.println("O fogão já está fechado.");
        }
    }

    public void ajustarTemperatura(int novaTemperatura) {
        if (ligado) {
            if (novaTemperatura >= 0) {
                temperatura = novaTemperatura;
                System.out.println("Temperatura ajustada para " + temperatura + "°C.");
            } else {
                System.out.println("A temperatura não pode ser negativa.");
            }
        } else {
            System.out.println("Não é possível ajustar a temperatura, o fogão está desligado.");
        }
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getTemperatura() {
        return temperatura;
    }
}
