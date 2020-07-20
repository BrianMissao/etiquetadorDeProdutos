package dominio.entidades;

import java.math.BigDecimal;

public class Produto {
    private String nome;
    private BigDecimal preco;

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String toString() {
        return nome+" "+preco+"R$";
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

}
