package viewTest.estacaoView;

import control.rules.EstacaoRules;
import model.Estacao;
import model.Estacao.EstacaoBuilder;
import util.Scan;

public interface IcadastrarEstacaoView extends Scan {
	// nome, unidadeMedida, tipoEmbalagem, qtdPorEmbalagem, fornecedor,
	// armazem;

	public static void run() {
		while (true) {
			EstacaoBuilder estacao = new Estacao.EstacaoBuilder();
			System.out.println("Por favor digite o nome da esta��o");
			estacao.nome(Scan.nextLine());
			System.out.println("Por favor digite o IP da m�quina (Obrigat�rio)");
			estacao.ip(Scan.nextLine());
			System.out.println("Por favor digite alguma informa��o adicional.");
			estacao.infoAdicional(Scan.nextLine());

			System.out.println(EstacaoRules.insert(estacao.build()));
			Scan.nextLine();
			break;

		}

	}
}