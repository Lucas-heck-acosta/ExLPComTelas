package exerciciotelas.classesobjetostelas;

import java.util.List;

public class Refeicao {
    private int id;
    private List<Produto> produtos;
    private String nome;
    private int temperaturaDePreparo;

    public Refeicao(int id, String nome, int temperaturaDePreparo) {
        this.id = id;
        this.nome = nome;
        this.temperaturaDePreparo = temperaturaDePreparo;
    }

    public Refeicao(List<Produto> produtos, String nome, int temperaturaDePreparo) {
        this.produtos = produtos;
        this.nome = nome;
        this.temperaturaDePreparo = temperaturaDePreparo;
    }

    public Refeicao() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getNome() {
        return nome;
    }

    public int getTemperaturaDePreparo() {
        return temperaturaDePreparo;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTemperaturaDePreparo(int temperaturaDePreparo) {
        this.temperaturaDePreparo = temperaturaDePreparo;
    }

    @Override
    public String toString() {
        return nome;
    }
}