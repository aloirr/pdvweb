package viewTest.usuarioView;

import util.Scan;

public class UsuarioView implements IalterarUsuarioView, IcadastrarUsuarioView,
		IconsultarUsuarioView, IexcluirUsuarioView, IlistarUsuarioView, Scan {

	public void menuUsuario() {
		String opcao = "";
		while (!opcao.equalsIgnoreCase("0")) {
			System.out.println("Menu de Usuarios);\n" + "1) Cadastrar;\n" + "2) Consultar;\n"
					+ "3) Alterar;\n" + "4) Excluir:\n" + "5) Listar:\n"
					+ "6) Imprimir relação de usuarios cadastrados\n" + "0) Sair do menu");
			opcao = Scan.nextLine();
			switch (opcao) {
			case "1":
				IcadastrarUsuarioView.run();
				break;
			case "2":
				IconsultarUsuarioView.run();
				break;
			case "3":
				IalterarUsuarioView.run();
				break;
			case "4":
				IexcluirUsuarioView.run();
				break;
			case "5":
				IlistarUsuarioView.run();
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
