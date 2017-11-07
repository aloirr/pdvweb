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
			System.out.println("Por favor digite o nome completo do Usuario (Obrigatório)");
			usuario.nome(Scan.nextLine());
			System.out.println("Por favor digite o CPF Usuario (Obrigatório)");
			usuario.cpf(Scan.nextLine());
			System.out.println("Por favor digite o endereço completo do Usuario (Obrigatório)");
			usuario.endereco(Scan.nextLine());
			System.out.println("Por favor digite um telefone para o Usuario (Obrigatório)");
			usuario.telefone(Scan.nextLine());
			System.out.println("Por favor digite um login para o Usuario (Obrigatório)");
			usuario.login(Scan.nextLine());
			System.out.println("Por favor digite uma senha para o Usuario (Obrigatório)");
			usuario.senha(Scan.nextLine());
			System.out.println(UsuarioRules.insert(usuario.build()));
			Scan.nextLine();
			break;

		}

	}
}