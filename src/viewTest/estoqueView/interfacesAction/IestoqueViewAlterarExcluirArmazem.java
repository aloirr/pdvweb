package viewTest.estoqueView.interfacesAction;

import util.Scan;

public interface IestoqueViewAlterarExcluirArmazem {

	public static void run() {
		String opcao = "";
		while (true) {
			System.out.println(
					"O que deseja fazer?\n" + "1) Alterar\n" + "2) Excluir\n" + "0) Sair\n");
			opcao = Scan.nextLine();
			switch (opcao) {
			case "1":
				IestoqueViewAlterarArmazem.run();
				break;
			case "2":
				IestoqueViewExcluirArmazem.run();
				break;
			case "0":
				break;
			}
			if (opcao.equalsIgnoreCase("0")) {
				break;
			}
		}
	}

}
