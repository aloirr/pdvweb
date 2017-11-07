package viewTest.produtoView;

import control.rules.ProdutoRules;
import util.Scan;

public interface IexcluirProdutoView extends IlistarProdutosView {
	public static void run() {
		String opcaoExcluir = "";
		while (true) {
			opcaoExcluir = "";
			while (opcaoExcluir.isEmpty()) {
				System.out.println(
						"Por favor, digite o id do produto que deseja excluir, 'LISTAR' para listar todos "
								+ "ou 'SAIR' para sair");
				opcaoExcluir = Scan.nextLine();
			}
			if (opcaoExcluir.equalsIgnoreCase("SAIR")) {
				break;
			} else if (opcaoExcluir.equalsIgnoreCase("listar")) {
				IlistarProdutosView.run();
			} else {
				System.out.println(ProdutoRules.delete(opcaoExcluir));
			}
		}
	}

}
