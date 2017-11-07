package control.rules;

import java.util.HashSet;

import control.dao.ProdutoDAO;
import interfaces.IcontratoRules;
import model.Produto;

public class ProdutoRules implements IcontratoRules<Produto> {

	public String insert(Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto obj = new Produto();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios e
		// retorna
		if (!produtoDAO.readTable(obj).stream().filter(p -> p.getNome().matches(produto.getNome()))
				.findAny().isPresent()) {
			produtoDAO.insert(produto);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro n�o efetuado! J� existe um produto com o nome: " + produto.getNome();
		}

	}

	public String update(Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna o pr�prio objeto.
		if (produtoDAO.update(produto) > 0) {
			return "Altera��o Realizado com sucesso!";

		} else {
			return "Erro na altera��o! verifique as informa��es digitadas";
		}
	}

	public HashSet<Produto> searchBy(Produto produto, String atributoWhere, String stringPequisa) {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return produtoDAO.searchBy(produto, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		if (produtoDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro n�o localizado! tente novamente!";
		}
	}

	public HashSet<Produto> readTable(Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar o delete.
		return produtoDAO.readTable(produto);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return produtoDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return produtoDAO.countTable();

	}

	@Override
	public HashSet<Produto> findInSet(Produto produto, String atributoWhere, String stringPequisa) {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Verifica se os dados do objeto Usuario est�o dentro das regras de neg�cios, e
		// ent�o retorna true ou false para continuar a pesquisa.

		return produtoDAO.findInSet(produto, atributoWhere, stringPequisa);
	}

}