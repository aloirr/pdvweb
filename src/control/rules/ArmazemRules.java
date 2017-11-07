package control.rules;

import java.util.HashSet;

import control.dao.ArmazemDAO;
import interfaces.IcontratoRules;
import model.Armazem;

public class ArmazemRules implements IcontratoRules<Armazem> {

	public String insert(Armazem armazem) {
		ArmazemDAO armazemDAO = new ArmazemDAO();
		Armazem obj = new Armazem();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios e
		// retorna
		if (!armazemDAO.readTable(obj).stream()
				.filter(p -> p.getArmazem_Nome().matches(armazem.getArmazem_Nome())).findAny()
				.isPresent()) {
			armazemDAO.insert(armazem);
			return "Cadastro realizado com sucesso!";

		} else {
			return "Cadastro não efetuado! Já existe um armazem com o nome: "
					+ armazem.getArmazem_Nome();
		}

	}

	public String update(Armazem armazem) {
		ArmazemDAO armazemDAO = new ArmazemDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna o próprio objeto.
		if (armazemDAO.update(armazem) > 0) {
			return "Alteração Realizado com sucesso!";

		} else {
			return "Erro na alteração! verifique as informações digitadas";
		}
	}

	public HashSet<Armazem> searchBy(Armazem armazem, String atributoWhere,
			String stringPequisa) {
		ArmazemDAO armazemDAO = new ArmazemDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return armazemDAO.searchBy(armazem, atributoWhere, stringPequisa);

	}

	public String delete(String id) {
		ArmazemDAO armazemDAO = new ArmazemDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		if (armazemDAO.delete(id) > 0) {
			return "id: " + id + " excluido com sucesso!";
		} else {

			return "registro não localizado! tente novamente!";
		}
	}

	public HashSet<Armazem> readTable(Armazem armazem) {
		ArmazemDAO armazemDAO = new ArmazemDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar o delete.
		return armazemDAO.readTable(armazem);
	}

	public Integer count(String atributoWhere, String stringPequisa) {
		ArmazemDAO armazemDAO = new ArmazemDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return armazemDAO.count(atributoWhere, stringPequisa);

	}

	public Integer countTable() {
		ArmazemDAO armazemDAO = new ArmazemDAO();
		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return armazemDAO.countTable();

	}
	
	@Override
	public HashSet<Armazem> findInSet(Armazem armazem, String atributoWhere, String stringPequisa) {
		ArmazemDAO armazemDAO = new ArmazemDAO();

		// Verifica se os dados do objeto Usuario estão dentro das regras de negócios, e
		// então retorna true ou false para continuar a pesquisa.

		return armazemDAO.findInSet(armazem, atributoWhere, stringPequisa);
	}

}