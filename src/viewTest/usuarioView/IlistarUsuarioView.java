package viewTest.usuarioView;

import java.lang.reflect.Field;
import java.util.List;

import control.rules.UsuarioRules;
import model.Usuario;
import util.Scan;

public interface IlistarUsuarioView extends Scan {

	public static void run() {
		Usuario usuario = new Usuario();
		try {
			List<Usuario> listaUsuarios = UsuarioRules.listarDao(usuario, "usuario");
			System.out.println("Lista de usuarios cadastrados");
			for (Usuario usuariolist : listaUsuarios) {
				Field[] fields = usuariolist.getClass().getDeclaredFields();
				System.out.println("Usuario: " + usuariolist.getNome());
				for (Field field : fields) {
					field.setAccessible(true);
					System.out.println(field.getName() + ": " + field.get(usuariolist));
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
