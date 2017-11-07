package viewTest.estacaoView;

import util.Scan;

public class EstacaoView implements IalterarEstacaoView, IcadastrarEstacaoView,
		IconsultarEstacaoView, IexcluirEstacaoView, IlistarEstacaoView, Scan {

	public void menuEstacao() {
		String opcao = "";
		while (!opcao.equalsIgnoreCase("0")) {
			System.out.println("Menu de Estacaos);\n" + "1) Cadastrar;\n" + "2) Consultar;\n"
					+ "3) Alterar;\n" + "4) Excluir:\n" + "5) Listar:\n"
					+ "6) Imprimir relação de Estações cadastradas\n" + "0) Sair do menu");
			opcao = Scan.nextLine();
			switch (opcao) {
			case "1":
				IcadastrarEstacaoView.run();
				break;
			case "2":
				IconsultarEstacaoView.run();
				break;
			case "3":
				IalterarEstacaoView.run();
				break;
			case "4":
				IexcluirEstacaoView.run();
				break;
			case "5":
				IlistarEstacaoView.run();
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
