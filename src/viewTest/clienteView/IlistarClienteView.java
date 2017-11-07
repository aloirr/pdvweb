package viewTest.clienteView;

import java.lang.reflect.Field;
import java.util.List;

import control.rules.ClienteRules;
import model.Cliente;
import util.Scan;

public interface IlistarClienteView extends Scan {

	public static void run() {
		Cliente cliente = new Cliente();
		try {
			List<Cliente> listaClientes = ClienteRules.listarDao(cliente, "cliente");
			System.out.println("Lista de clientes cadastrados");
			for (Cliente clientelist : listaClientes) {
				Field[] fields = clientelist.getClass().getDeclaredFields();
				System.out.println("Cliente: " + clientelist.getRazaoSocial());
				for (Field field : fields) {
					field.setAccessible(true);
					System.out.println(field.getName() + ": " + field.get(clientelist));
					field.setAccessible(false);
				}
				System.out.println("##################################");
			}
		} catch (IllegalArgumentException | IllegalAccessException |

				SecurityException e) {

			e.printStackTrace();
		}
		Scan.nextLine();
	}
}
