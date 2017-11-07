package viewTest;

import java.sql.SQLException;

import model.Cliente;
import viewTest2.GerarMenu;

public class Main {
	public static void main(String[] args) throws SQLException, IllegalArgumentException,
			IllegalAccessException, NoSuchFieldException, SecurityException, InterruptedException {
		// Cliente cliente = new
		Cliente cliente2 = new Cliente.ClienteBuilder().razaoSocial("planeta")
				.nomeFantasia("planeta").email("a@b.c").inscEstadual("55555").inscMunic("333333")
				.inscSuframa("12345").nomeContato("ppk").endereco("ggggg").telefone("99999999")
				.prazo("3060").build();
		Cliente cliente3 = new Cliente.ClienteBuilder().razaoSocial("satelite")
				.nomeFantasia("satelite").email("a@b.c").inscEstadual("55555").inscMunic("333333")
				.inscSuframa("12345").nomeContato("ppk").endereco("hhhhh").telefone("99999999")
				.prazo("3060").build();
		Cliente cliente4 = new Cliente.ClienteBuilder().razaoSocial("nuvem").nomeFantasia("nuvem")
				.email("a@b.c").inscEstadual("55555").inscMunic("333333").inscSuframa("12345")
				.nomeContato("ppk").endereco("iiiiii").telefone("99999999").prazo("3060").build();
		Cliente cliente5 = new Cliente.ClienteBuilder().razaoSocial("galaxia")
				.nomeFantasia("galaxia").email("a@b.c").inscEstadual("55555").inscMunic("333333")
				.inscSuframa("12345").nomeContato("ppk").endereco("zzzzz").telefone("99999999")
				.prazo("3060").build();
		Cliente cliente6 = new Cliente.ClienteBuilder().razaoSocial("universo")
				.nomeFantasia("universo").email("a@b.c").inscEstadual("55555").inscMunic("333333")
				.inscSuframa("12345").nomeContato("ppk").endereco("aaaaaa").telefone("99999999")
				.prazo("3060").build();
		// // INSERINDO COM O ClienteDAO

		// //
		// //
		// // USANDO O SELECT do ClienteDAO
		// Cliente clienteselect = new Cliente();
		// List<Cliente> clientes = GenericCRUD.read(clienteselect, "clientes",
		// "razaoSocial", "%a%");
		// List<Cliente> clientes = GenericCRUD.readAll(clienteselect, "clientes");
		// "aloha").toString());
		// // USANDO O UPDATE DO ClienteDAO
		// cliente2.setCnpj("24242424");
		// cliente2.setId(20);
		// ClienteRules clienteRule = new ClienteRules();
		// clienteRule.alterarRule(cliente2);
		//
		// // // USANDO O DELETE DO ClienteDAO
		// cliente6.setId("21");
		// GenericCRUD.delete("clientes", "razaoSocial='galaxia'");
		// ProdutoView produtoview = new ProdutoView();
		// produtoview.menuProduto();
		// ClienteView clienteview = new ClienteView();
		// clienteview.menuCliente();
		// System.out.println(clientes.size());
		// IordenarClientes.ordenarClientesPorAtributo(clientes, "razaoSocial");
		// IordenarClientes.ordenarClientesPorAtributo(clientes, "endereco");
		// for (Cliente cliente : clientes) {
		// System.out.println(
		// cliente.getId() + " " + cliente.getRazaoSocial() + " " +
		// cliente.getEndereco());
		// }
		// Armazem armazem1 =
		// new
		// Armazem.ArmazemBuilder().armazem_Nome("Fabrica").tipoDeArmazem(2).build();
		// Armazem armazem2 =
		// new Armazem.ArmazemBuilder().armazem_Nome("Loja").tipoDeArmazem(1).build();
		// ArmazemRules armazemrule = new ArmazemRules();
		// System.out.println(armazemrule.cadastrarRule(armazem1));
		// // System.out.println(armazemrule.cadastrarRule(armazem2));
		// List<String> campos = new ArrayList<>();
		// campos.add("Cadastrar");
		// campos.add("Alterar");
		// campos.add("Excluir");
		// campos.add("Listar");
		// Menu menu1 = new
		// Menu.MenuBuilder().titulo("teste10").funcoes(campos).build();
		// Menu menu2 = new
		// Menu.MenuBuilder().titulo("teste11").funcoes(campos).build();
		// MenuRules menuRule = new MenuRules();
		// menuRule.insert(menu1);
		// menuRule.insert(menu2);
		// campos.add("Sair");
		// menu1.setCampos(campos);
		// System.out.println(menuRule.pesquisarRule(menu1, "titulo", "teste4").stream()
		// .map(Menu::getId).findFirst().get());
		// menu1.setId(menuRule.pesquisarRule(menu1, "titulo",
		// "teste4").stream().map(Menu::getId)
		// .findFirst().get());
		// menuRule.alterarRule(menu1);
		// Funcao funcaoobj = new
		// Funcao.FuncaoBuilder().cod_Permissao_Usuario(1).descricao("nada2")
		// .id_Menu(1).build();
		// Funcao funcaoobj2 = new Funcao();
		// FuncaoRules funcao = new FuncaoRules();
		// System.out.println(funcao.insert(funcaoobj));
		GerarMenu gerarMenu = new GerarMenu();
		gerarMenu.gerarMenu(1);

		// Integer oi = 1;
		// System.out.println(oi.toString());
	}
}
