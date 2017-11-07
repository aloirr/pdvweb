package viewTest.clienteView;

import java.lang.reflect.Field;
import java.util.List;

import control.dao.util.IpegaAtributosObjetos;
import control.rules.ClienteRules;
import model.Cliente;
import util.Scan;

public interface IconsultarClienteView extends Scan {

	static public void run() {
		try {
			String atributoWhere = "0", stringPequisa = "";
			Cliente Cliente = new Cliente();
			List<String> listaAtrib = IpegaAtributosObjetos.retornaAtributosObjetoLista(Cliente);
			int count = 1;
			while (true) {
				atributoWhere = "";
				while (!listaAtrib.contains(atributoWhere)) {

					count = 1;
					System.out.println("Por favor, digite o nome do campo do Cliente "
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
							"Por favor, digite o parametro de pesquisa do Cliente que deseja encontrar");
					stringPequisa = Scan.nextLine();
				}
				for (Cliente ClienteFor : ClienteRules.searchBy(Cliente, atributoWhere,
						stringPequisa)) {
					for (Field field : ClienteFor.getClass().getDeclaredFields()) {
						field.setAccessible(true);
						System.out.println(field.getName() + ": " + field.get(ClienteFor));
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
