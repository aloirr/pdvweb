package viewTest.estoqueView;

import util.Scan;

public interface IestoqueView {

	public static void menuEstoqueView() {
		String opcao = "";
		while (true) {
			System.out.println("Opções de estoque\n" + "1) Mapa de estoque\n" + "2) Movimentações\n"
					+ "3) Armazens\n" + "4) Tipos de estocagem\n" + "5) Necessidade de compra\n"
					+ "0) Sair\n");
			opcao = Scan.nextLine();
			switch (opcao) {
			case "1":
				EstoqueViewMapaEstoque.menuEstoqueViewMapaEstoque();
				break;
			case "2":
				EstoqueViewMovimentação.menuEstoqueViewMovimentação();
				break;
			case "3":
				IestoqueViewArmazem.menuEstoqueViewArmazem();
				break;
			case "4":
				EstoqueViewTiposEstoque.menuEstoqueViewTiposEstoque();
				break;
			case "5":
				EstoqueViewNecessidadeCompra.menuEstoqueViewNecessidadeCompra();
				break;

			}
		}
	}
}