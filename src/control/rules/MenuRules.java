package control.rules;

import java.util.HashSet;

import control.dao.MenuDAO;
import interfaces.IcontratoRules;
import model.Menu;

public class MenuRules implements IcontratoRules<Menu> {

	public String insert(Menu menu) {
		MenuDAO menuDAO = new MenuDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios e
		// retorna
		menuDAO.insert(menu);
		return "Cadastro realizado com sucesso!";
	}

	public String update(Menu menu) {
		MenuDAO menuDAO = new MenuDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna o pr�prio objeto.
		if (menuDAO.update(menu) > 0) {
			return "Altera��o Realizado com sucesso!";

		} else {
			return "Erro na altera��o! verifique as informa��es digitadas";
		}
	}

	public HashSet<Menu> searchBy(Menu menu, String atributoWhere, String stringPequisa) {
		MenuDAO menuDAO = new MenuDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return menuDAO.searchBy(menu, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		MenuDAO menuDAO = new MenuDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		if (menuDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro n�o localizado! tente novamente!";
		}
	}

	public HashSet<Menu> readTable(Menu menu) {
		MenuDAO menuDAO = new MenuDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		return menuDAO.readTable(menu);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		MenuDAO menuDAO = new MenuDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return menuDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		MenuDAO menuDAO = new MenuDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return menuDAO.countTable();

	}

	@Override
	public HashSet<Menu> findInSet(Menu menu, String atributoWhere, String stringPequisa) {
		MenuDAO menuDAO = new MenuDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return menuDAO.findInSet(menu, atributoWhere, stringPequisa);
	}
}
