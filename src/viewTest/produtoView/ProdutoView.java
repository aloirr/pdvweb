package viewTest.produtoView;

import util.Scan;

public class ProdutoView implements IcadastrarProdutoView, IconsultarProdutoView,
		IalterarProdutoView, IexcluirProdutoView, IlistarProdutosView, Scan {

	public void menuProduto() {
		String opcao = "";
		while (!opcao.equalsIgnoreCase("0")) {
			System.out.println("Menu de produtos);\n" + "1) Cadastrar;\n" + "2) Consultar;\n"
					+ "3) Alterar;\n" + "4) Excluir:\n" + "5) Listar:\n"
					+ "6) Imprimir relação de produtos cadastrados\n" + "0) Sair do menu");
			opcao = Scan.nextLine();
			switch (opcao) {
			case "1":
				IcadastrarProdutoView.run();
				break;
			case "2":
				IconsultarProdutoView.run();
				break;
			case "3":
				IalterarProdutoView.run();
				break;
			case "4":
				IexcluirProdutoView.run();
				break;
			case "5":
				IlistarProdutosView.run();
				break;
			case "6":
				// ImprimirProdutosView();
				break;
			case "0":
				opcao = "0";
				break;
			default:
				System.out.println("Opção inválida! tente novamente!");
				break;
			}
		}

	}
}
