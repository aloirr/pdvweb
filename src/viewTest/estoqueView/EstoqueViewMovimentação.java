package viewTest.estoqueView;

public class EstoqueViewMovimenta��o {

	public static void menuEstoqueViewMovimenta��o() {
		String opcao2 = "";
		while (true) {
			System.out.println("Opcoes de movimenta��o\n" + "1)Cadastro de movimenta��es\n"
					+ "2)Consultar movimenta��o\n"+"0)Retornar ao menu anterior\n");
			
			switch (opcao2) {
			case "1":
				IestoqueViewCadastroMovimentacao();
			case "2":
				IestoqueViewConsultaMovimenta��o();
			case "0":
				break;
		}
			break;
	}

}
