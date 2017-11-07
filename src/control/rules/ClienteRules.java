package control.rules;

import java.util.HashSet;

import control.dao.ClienteDAO;
import interfaces.IcontratoRules;
import model.Cliente;

public class ClienteRules implements IcontratoRules<Cliente> {

	public String insert(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente obj = new Cliente();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios e
		// retorna
		if (!clienteDAO.readTable(obj).stream()
				.filter(p -> p.getRazaoSocial().matches(cliente.getRazaoSocial())).findAny()
				.isPresent()) {
			clienteDAO.insert(cliente);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro não efetuado! Já existe um cliente com o nome: "
					+ cliente.getRazaoSocial();
		}

	}

	public String update(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna o próprio objeto.
		if (clienteDAO.update(cliente) > 0) {
			return "Alteração Realizado com sucesso!";

		} else {
			return "Erro na alteração! verifique as informações digitadas";
		}
	}

	public HashSet<Cliente> searchBy(Cliente cliente, String atributoWhere,
			String stringPequisa) {
		ClienteDAO clienteDAO = new ClienteDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return clienteDAO.searchBy(cliente, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		if (clienteDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro não localizado! tente novamente!";
		}
	}

	public HashSet<Cliente> readTable(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		return clienteDAO.readTable(cliente);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		ClienteDAO clienteDAO = new ClienteDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return clienteDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		ClienteDAO clienteDAO = new ClienteDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return clienteDAO.countTable();

	}

	@Override
	public HashSet<Cliente> findInSet(Cliente cliente, String atributoWhere, String stringPequisa) {
		ClienteDAO clienteDAO = new ClienteDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return clienteDAO.findInSet(cliente, atributoWhere, stringPequisa);
	}

}