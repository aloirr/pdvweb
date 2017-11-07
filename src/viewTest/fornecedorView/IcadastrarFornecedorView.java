package viewTest.fornecedorView;

import control.rules.FornecedorRules;
import model.Fornecedor;
import model.Fornecedor.FornecedorBuilder;
import util.Scan;

public interface IcadastrarFornecedorView extends Scan {
	// nome, unidadeMedida, tipoEmbalagem, qtdPorEmbalagem, fornecedor,
	// armazem;

	public static void run() {
		Integer opcao = 0;
		while (true) {
			FornecedorBuilder fornecedor = new Fornecedor.FornecedorBuilder();
			System.out.println("'1' Para pessoa f�sica ou '2' pessoa Jur�dica");
			opcao = Integer.parseInt(Scan.nextLine());
			if (opcao == 1) {
				System.out.println("Por favor digite a Raz�o Social (Obrigat�rio)");
				fornecedor.razaoSocial(Scan.nextLine());
				System.out.println("Por favor digite o CNPJ sem pontua��es (Obrigat�rio)");
				fornecedor.cnpj(Scan.nextLine());
				System.out.println("Por favor digite a Inscri��o Estadual");
				fornecedor.inscEstadual(Scan.nextLine());
				System.out.println("Por favor digite a Inscri��o Municipal");
				fornecedor.inscMunic(Scan.nextLine());
				System.out.println("Por favor digite a Inscri��o Suframa");
				fornecedor.inscSuframa(Scan.nextLine());
				System.out.println("Por favor digite o Email");
				fornecedor.email(Scan.nextLine());
				System.out.println("Por favor digite o Endere�o (Obrigat�rio)");
				fornecedor.endereco(Scan.nextLine());
				System.out.println("Por favor digite o nome do representante");
				fornecedor.nomeContato(Scan.nextLine());
				System.out.println("Por favor digite o prazo (Formato xx,xx,xx)");
				fornecedor.prazo(Scan.nextLine());
				System.out.println(
						"Por favor digite o telefone para contato (Formato DDDNUMERO, tudo junto)");
				fornecedor.telefone(Scan.nextLine());
				System.out.println(FornecedorRules.insert(fornecedor.build()));
				Scan.nextLine();
				break;
			} else if (opcao == 2) {
				System.out.println("Por favor digite o nome completo do fornecedor (Obrigat�rio)");
				fornecedor.razaoSocial(Scan.nextLine());
				System.out.println("Por favor digite o CPF (Obrigat�rio)");
				fornecedor.cpf(Scan.nextLine());
				System.out.println("Por favor digite o apelido do fornecedor ou nome fantasia");
				fornecedor.nomeFantasia(Scan.nextLine());
				System.out.println("Por favor digite o Email");
				fornecedor.email(Scan.nextLine());
				System.out.println("Por favor digite o Endere�o (Obrigat�rio)");
				fornecedor.endereco(Scan.nextLine());
				System.out.println("Por favor digite o nome do representante");
				fornecedor.nomeContato(Scan.nextLine());
				System.out.println("Por favor digite o prazo (Formato xx-xx-xx)");
				fornecedor.prazo(Scan.nextLine());
				System.out.println(
						"Por favor digite o telefone para contato (Formato DDDNUMERO, tudo junto)");
				fornecedor.telefone(Scan.nextLine());
				System.out.println(FornecedorRules.insert(fornecedor.build()));
				Scan.nextLine();
				break;
			}

		}

	}
}