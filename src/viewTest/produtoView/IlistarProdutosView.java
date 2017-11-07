package viewTest.produtoView;

import java.lang.reflect.Field;
import java.util.List;

import control.rules.ProdutoRules;
import model.Produto;
import util.Scan;

public interface IlistarProdutosView extends Scan {

	public static void run() {
		Produto produto = new Produto();
		try {
			List<Produto> listaProdutos = ProdutoRules.listarDao(produto, "produto");
			System.out.println("Lista de produtos cadastrados");
			for (Produto produtolist : listaProdutos) {
				Field[] fields = produtolist.getClass().getDeclaredFields();
				System.out.println("Produto: " + produtolist.getNome());
				for (Field field : fields) {
					field.setAccessible(true);
					System.out.println(field.getName() + ": " + field.get(produtolist));
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
