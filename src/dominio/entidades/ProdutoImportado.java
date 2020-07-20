package dominio.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProdutoImportado extends Produto {
    private BigDecimal taxaDeImportacao;

    public ProdutoImportado(String nome, BigDecimal preco, BigDecimal taxaDeImportacao) {
        super(nome, preco);
        this.taxaDeImportacao = taxaDeImportacao;
    }

    @Override
    public BigDecimal getPreco() {
        return super.getPreco().add(taxaDeImportacao).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        return getNome()+" "+getPreco()+"R$ (taxa de importação: "+taxaDeImportacao+"R$)";
    }

    public BigDecimal getTaxaDeImportacao() {
        return taxaDeImportacao;
    }
}