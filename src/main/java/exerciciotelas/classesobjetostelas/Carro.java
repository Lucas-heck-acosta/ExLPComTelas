package exerciciotelas.classesobjetostelas;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void acelerar()
    {
        System.out.println("Acelerando!");
    }
    public void freair()
    {
        System.out.println("freiando!");
    }
    public void buzinar()
    {
        System.out.println("BIBI!");
    }
}
