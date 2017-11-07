package viewTest.usuarioView;

import control.rules.UsuarioRules;
import util.Scan;

public interface IexcluirUsuarioView extends IlistarUsuarioView {
	public static void run() {
		String opcaoExcluir = "";
		while (true) {
			opcaoExcluir = "";
			while (opcaoExcluir.isEmpty()) {
				System.out.println(
						"Por favor, digite o id do Usuario que deseja excluir, 'LISTAR' para listar todos "
								+ "ou 'SAIR' para sair");
				opcaoExcluir = Scan.nextLine();
			}
			if (opcaoExcluir.equalsIgnoreCase("SAIR")) {
				break;
			} else if (opcaoExcluir.equalsIgnoreCase("listar")) {
				IlistarUsuarioView.run();
			} else {
				System.out.println(UsuarioRules.delete(opcaoExcluir));
			}
		}
	}

}
