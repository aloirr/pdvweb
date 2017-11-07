package viewTest.estoqueView.interfacesAction;

import control.rules.ArmazemRules;
import model.Armazem;
import model.Armazem.ArmazemBuilder;
import util.Scan;

public interface IestoqueViewAlterarArmazem {

	public static void run() {
		ArmazemBuilder armazem = new Armazem.ArmazemBuilder();
		
		System.out.println("Digite o id do armazem\n");
		armazem.armazem_Id(Integer.parseInt(Scan.nextLine()));

		if ((ArmazemRules.count("id", armazem.build().getArmazem_Nome().toString())) > 0) {

			System.out.println("Digite o novo nome para o armazem");
			armazem.armazem_Nome(Scan.nextLine());

			ArmazemRules.update(armazem.build());
		}
	}
}
