package exerciciotelas.classesobjetostelas.objetosPraDepois;

public class Cachorro {
    private String nome;
    private String raca;
    private double peso;

    public Cachorro(String nome, String raca, double peso) {
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

    public void latir()
    {
        System.out.println("Cachorro " + nome + ": AU AU AU!");
    }
    public void  dormir()
    {
        System.out.println("Cachorro " + nome + ": dormindo zzz");
    }
    public void  correr()
    {
        System.out.println("Cachorro " + nome + ": Correndo!");
    }
}
