package dominio.entidades;

import java.math.BigDecimal;
import java.security.Signature;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private Date dataDeFabricacao;

    public ProdutoUsado(String nome, BigDecimal preco, Date dataDeFabricacao) {
        super(nome, preco);
        this.dataDeFabricacao = dataDeFabricacao;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getNome()+" "+getPreco()+"R$ (usado)");
        stringBuilder.append(" (fabricado em " + dataFormatada.format(dataDeFabricacao) + ")");
        return stringBuilder.toString();
    }
}
