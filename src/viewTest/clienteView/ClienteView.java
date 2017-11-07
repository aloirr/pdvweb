package viewTest.clienteView;

import util.Scan;

public class ClienteView implements IalterarClienteView, IcadastrarClienteView,
		IconsultarClienteView, IexcluirClienteView, IlistarClienteView, Scan {

	public void menuCliente() {
		String opcao = "";
		while (!opcao.equalsIgnoreCase("0")) {
			System.out.println("Menu de Clientes);\n" + "1) Cadastrar;\n" + "2) Consultar;\n"
					+ "3) Alterar;\n" + "4) Excluir:\n" + "5) Listar:\n"
					+ "6) Imprimir relação de clientes cadastrados\n" + "0) Sair do menu");
			opcao = Scan.nextLine();
			switch (opcao) {
			case "1":
				IcadastrarClienteView.run();
				break;
			case "2":
				IconsultarClienteView.run();
				break;
			case "3":
				IalterarClienteView.run();
				break;
			case "4":
				IexcluirClienteView.run();
				break;
			case "5":
				IlistarClienteView.run();
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
