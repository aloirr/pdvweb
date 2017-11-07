package viewTest.estoqueView.interfacesAction;

import viewTest2.EstoqueParametrosPesquisa;

public interface IestoqueViewGerarMapaEstoque {

	public static void run(String dataInicial, String dataFinal) {
		EstoqueParametrosPesquisa estoqueParametro = IestoqueViewCadastrarParametros_MapaEstoque.run();
		if (!estoqueParametro.getMapaEstoque_DataInicial().isEmpty()
				&& !estoqueParametro.getMapaEstoque_DataFinal().isEmpty()) {
			System.out.println("dentro do gerador de mapa de estoque");
		} else {
			System.out.println("Erro! parametros inválidos. tente novamente");
		}
	}

	public static void run(String dataInicial) {
		System.out.println("dentro do gerador de mapa de estoque");
	}

}