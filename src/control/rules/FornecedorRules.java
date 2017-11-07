package control.rules;

import java.util.HashSet;

import control.dao.FornecedorDAO;
import interfaces.IcontratoRules;
import model.Fornecedor;

public class FornecedorRules implements IcontratoRules<Fornecedor> {

	public String insert(Fornecedor fornecedor) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor obj = new Fornecedor();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios e
		// retorna
		if (!fornecedorDAO.readTable(obj).stream()
				.filter(p -> p.getRazaoSocial().matches(fornecedor.getRazaoSocial())).findAny()
				.isPresent()) {
			fornecedorDAO.insert(fornecedor);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro n�o efetuado! J� existe um fornecedor com o nome: "
					+ fornecedor.getRazaoSocial();
		}

	}

	public String update(Fornecedor fornecedor) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna o pr�prio objeto.
		if (fornecedorDAO.update(fornecedor) > 0) {
			return "Altera��o Realizado com sucesso!";

		} else {
			return "Erro na altera��o! verifique as informa��es digitadas";
		}
	}

	public HashSet<Fornecedor> searchBy(Fornecedor fornecedor, String atributoWhere,
			String stringPequisa) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return fornecedorDAO.searchBy(fornecedor, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		if (fornecedorDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro n�o localizado! tente novamente!";
		}
	}

	public HashSet<Fornecedor> readTable(Fornecedor fornecedor) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		return fornecedorDAO.readTable(fornecedor);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return fornecedorDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return fornecedorDAO.countTable();

	}

	@Override
	public HashSet<Fornecedor> findInSet(Fornecedor fornecedor, String atributoWhere, String stringPequisa) {
			FornecedorDAO fornecedorDAO = new FornecedorDAO();

			// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
			// ent�o retorna true ou false para continuar a pesquisa.

			return fornecedorDAO.findInSet(fornecedor, atributoWhere, stringPequisa);
		}
	}
