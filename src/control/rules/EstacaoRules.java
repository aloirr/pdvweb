package control.rules;

import java.util.HashSet;

import control.dao.EstacaoDAO;
import interfaces.IcontratoRules;
import model.Estacao;

public class EstacaoRules implements IcontratoRules<Estacao> {

	public String insert(Estacao estacao) {
		EstacaoDAO estacaoDAO = new EstacaoDAO();
		Estacao obj = new Estacao();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios e
		// retorna
		if (!estacaoDAO.readTable(obj).stream().filter(p -> p.getNome().matches(estacao.getNome()))
				.findAny().isPresent()) {
			estacaoDAO.insert(estacao);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro n�o efetuado! J� existe um estacao com o nome: " + estacao.getNome();
		}

	}

	public String update(Estacao estacao) {
		EstacaoDAO estacaoDAO = new EstacaoDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna o pr�prio objeto.
		if (estacaoDAO.update(estacao) > 0) {
			return "Altera��o Realizado com sucesso!";

		} else {
			return "Erro na altera��o! verifique as informa��es digitadas";
		}
	}

	public HashSet<Estacao> searchBy(Estacao estacao, String atributoWhere, String stringPequisa) {
		EstacaoDAO estacaoDAO = new EstacaoDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return estacaoDAO.searchBy(estacao, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		EstacaoDAO estacaoDAO = new EstacaoDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		if (estacaoDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro n�o localizado! tente novamente!";
		}
	}

	public HashSet<Estacao> readTable(Estacao estacao) {
		EstacaoDAO estacaoDAO = new EstacaoDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		return estacaoDAO.readTable(estacao);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		EstacaoDAO estacaoDAO = new EstacaoDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return estacaoDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		EstacaoDAO estacaoDAO = new EstacaoDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return estacaoDAO.countTable();

	}

	@Override
	public HashSet<Estacao> findInSet(Estacao estacao, String atributoWhere, String stringPequisa) {
		EstacaoDAO estacaoDAO = new EstacaoDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return estacaoDAO.findInSet(estacao, atributoWhere, stringPequisa);
	}
}
