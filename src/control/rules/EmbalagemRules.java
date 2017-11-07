package control.rules;

import java.util.HashSet;

import control.dao.EmbalagemDAO;
import interfaces.IcontratoRules;
import model.Embalagem;

public class EmbalagemRules implements IcontratoRules<Embalagem> {

	public String insert(Embalagem embalagem) {
		EmbalagemDAO embalagemDAO = new EmbalagemDAO();
		Embalagem obj = new Embalagem();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios e
		// retorna
		if (!embalagemDAO.readTable(obj).stream()
				.filter(p -> p.getEmbalagem_Label().matches(embalagem.getEmbalagem_Label()))
				.findAny().isPresent()) {
			embalagemDAO.insert(embalagem);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro não efetuado! Já existe um embalagem com o nome: "
					+ embalagem.getEmbalagem_Label();
		}

	}

	public String update(Embalagem embalagem) {
		EmbalagemDAO embalagemDAO = new EmbalagemDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna o próprio objeto.
		if (embalagemDAO.update(embalagem) > 0) {
			return "Alteração Realizado com sucesso!";

		} else {
			return "Erro na alteração! verifique as informações digitadas";
		}
	}

	public HashSet<Embalagem> searchBy(Embalagem embalagem, String atributoWhere,
			String stringPequisa) {
		EmbalagemDAO embalagemDAO = new EmbalagemDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return embalagemDAO.searchBy(embalagem, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		EmbalagemDAO embalagemDAO = new EmbalagemDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		if (embalagemDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro não localizado! tente novamente!";
		}
	}

	public HashSet<Embalagem> readTable(Embalagem embalagem) {
		EmbalagemDAO embalagemDAO = new EmbalagemDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		return embalagemDAO.readTable(embalagem);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		EmbalagemDAO embalagemDAO = new EmbalagemDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return embalagemDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		EmbalagemDAO embalagemDAO = new EmbalagemDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return embalagemDAO.countTable();

	}

	@Override
	public HashSet<Embalagem> findInSet(Embalagem embalagem, String atributoWhere,
			String stringPequisa) {
		EmbalagemDAO embalagemDAO = new EmbalagemDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return embalagemDAO.findInSet(embalagem, atributoWhere, stringPequisa);
	}
}
