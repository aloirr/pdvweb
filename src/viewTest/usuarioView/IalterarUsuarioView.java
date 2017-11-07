package viewTest.usuarioView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import control.rules.UsuarioRules;
import model.Usuario;
import util.Scan;

public interface IalterarUsuarioView extends IlistarUsuarioView, Scan {

	public static void run() {
		try {
			String opcaoAlterar = "";
			String opcaoCampo = "";
			String novoValorCampo = "";
			Usuario Usuario = new Usuario();
			List<Usuario> listaUsuarios = new ArrayList<>();
			while (true) {
				opcaoAlterar = "";
				System.out.println("Por favor, digite o id do Usuario que deseja alterar,"
						+ " 'LISTAR' para listar todos " + "ou 'SAIR' para sair");
				opcaoAlterar = Scan.nextLine();
				if (opcaoAlterar.equalsIgnoreCase("listar")) {
					IlistarUsuarioView.run();
				} else if (opcaoAlterar.equalsIgnoreCase("sair")) {
					break;
				} else if ((listaUsuarios = UsuarioRules.searchBy(Usuario, "id", opcaoAlterar))
						.size() != 0) {
					System.out.println("Informação do Usuario:");
					for (Field field : listaUsuarios.get(0).getClass().getDeclaredFields()) {

						field.setAccessible(true);
						System.out
								.println(field.getName() + ": " + field.get(listaUsuarios.get(0)));
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
					campoObject = listaUsuarios.get(0).getClass().getDeclaredField(opcaoCampo);
					campoObject.setAccessible(true);
					campoObject.set(listaUsuarios.get(0), novoValorCampo);
					campoObject.setAccessible(false);
					System.out.println(UsuarioRules.update(listaUsuarios.get(0)));

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