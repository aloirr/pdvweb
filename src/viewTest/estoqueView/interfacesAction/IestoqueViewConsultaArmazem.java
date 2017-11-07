package viewTest.estoqueView.interfacesAction;

import java.util.List;

import control.rules.ArmazemRules;
import model.Armazem;
import util.ImprimeListaConsole;
import util.Scan;

public interface IestoqueViewConsultaArmazem {

	public static void run() {
		System.out.println("Armazens disponíveis:");
		Armazem armazemObj = new Armazem();
		List<Armazem> armazemList = ArmazemRules.readTable(armazemObj);
		if (armazemList.size() > 0) {
			ImprimeListaConsole.imprimeListaConsole(armazemList);
			Scan.nextLine();
		} else {
			System.out.println("Não há armazens cadastrados!");
		}
	}
}
