package util;

import java.lang.reflect.Field;
import java.util.List;

public class ImprimeListaConsole<T> implements Runnable {

	public void run(List<T> lista) {
		try {
			Field[] fields = lista.get(0).getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				System.out.print(field.getName() + " ");
				field.setAccessible(false);
			}
			System.out.println();
			for (T linha : lista) {
				Field[] fields2 = linha.getClass().getDeclaredFields();
				for (Field field2 : fields2) {
					field2.setAccessible(true);
					System.out.print(field2.get(linha) + " ");
					field2.setAccessible(false);
				}
				System.out.println();
			}
			System.out.println("####################");
		} catch (IllegalArgumentException |

				IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
