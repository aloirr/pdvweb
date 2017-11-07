package viewTest.estoqueView;

import java.time.LocalDateTime;

import viewTest.estoqueView.interfacesAction.IestoqueViewCadastrarParametros_MapaEstoque;
import viewTest.estoqueView.interfacesAction.IestoqueViewGerarMapaEstoque;
import viewTest2.EstoqueParametrosPesquisa;

public class EstoqueViewMapaEstoque {

	public static void menuEstoqueViewMapaEstoque() {
		String opcao2 = "";
		while (true) {
			System.out.println("Opcoes de Mapa de estoque\n"
					+ "1)Cadastrar Parametros e gerar mapa de estoque\n"
					+ "2)Gerar mapa de estoque de hoje\n" + "0)Retornar ao menu anterior\n");

			switch (opcao2) {
			case "1":
				EstoqueParametrosPesquisa estoqueP =
						IestoqueViewCadastrarParametros_MapaEstoque.run();
				IestoqueViewGerarMapaEstoque.run(estoqueP.getMapaEstoque_DataInicial(),
						estoqueP.getMapaEstoque_DataFinal());
			case "2":
				IestoqueViewGerarMapaEstoque.run(LocalDateTime.now().toString());
			case "0":
				break;
			}
			break;
		}
	}

}
