package viewTest.estoqueView;

public class EstoqueViewNecessidadeCompra {

	public static void menuEstoqueViewNecessidadeCompra() {
		String opcao2 = "";
		while (true) {
			System.out.println("Opcoes de Necessidade de compra\n" + "1)Cadastrar Parametros\n"
					+ "2)Gerar Necessidade de compra\n" + "0)Retornar ao menu anterior\n");

			switch (opcao2) {
			case "1":
				IestoqueViewParametrosNecessidadeCompra();
			case "2":
				IestoqueViewGerarNecessidadeCompra();
			case "0":
				break;
			}
			break;
		}
	}

}
