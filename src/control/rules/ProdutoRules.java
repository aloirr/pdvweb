package control.rules;

import java.util.HashSet;

import control.dao.ProdutoDAO;
import interfaces.IcontratoRules;
import model.Produto;

public class ProdutoRules implements IcontratoRules<Produto> {

	public String insert(Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto obj = new Produto();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios e
		// retorna
		if (!produtoDAO.readTable(obj).stream().filter(p -> p.getNome().matches(produto.getNome()))
				.findAny().isPresent()) {
			produtoDAO.insert(produto);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro não efetuado! Já existe um produto com o nome: " + produto.getNome();
		}

	}

	public String update(Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna o próprio objeto.
		if (produtoDAO.update(produto) > 0) {
			return "Alteração Realizado com sucesso!";

		} else {
			return "Erro na alteração! verifique as informações digitadas";
		}
	}

	public HashSet<Produto> searchBy(Produto produto, String atributoWhere, String stringPequisa) {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return produtoDAO.searchBy(produto, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		if (produtoDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro não localizado! tente novamente!";
		}
	}

	public HashSet<Produto> readTable(Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		return produtoDAO.readTable(produto);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return produtoDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return produtoDAO.countTable();

	}

	@Override
	public HashSet<Produto> findInSet(Produto produto, String atributoWhere, String stringPequisa) {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return produtoDAO.findInSet(produto, atributoWhere, stringPequisa);
	}

}