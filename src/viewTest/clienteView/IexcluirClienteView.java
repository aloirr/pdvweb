package viewTest.clienteView;

import control.rules.ClienteRules;
import util.Scan;

public interface IexcluirClienteView extends IlistarClienteView {
	public static void run() {
		String opcaoExcluir = "";
		while (true) {
			opcaoExcluir = "";
			while (opcaoExcluir.isEmpty()) {
				System.out.println(
						"Por favor, digite o id do cliente que deseja excluir, 'LISTAR' para listar todos "
								+ "ou 'SAIR' para sair");
				opcaoExcluir = Scan.nextLine();
			}
			if (opcaoExcluir.equalsIgnoreCase("SAIR")) {
				break;
			} else if (opcaoExcluir.equalsIgnoreCase("listar")) {
				IlistarClienteView.run();
			} else {
				System.out.println(ClienteRules.delete(opcaoExcluir));
			}
		}
	}

}
