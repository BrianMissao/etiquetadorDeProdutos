package aplicacao;

import dominio.entidades.Produto;
import dominio.entidades.ProdutoImportado;
import dominio.entidades.ProdutoUsado;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EtiquetadorDeProdutos {
    private static Produto produto;
    private static List<Produto> produtos = new ArrayList<>();
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        int numeroDeProdutosAEtiquetar = Integer.parseInt(obterDados("Quantos produtos você quer etiquetar agora?"));
        etiquetarProdutos(numeroDeProdutosAEtiquetar);
        imprimirOsProdutosQueForamEtiquetados();
    }

    private static void imprimirOsProdutosQueForamEtiquetados() {
        for (Produto produto:produtos) {
            System.out.println(produto);
        }
    }

    private static void etiquetarProdutos(int numeroDeProdutosAEtiquetar) throws ParseException {
        for (int i = 1; i <= numeroDeProdutosAEtiquetar; i++) {
            System.out.println("Entre com os dados do produto de número " + i);
            String nome = obterDados("Nome:");
            char categoria = obterDados("Este produto é comum, usado ou importado? Digite c, u ou i:").charAt(0);
            BigDecimal preco = new BigDecimal(obterDados("Preço: ")).setScale(2, RoundingMode.HALF_EVEN);
            switch (categoria) {
                case 'c':
                    produto = new Produto(nome, preco);
                    break;
                case 'u':
                    Date dataDeFabricacao = dataFormatada.parse(obterDados("Data de fabricação:"));
                    produto = new ProdutoUsado(nome, preco, dataDeFabricacao);
                    break;
                case 'i':
                    BigDecimal taxaDeImportacao = new BigDecimal(obterDados("Taxa de importação:")).setScale(2, RoundingMode.HALF_EVEN);
                    produto = new ProdutoImportado(nome, preco, taxaDeImportacao);
                    break;
            }
            produtos.add(produto);
            System.out.println("Produto adicionado com sucesso!");
        }
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }

}
