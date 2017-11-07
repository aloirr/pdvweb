package viewTest.clienteView;

import control.rules.ClienteRules;
import model.Cliente;
import model.Cliente.ClienteBuilder;
import util.Scan;

public interface IcadastrarClienteView extends Scan {
	// nome, unidadeMedida, tipoEmbalagem, qtdPorEmbalagem, fornecedor,
	// armazem;

	public static void run() {
		Integer opcao = 0;
		while (true) {
			ClienteBuilder cliente = new Cliente.ClienteBuilder();
			System.out.println("'1' Para pessoa física ou '2' pessoa Jurídica");
			opcao = Integer.parseInt(Scan.nextLine());
			if (opcao == 1) {
				System.out.println("Por favor digite a Razão Social (Obrigatório)");
				cliente.razaoSocial(Scan.nextLine());
				System.out.println("Por favor digite o CNPJ sem pontuações (Obrigatório)");
				cliente.cnpj(Scan.nextLine());
				System.out.println("Por favor digite a Inscrição Estadual");
				cliente.inscEstadual(Scan.nextLine());
				System.out.println("Por favor digite a Inscrição Municipal");
				cliente.inscMunic(Scan.nextLine());
				System.out.println("Por favor digite a Inscrição Suframa");
				cliente.inscSuframa(Scan.nextLine());
				System.out.println("Por favor digite o Email");
				cliente.email(Scan.nextLine());
				System.out.println("Por favor digite o Endereço (Obrigatório)");
				cliente.endereco(Scan.nextLine());
				System.out.println("Por favor digite o nome do representante");
				cliente.nomeContato(Scan.nextLine());
				System.out.println("Por favor digite o prazo (Formato xx,xx,xx)");
				cliente.prazo(Scan.nextLine());
				System.out.println(
						"Por favor digite o telefone para contato (Formato DDDNUMERO, tudo junto)");
				cliente.telefone(Scan.nextLine());
				System.out.println(ClienteRules.insert(cliente.build()));
				Scan.nextLine();
				break;
			} else if (opcao == 2) {
				System.out.println("Por favor digite o nome completo do cliente (Obrigatório)");
				cliente.razaoSocial(Scan.nextLine());
				System.out.println("Por favor digite o CPF (Obrigatório)");
				cliente.cpf(Scan.nextLine());
				System.out.println("Por favor digite o apelido do cliente ou nome fantasia");
				cliente.nomeFantasia(Scan.nextLine());
				System.out.println("Por favor digite o Email");
				cliente.email(Scan.nextLine());
				System.out.println("Por favor digite o Endereço (Obrigatório)");
				cliente.endereco(Scan.nextLine());
				System.out.println("Por favor digite o nome do representante");
				cliente.nomeContato(Scan.nextLine());
				System.out.println("Por favor digite o prazo (Formato xx-xx-xx)");
				cliente.prazo(Scan.nextLine());
				System.out.println(
						"Por favor digite o telefone para contato (Formato DDDNUMERO, tudo junto)");
				cliente.telefone(Scan.nextLine());
				System.out.println(ClienteRules.insert(cliente.build()));
				Scan.nextLine();
				break;
			}

		}

	}
}