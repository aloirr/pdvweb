package viewTest.produtoView;

import control.rules.ProdutoRules;
import model.Produto;
import model.Produto.ProdutoBuilder;
import util.Scan;

public interface IcadastrarProdutoView extends Scan {
	// nome, unidadeMedida, tipoEmbalagem, qtdPorEmbalagem, fornecedor,
	// armazem;

	public static void run() {
		while (true) {
			ProdutoBuilder produto = new Produto.ProdutoBuilder();
			System.out.println("Por favor digite o nome do produto");
			produto.nome(Scan.nextLine());
			System.out.println(
					"Por favor digite a unidade de medida unitaria (ML, L, GR, KG, UN) do produto");
			produto.unidadeMedida(Scan.nextLine());
			System.out.println(
					"Por favor digite tipo de embalagem do produto (CX, PCT, BB ou FD). Deixe em branco se "
							+ "o produto não for vendido por embalagem fechada.");
			produto.tipoEmbalagem(Scan.nextLine());
			System.out.println("Por favor digite a qtd por embalagem do produto");
			produto.qtdPorEmbalagem(Integer.parseInt(Scan.nextLine()));
			System.out.println("Por favor digite o fornecedor do produto. "
					+ "(Deixe em branco para produto de fabricação própria)");
			produto.fornecedor(Scan.nextLine());
			System.out.println(
					"Por favor digite em qual armazem será alocado o produto. (Deixe em branco caso deseje"
							+ " preencher depois)");
			produto.armazem(Scan.nextLine());
			System.out.println(ProdutoRules.insert(produto.build()));
			Scan.nextLine();
			break;
		}

	}
}