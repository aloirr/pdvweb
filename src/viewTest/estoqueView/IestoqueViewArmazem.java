package viewTest.estoqueView;

import util.Scan;
import viewTest.estoqueView.interfacesAction.IestoqueViewCadastroArmazem;
import viewTest.estoqueView.interfacesAction.IestoqueViewConsultaArmazem;

public interface IestoqueViewArmazem {

	public static void menuEstoqueViewArmazem() {
		String opcao2 = "";
		while (true) {
			System.out.println("Opcoes de armazem\n" + "1)Cadastro de armazem\n"
					+ "2)Consultar armazens\n" + "0)Retornar ao menu anterior\n");
			opcao2 = Scan.nextLine();
			switch (opcao2) {
			case "1":
				IestoqueViewCadastroArmazem.run();
				break;
			case "2":
				IestoqueViewConsultaArmazem.run();
				break;
			case "0":
				break;
			}
			if (opcao2.equalsIgnoreCase("0")) {
				break;
			}
		}
	}

}
