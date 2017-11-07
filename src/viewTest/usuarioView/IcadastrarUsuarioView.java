package viewTest.usuarioView;

import control.rules.UsuarioRules;
import model.Usuario;
import model.Usuario.UsuarioBuilder;
import util.Scan;

public interface IcadastrarUsuarioView extends Scan {
	// nome, unidadeMedida, tipoEmbalagem, qtdPorEmbalagem, fornecedor,
	// armazem;

	public static void run() {
		while (true) {
			UsuarioBuilder usuario = new Usuario.UsuarioBuilder();
			System.out.println("Por favor digite o nome completo do Usuario (Obrigat�rio)");
			usuario.nome(Scan.nextLine());
			System.out.println("Por favor digite o CPF Usuario (Obrigat�rio)");
			usuario.cpf(Scan.nextLine());
			System.out.println("Por favor digite o endere�o completo do Usuario (Obrigat�rio)");
			usuario.endereco(Scan.nextLine());
			System.out.println("Por favor digite um telefone para o Usuario (Obrigat�rio)");
			usuario.telefone(Scan.nextLine());
			System.out.println("Por favor digite um login para o Usuario (Obrigat�rio)");
			usuario.login(Scan.nextLine());
			System.out.println("Por favor digite uma senha para o Usuario (Obrigat�rio)");
			usuario.senha(Scan.nextLine());
			System.out.println(UsuarioRules.insert(usuario.build()));
			Scan.nextLine();
			break;

		}

	}
}