package viewTest.estacaoView;

import java.lang.reflect.Field;
import java.util.List;

import control.dao.util.IpegaAtributosObjetos;
import control.rules.EstacaoRules;
import model.Estacao;
import util.Scan;

public interface IconsultarEstacaoView extends Scan {

	static public void run() {
		try {
			String atributoWhere = "0", stringPequisa = "";
			Estacao Estacao = new Estacao();
			List<String> listaAtrib = IpegaAtributosObjetos.retornaAtributosObjetoLista(Estacao);
			int count = 1;
			while (true) {
				atributoWhere = "";
				while (!listaAtrib.contains(atributoWhere)) {

					count = 1;
					System.out.println("Por favor, digite o nome do campo do Estacao "
							+ "que deseja usar como critério de pesquisa "
							+ "ou digite SAIR para retornar ao menu principal");
					for (String atrib : listaAtrib) {
						System.out.println(count + ")" + atrib);
						count++;
					}
					atributoWhere = Scan.nextLine();
					if (atributoWhere.equalsIgnoreCase("sair")) {
						break;
					}
					System.out.println(atributoWhere);
					System.out.println(listaAtrib.contains(atributoWhere));
					System.out.println(atributoWhere.equalsIgnoreCase("sair"));
				}
				if (atributoWhere.equalsIgnoreCase("sair")) {
					break;
				}
				while (stringPequisa.isEmpty()) {
					System.out.println(
							"Por favor, digite o parametro de pesquisa do Estacao que deseja encontrar");
					stringPequisa = Scan.nextLine();
				}
				for (Estacao EstacaoFor : EstacaoRules.searchBy(Estacao, atributoWhere,
						stringPequisa)) {
					for (Field field : EstacaoFor.getClass().getDeclaredFields()) {
						field.setAccessible(true);
						System.out.println(field.getName() + ": " + field.get(EstacaoFor));
						field.setAccessible(false);

					}
					System.out.println("#######################");

				}
				Scan.nextLine();

			}

		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();

		}
	}
}
