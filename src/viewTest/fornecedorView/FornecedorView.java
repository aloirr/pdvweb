package viewTest.fornecedorView;

import util.Scan;

public class FornecedorView implements IalterarFornecedorView, IcadastrarFornecedorView,
		IconsultarFornecedorView, IexcluirFornecedorView, IlistarFornecedorView, Scan {

	public void menuFornecedor() {
		String opcao = "";
		while (!opcao.equalsIgnoreCase("0")) {
			System.out.println("Menu de Fornecedores);\n" + "1) Cadastrar;\n" + "2) Consultar;\n"
					+ "3) Alterar;\n" + "4) Excluir:\n" + "5) Listar:\n"
					+ "6) Imprimir relação de fornecedores cadastrados\n" + "0) Sair do menu");
			opcao = Scan.nextLine();
			switch (opcao) {
			case "1":
				IcadastrarFornecedorView.run();
				break;
			case "2":
				IconsultarFornecedorView.run();
				break;
			case "3":
				IalterarFornecedorView.run();
				break;
			case "4":
				IexcluirFornecedorView.run();
				break;
			case "5":
				IlistarFornecedorView.run();
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
