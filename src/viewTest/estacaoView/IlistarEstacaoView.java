package viewTest.estacaoView;

import java.lang.reflect.Field;
import java.util.List;

import control.rules.EstacaoRules;
import model.Estacao;
import util.Scan;

public interface IlistarEstacaoView extends Scan {

	public static void run() {
		Estacao Estacao = new Estacao();
		try {
			List<Estacao> listaEstacaos = EstacaoRules.listarDao(Estacao, "Estacao");
			System.out.println("Lista de Estacaos cadastrados");
			for (Estacao Estacaolist : listaEstacaos) {
				Field[] fields = Estacaolist.getClass().getDeclaredFields();
				System.out.println("Estacao: " + Estacaolist.getNome());
				for (Field field : fields) {
					field.setAccessible(true);
					System.out.println(field.getName() + ": " + field.get(Estacaolist));
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
