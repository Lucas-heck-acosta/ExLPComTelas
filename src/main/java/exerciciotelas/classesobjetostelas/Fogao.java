package exerciciotelas.classesobjetostelas;

public class Fogao {
    private boolean aberto;
    private boolean ligado;
    private int temperatura;

    public Fogao(boolean aberto, boolean ligado, int temperatura) {
        this.aberto = aberto;
        this.ligado = ligado;
        this.temperatura = temperatura;
    }

    public void ligarDesligar() {
        ligado = !ligado;
        System.out.println("Agora o fogão está: " + (ligado ? "LIGADO!" : "DESLIGADO!"));
    }

    public void abrirFecharTampa() {
        aberto = !aberto;
        System.out.println("Agora o fogão está: " + (aberto ? "ABERTO!" : "FECHADO!"));
    }

    public void aumentarTemperatura() {
        temperatura += 5;
        System.out.println("Temperatura aumentada para: " + temperatura);
    }

    // Getter for 'ligado'
    public boolean isLigado() {
        return ligado;
    }

    // Getter for 'aberto'
    public boolean isAberto() {
        return aberto;
    }

    // Getter for 'temperatura'
    public int getTemperatura() {
        return temperatura;
    }
}
