package viewTest.estoqueView.interfacesAction;

import control.rules.ArmazemRules;
import util.Scan;

public interface IestoqueViewExcluirArmazem {

	public static void run() {
		System.out.println("Digite o id do armazem\n");
		String opcao = Scan.nextLine();

		if (ArmazemRules.count("id", opcao) > 0) {
			ArmazemRules.delete(opcao);
		}
	}
}
