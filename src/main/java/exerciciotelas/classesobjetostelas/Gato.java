package exerciciotelas.classesobjetostelas;

public class Gato {
    private String nome;
    private String raca;
    private double peso;

    public Gato(String nome, String raca, double peso) {
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public double getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void miar()
    {
        System.out.println("Gato " + nome + ": MIAU!");
    }
    public void  dormir()
    {
        System.out.println("Gato " + nome + ": dormindo zzz");
    }
    public void  correr()
    {
        System.out.println("Gato " + nome + ": Correndo!");
    }
}
