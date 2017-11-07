package viewTest2;

import control.rules.MenuRules;
import control.rules.UsuarioRules;
import model.Menu;
import model.TiposDeArmazem;
import model.Usuario;
import util.CriaTabelasModel;
import util.Md5;

public class MainTest {

	public static void main(String[] args) {
		MenuRules menuRule = new MenuRules();
		CriaTabelasModel criarTabela = new CriaTabelasModel();
		TiposDeArmazem armazemTypes = new TiposDeArmazem();
		Usuario usuarioModel = new Usuario();
		Menu menu = new Menu();
		Menu menu0 = new Menu.MenuBuilder().menu_Label("Clientes").ordem(1)
				.menu_Descricao("opções de clientes").idMenuPai(-1).build();
		Menu menu1 = new Menu.MenuBuilder().menu_Label("cadastrar cliente").ordem(1).idMenuPai(1)
				.menu_Descricao("cadastrar cliente").build();
		Menu menu2 = new Menu.MenuBuilder().menu_Label("excluir cliente").ordem(2).idMenuPai(1)
				.menu_Descricao("excluir cliente").build();
		Menu menu3 = new Menu.MenuBuilder().menu_Label("alterar cliente").ordem(3).idMenuPai(1)
				.menu_Descricao("altrar cliente").build();
		Menu menu4 = new Menu.MenuBuilder().menu_Label("listar cliente").ordem(4).idMenuPai(1)
				.menu_Descricao("listar cliente").build();
		Menu menu5 = new Menu.MenuBuilder().menu_Label("consultar cliente").ordem(0).idMenuPai(1)
				.menu_Descricao("consultar cliente").build();
		Menu menu6 = new Menu.MenuBuilder().menu_Label("Produto").ordem(1)
				.menu_Descricao("opções de produto").idMenuPai(-1).build();
		Menu menu7 = new Menu.MenuBuilder().menu_Label("cadastrar produto").ordem(1).idMenuPai(2)
				.menu_Descricao("cadastrar produto").build();
		menuRule.insert(menu0);
		menuRule.insert(menu1);
		menuRule.insert(menu2);
		menuRule.insert(menu3);
		menuRule.insert(menu4);
		menuRule.insert(menu5);
		menuRule.insert(menu6);
		menuRule.insert(menu7);
		Usuario usuario1 = new Usuario.UsuarioBuilder().nome("Alexandre Guerreiro")
				.cpf("93965818287")
				.endereco("Rua antonio pinheiro galvao, 928 - buritis - boa vista - roraima")
				.login("aloi").senha(Md5.gerar("sexo123")).telefone("99154-4158").build();
		System.out.println(usuario1.getCpf());
		System.out.println(usuario1.getNome());
		System.out.println(usuario1.getEndereco());
		// criarTabela.criarTabela(armazemTypes, "id", "TipoDeArmazem");
		// System.out.println(Md5.validar("7c8609ffaff78d0eb8bb0353894dc628",
		// "sexo123"));

		criarTabela.criarTabela(usuarioModel, "id", "usuario");
		criarTabela.criarTabela(menu, "id", "menu");
		UsuarioRules usuarioRules = new UsuarioRules();
		usuarioRules.insert(usuario1);
		Session session = new Session();
		session.run();
		// Thread sessionThread = new Thread(session);
		// sessionThread.start();
	}
}
