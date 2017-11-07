package viewTest.estoqueView.interfacesAction;

import util.Scan;
import viewTest2.EstoqueParametrosPesquisa;
import viewTest2.EstoqueParametrosPesquisa.EstoqueParametrosBuilder;

public interface IestoqueViewCadastrarParametros_MapaEstoque {

	public static EstoqueParametrosPesquisa run() {
		EstoqueParametrosBuilder estoqueParametro =
				new EstoqueParametrosPesquisa.EstoqueParametrosBuilder();
		String opcao = "";
		String parametro = "";
		while (true) {
			System.out.println("Por favor, cadastre os parametros abaixo:\n" + "1) Data inicial: "
					+ estoqueParametro.build().getMapaEstoque_DataInicial() + "\n"
					+ "2) Data Final: " + estoqueParametro.build().getMapaEstoque_DataInicial()
					+ "\n" + "3)Armazem (Deixe em branco para todos): "
					+ estoqueParametro.build().getMapaEstoque_Armazem() + "\n"
					+ "4)Tipos de estoque (Deixe em branco para todos): "
					+ estoqueParametro.build().getMapaEstoque_TiposEstoques() + "\n");
			opcao = Scan.nextLine();
			System.out.println("Digite o parametro (datas no fomato dd/mm/aaaa)");
			parametro = Scan.nextLine();
			switch (opcao) {
			case "1":
				estoqueParametro.mapaEstoque_DataInicial(parametro);
				break;
			case "2":
				estoqueParametro.mapaEstoque_DataFinal(parametro);
				break;
			case "3":
				estoqueParametro.mapaCompra_Armazem(parametro);
				break;
			case "4":
				estoqueParametro.mapaEstoque_TiposEstoques(parametro);
				break;
			}
			if ((!estoqueParametro.build().getMapaEstoque_DataInicial().isEmpty())
					&& (!estoqueParametro.build().getMapaEstoque_DataFinal().isEmpty())) {
				break;
			}
		}
		return estoqueParametro.build();
	}

}
