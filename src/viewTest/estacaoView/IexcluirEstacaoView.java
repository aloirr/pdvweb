package viewTest.estacaoView;

import control.rules.EstacaoRules;
import util.Scan;

public interface IexcluirEstacaoView extends IlistarEstacaoView {
	public static void run() {
		String opcaoExcluir = "";
		while (true) {
			opcaoExcluir = "";
			while (opcaoExcluir.isEmpty()) {
				System.out.println(
						"Por favor, digite o id da estacao que deseja excluir, 'LISTAR' para listar todos "
								+ "ou 'SAIR' para sair");
				opcaoExcluir = Scan.nextLine();
			}
			if (opcaoExcluir.equalsIgnoreCase("SAIR")) {
				break;
			} else if (opcaoExcluir.equalsIgnoreCase("listar")) {
				IlistarEstacaoView.run();
			} else {
				System.out.println(EstacaoRules.delete(opcaoExcluir));
			}
		}
	}

}
