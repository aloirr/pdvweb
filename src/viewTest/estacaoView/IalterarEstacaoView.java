package viewTest.estacaoView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import control.rules.EstacaoRules;
import model.Estacao;
import util.Scan;

public interface IalterarEstacaoView extends IlistarEstacaoView, Scan {

	public static void run() {
		try {
			String opcaoAlterar = "";
			String opcaoCampo = "";
			String novoValorCampo = "";
			Estacao estacao = new Estacao();
			List<Estacao> listaEstacaos = new ArrayList<>();
			while (true) {
				opcaoAlterar = "";
				System.out.println("Por favor, digite o id do estacao que deseja alterar,"
						+ " 'LISTAR' para listar todos " + "ou 'SAIR' para sair");
				opcaoAlterar = Scan.nextLine();
				if (opcaoAlterar.equalsIgnoreCase("listar")) {
					IlistarEstacaoView.run();
				} else if (opcaoAlterar.equalsIgnoreCase("sair")) {
					break;
				} else if ((listaEstacaos = EstacaoRules.searchBy(estacao, "id", opcaoAlterar))
						.size() != 0) {
					System.out.println("Informação do Estacao:");
					for (Field field : listaEstacaos.get(0).getClass().getDeclaredFields()) {

						field.setAccessible(true);
						System.out
								.println(field.getName() + ": " + field.get(listaEstacaos.get(0)));
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
					campoObject = listaEstacaos.get(0).getClass().getDeclaredField(opcaoCampo);
					campoObject.setAccessible(true);
					campoObject.set(listaEstacaos.get(0), novoValorCampo);
					campoObject.setAccessible(false);
					System.out.println(EstacaoRules.update(listaEstacaos.get(0)));

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