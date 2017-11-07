package control.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import interfaces.IcontratoDAO;
import model.Menu;
import model.Usuario;
import util.FuncoesAuxiliaresDAO;
import util.RetornaConsultaDAO;

public class MenuDAO implements IcontratoDAO<Menu> {

	private static final String table = "menu";

	@Override
	public Integer insert(Menu menu) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlInsert = "INSERT INTO " + table + " ("
				+ FuncoesAuxiliaresDAO.retornaAtributosObjetoString(menu, "id") + ") VALUES("
				+ FuncoesAuxiliaresDAO.retornaValoresObjeto(menu, "id").toString().replace("[", "")
						.replaceAll("]", "")
				+ ")";
		System.out.println(sqlInsert);
		int psKey = Statement.RETURN_GENERATED_KEYS;
		PreparedStatement ps = conexaoJDBC.ps(sqlInsert, psKey);
		int count = 0;
		try {
			count = ps.executeUpdate();
			System.out.println(count + "registros inserido(s) com sucesso!");
			conexaoJDBC.closeConn(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getSQLState();
		}

		return count;
	}

	@Override
	public HashSet<Menu> searchBy(Menu menu, String atributoWhere, String string) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT " + FuncoesAuxiliaresDAO.retornaAtributosObjetoString(menu)
				+ " FROM " + table + " WHERE " + atributoWhere + " LIKE '%" + string + "%'";
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Menu> retornoConsulta = RetornaConsultaDAO.run(rs, menu);
			conexaoJDBC.closeConn(ps, rs);
			return retornoConsulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public HashSet<Menu> readTable(Menu menu) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT * FROM " + table;
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Menu> retornoConsulta = RetornaConsultaDAO.run(rs, menu);
			conexaoJDBC.closeConn(ps, rs);
			return retornoConsulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Long update(Menu menu) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlupdate = FuncoesAuxiliaresDAO.criaSqlUpdate(menu, table);
		PreparedStatement ps = conexaoJDBC.ps(sqlupdate);
		long count;
		try {
			count = ps.executeLargeUpdate();
			System.out.println(count + "registro(s) atualizado(s) com sucesso!");
			conexaoJDBC.closeConn(ps);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Long delete(String id) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqldelete = "DELETE FROM " + table + " WHERE id=" + id;
		PreparedStatement ps = conexaoJDBC.ps(sqldelete);
		Long count;
		try {
			count = ps.executeLargeUpdate();
			conexaoJDBC.closeConn(ps);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Integer countTable() {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT COUNT(*) FROM " + table;
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			Integer count = rs.getInt("count(*)");
			conexaoJDBC.closeConn(ps, rs);
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Integer count(String atributoWhere, String string) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT COUNT(*) FROM " + table + " WHERE " + atributoWhere + " LIKE '%"
				+ string + "%'";
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			rs.next();
			Integer count = rs.getInt("count(*)");
			conexaoJDBC.closeConn(ps, rs);
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public HashSet<Menu> findInSet(Menu menu, String atributoWhere, String stringPesquisa) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT " + FuncoesAuxiliaresDAO.retornaAtributosObjetoString(menu)
				+ " FROM " + table + " WHERE FIND_IN_SET('" + stringPesquisa + "'," + atributoWhere
				+ ")";
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Menu> retornoConsulta = RetornaConsultaDAO.run(rs, menu);
			conexaoJDBC.closeConn(ps, rs);
			return retornoConsulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Menu> gerarMenu(Usuario usuario) {
		Menu menu = new Menu();
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT " + FuncoesAuxiliaresDAO.retornaAtributosObjetoString(menu)
				+ " FROM " + table + " WHERE FIND_IN_SET(id,'" + usuario.getPermissoes() + "')";
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Menu> retornoConsulta = RetornaConsultaDAO.run(rs, menu);
			conexaoJDBC.closeConn(ps, rs);
			List<Menu> menuUsuario = new ArrayList<>();
			retornoConsulta.parallelStream().iterator().forEachRemaining(p -> menuUsuario.add(p));
			return menuUsuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}