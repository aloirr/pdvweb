package control.rules;

import java.util.HashSet;

import control.dao.UsuarioDAO;
import interfaces.IcontratoRules;
import model.Usuario;

public class UsuarioRules implements IcontratoRules<Usuario> {

	public String insert(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario obj = new Usuario();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios e
		// retorna
		if (!usuarioDAO.readTable(obj).stream().filter(p -> p.getNome().matches(usuario.getNome()))
				.findAny().isPresent()) {
			usuarioDAO.insert(usuario);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro n�o efetuado! J� existe um usuario com o nome: " + usuario.getNome();
		}

	}

	public String update(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna o pr�prio objeto.
		if (usuarioDAO.update(usuario) > 0) {
			return "Altera��o Realizado com sucesso!";

		} else {
			return "Erro na altera��o! verifique as informa��es digitadas";
		}
	}

	public HashSet<Usuario> searchBy(Usuario usuario, String atributoWhere, String stringPequisa) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return usuarioDAO.searchBy(usuario, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		if (usuarioDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro n�o localizado! tente novamente!";
		}
	}

	public HashSet<Usuario> readTable(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		return usuarioDAO.readTable(usuario);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return usuarioDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return usuarioDAO.countTable();

	}

	@Override
	public HashSet<Usuario> findInSet(Usuario usuario, String atributoWhere, String stringPequisa) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return usuarioDAO.findInSet(usuario, atributoWhere, stringPequisa);
	}

}