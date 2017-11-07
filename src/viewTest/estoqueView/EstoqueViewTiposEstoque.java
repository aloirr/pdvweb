package viewTest.estoqueView;

public class EstoqueViewTiposEstoque {

	public static void menuEstoqueViewTiposEstoque() {
		String opcao2 = "";
		while (true) {
			System.out.println("Opcoes de tipos de estoque\n" + "1)Cadastro de tipos de estoque\n"
					+ "2)Consultar de tipos de estoque\n" + "0)Retornar ao menu anterior\n");

			switch (opcao2) {
			case "1":
				IestoqueViewCadastroTiposEstoque();
			case "2":
				IestoqueViewConsultaTiposEstoques();
			case "0":
				break;
			}
			break;
		}
	}

}
