package control.rules;

import java.util.HashSet;

import control.dao.UsuarioDAO;
import interfaces.IcontratoRules;
import model.Usuario;

public class UsuarioRules implements IcontratoRules<Usuario> {

	public String insert(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario obj = new Usuario();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios e
		// retorna
		if (!usuarioDAO.readTable(obj).stream().filter(p -> p.getNome().matches(usuario.getNome()))
				.findAny().isPresent()) {
			usuarioDAO.insert(usuario);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro não efetuado! Já existe um usuario com o nome: " + usuario.getNome();
		}

	}

	public String update(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna o próprio objeto.
		if (usuarioDAO.update(usuario) > 0) {
			return "Alteração Realizado com sucesso!";

		} else {
			return "Erro na alteração! verifique as informações digitadas";
		}
	}

	public HashSet<Usuario> searchBy(Usuario usuario, String atributoWhere, String stringPequisa) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return usuarioDAO.searchBy(usuario, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		if (usuarioDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro não localizado! tente novamente!";
		}
	}

	public HashSet<Usuario> readTable(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		return usuarioDAO.readTable(usuario);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return usuarioDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return usuarioDAO.countTable();

	}

	@Override
	public HashSet<Usuario> findInSet(Usuario usuario, String atributoWhere, String stringPequisa) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return usuarioDAO.findInSet(usuario, atributoWhere, stringPequisa);
	}

}