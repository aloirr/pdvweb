package control.rules;

import java.util.HashSet;

import control.dao.ClienteDAO;
import interfaces.IcontratoRules;
import model.Cliente;

public class ClienteRules implements IcontratoRules<Cliente> {

	public String insert(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente obj = new Cliente();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios e
		// retorna
		if (!clienteDAO.readTable(obj).stream()
				.filter(p -> p.getRazaoSocial().matches(cliente.getRazaoSocial())).findAny()
				.isPresent()) {
			clienteDAO.insert(cliente);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro n�o efetuado! J� existe um cliente com o nome: "
					+ cliente.getRazaoSocial();
		}

	}

	public String update(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna o pr�prio objeto.
		if (clienteDAO.update(cliente) > 0) {
			return "Altera��o Realizado com sucesso!";

		} else {
			return "Erro na altera��o! verifique as informa��es digitadas";
		}
	}

	public HashSet<Cliente> searchBy(Cliente cliente, String atributoWhere,
			String stringPequisa) {
		ClienteDAO clienteDAO = new ClienteDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return clienteDAO.searchBy(cliente, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		if (clienteDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro n�o localizado! tente novamente!";
		}
	}

	public HashSet<Cliente> readTable(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		return clienteDAO.readTable(cliente);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		ClienteDAO clienteDAO = new ClienteDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return clienteDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		ClienteDAO clienteDAO = new ClienteDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return clienteDAO.countTable();

	}

	@Override
	public HashSet<Cliente> findInSet(Cliente cliente, String atributoWhere, String stringPequisa) {
		ClienteDAO clienteDAO = new ClienteDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return clienteDAO.findInSet(cliente, atributoWhere, stringPequisa);
	}

}