package viewTest.estoqueView;

public class EstoqueViewMovimentação {

	public static void menuEstoqueViewMovimentação() {
		String opcao2 = "";
		while (true) {
			System.out.println("Opcoes de movimentação\n" + "1)Cadastro de movimentações\n"
					+ "2)Consultar movimentação\n"+"0)Retornar ao menu anterior\n");
			
			switch (opcao2) {
			case "1":
				IestoqueViewCadastroMovimentacao();
			case "2":
				IestoqueViewConsultaMovimentação();
			case "0":
				break;
		}
			break;
	}

}
