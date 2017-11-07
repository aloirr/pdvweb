package viewTest.fornecedorView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import control.rules.FornecedorRules;
import model.Fornecedor;
import util.Scan;

public interface IalterarFornecedorView extends IlistarFornecedorView, Scan {

	public static void run() {
		try {
			String opcaoAlterar = "";
			String opcaoCampo = "";
			String novoValorCampo = "";
			Fornecedor Fornecedor = new Fornecedor();
			List<Fornecedor> listaFornecedors = new ArrayList<>();
			while (true) {
				opcaoAlterar = "";
				System.out.println("Por favor, digite o id do Fornecedor que deseja alterar,"
						+ " 'LISTAR' para listar todos " + "ou 'SAIR' para sair");
				opcaoAlterar = Scan.nextLine();
				if (opcaoAlterar.equalsIgnoreCase("listar")) {
					IlistarFornecedorView.run();
				} else if (opcaoAlterar.equalsIgnoreCase("sair")) {
					break;
				} else if ((listaFornecedors =
						FornecedorRules.searchBy(Fornecedor, "id", opcaoAlterar))
								.size() != 0) {
					System.out.println("Informação do Fornecedor:");
					for (Field field : listaFornecedors.get(0).getClass().getDeclaredFields()) {

						field.setAccessible(true);
						System.out.println(
								field.getName() + ": " + field.get(listaFornecedors.get(0)));
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
					campoObject = listaFornecedors.get(0).getClass().getDeclaredField(opcaoCampo);
					campoObject.setAccessible(true);
					campoObject.set(listaFornecedors.get(0), novoValorCampo);
					campoObject.setAccessible(false);
					System.out.println(FornecedorRules.update(listaFornecedors.get(0)));

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