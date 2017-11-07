package viewTest.estoqueView.interfacesAction;

import java.util.List;

import control.Estoque;
import control.rules.ArmazemRules;
import control.rules.EstoqueRules;
import model.Armazem;
import model.Armazem.ArmazemBuilder;
import util.ImprimeListaConsole;
import util.Scan;

public interface IestoqueViewCadastroArmazem {

	public static void run() {
		String opcao = null;
		Boolean boo = null;
		while (true) {
			ArmazemBuilder armazem = new Armazem.ArmazemBuilder();
			System.out.println("Por favor, digite o nome do novo armazem:\n");
			System.out.print("->  ");

			armazem.armazem_Nome(Scan.nextLine()).build();

			if (!armazem.build().getArmazem_Nome().isEmpty()) {

				Estoque estoque = new Estoque();
				List<Estoque> estoqueList = EstoqueRules.readTable(estoque);
				if (estoqueList.size() > 0) {
					while (true) {
						opcao = "";
						System.out
								.println("Por favor, digite a id de um estoque para este armazem, "
										+ "deixe em branco para nenhum ou digite "
										+ "LISTARESTOQUE para listar os estoques disponíveis:\n");
						System.out.print("->  ");
						opcao = Scan.nextLine();
						if (opcao.matches("/^[0-9]{1,}$/")) {
							final Integer idEstoque = Integer.parseInt(opcao);
							boo = estoqueList.stream().anyMatch(p -> p.getId() == idEstoque);
							System.out.println(boo);
							if (boo == true) {
								armazem.estoque(idEstoque);
								break;
							}
						} if (opcao.equalsIgnoreCase("LISTARESTOQUE")) {
							ImprimeListaConsole.imprimeListaConsole(estoqueList);
						} if (opcao.isEmpty()) {
							break;
						}
					}
				} else {
					ArmazemRules.insert(armazem.build());
					break;
				}
				break;
			} else {
				System.out.println("Campo em branco! digite o nome do armazem!");
			}
		}
	}
}
