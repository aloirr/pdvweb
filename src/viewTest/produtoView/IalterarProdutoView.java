package viewTest.produtoView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import control.rules.ProdutoRules;
import model.Produto;
import util.Scan;

public interface IalterarProdutoView extends IlistarProdutosView, Scan {

	public static void run() {
		try {
			String opcaoAlterar = "";
			String opcaoCampo = "";
			String novoValorCampo = "";
			Produto produto = new Produto();
			List<Produto> listaProdutos = new ArrayList<>();
			while (true) {
				opcaoAlterar = "";
				System.out.println("Por favor, digite o id do produto que deseja alterar,"
						+ " 'LISTAR' para listar todos " + "ou 'SAIR' para sair");
				opcaoAlterar = Scan.nextLine();
				if (opcaoAlterar.equalsIgnoreCase("listar")) {
					IlistarProdutosView.run();
				} else if (opcaoAlterar.equalsIgnoreCase("sair")) {
					break;
				} else if ((listaProdutos = ProdutoRules.searchBy(produto, "id", opcaoAlterar))
						.size() != 0) {
					System.out.println("Informação do Produto:");
					for (Field field : listaProdutos.get(0).getClass().getDeclaredFields()) {

						field.setAccessible(true);
						System.out
								.println(field.getName() + ": " + field.get(listaProdutos.get(0)));
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
					campoObject = listaProdutos.get(0).getClass().getDeclaredField(opcaoCampo);
					campoObject.setAccessible(true);
					campoObject.set(listaProdutos.get(0), novoValorCampo);
					campoObject.setAccessible(false);
					System.out.println(ProdutoRules.update(listaProdutos.get(0)));

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