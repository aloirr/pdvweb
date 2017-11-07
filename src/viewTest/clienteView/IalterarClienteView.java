package viewTest.clienteView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import control.rules.ClienteRules;
import model.Cliente;
import util.Scan;

public interface IalterarClienteView extends IlistarClienteView, Scan {

	public static void run() {
		try {
			String opcaoAlterar = "";
			String opcaoCampo = "";
			String novoValorCampo = "";
			Cliente cliente = new Cliente();
			List<Cliente> listaClientes = new ArrayList<>();
			while (true) {
				opcaoAlterar = "";
				System.out.println("Por favor, digite o id do cliente que deseja alterar,"
						+ " 'LISTAR' para listar todos " + "ou 'SAIR' para sair");
				opcaoAlterar = Scan.nextLine();
				if (opcaoAlterar.equalsIgnoreCase("listar")) {
					IlistarClienteView.run();
				} else if (opcaoAlterar.equalsIgnoreCase("sair")) {
					break;
				} else if ((listaClientes = ClienteRules.searchBy(cliente, "id", opcaoAlterar))
						.size() != 0) {
					System.out.println("Informação do Cliente:");
					for (Field field : listaClientes.get(0).getClass().getDeclaredFields()) {
						field.setAccessible(true);
						System.out
								.println(field.getName() + ": " + field.get(listaClientes.get(0)));
						field.setAccessible(false);

					}
					while (opcaoCampo.isEmpty()) {
						System.out.println("Digite o campo que deseja alterar");
						opcaoCampo = Scan.nextLine();
					}
					while (novoValorCampo.isEmpty()) {
						System.out.println("Digite o novo valor para o campo");
						novoValorCampo = Scan.nextLine();
					}
					Field campoObject;
					campoObject = listaClientes.get(0).getClass().getDeclaredField(opcaoCampo);
					campoObject.setAccessible(true);
					campoObject.set(listaClientes.get(0), novoValorCampo);
					campoObject.setAccessible(false);
					System.out.println(ClienteRules.update(listaClientes.get(0)));

				} else {
					System.out.println("ID não localizado! tente novamente!");
				}
			}
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

}