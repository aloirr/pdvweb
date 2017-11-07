package control.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import interfaces.IcontratoDAO;
import model.Cliente;
import util.FuncoesAuxiliaresDAO;
import util.RetornaConsultaDAO;

public class ClienteDAO implements IcontratoDAO<Cliente> {

	private static final String table = "clientes";

	@Override
	public Integer insert(Cliente cliente) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlInsert = "INSERT INTO " + table + " ("
				+ FuncoesAuxiliaresDAO.retornaAtributosObjetoString(cliente, "id") + ") VALUES("
				+ FuncoesAuxiliaresDAO.retornaValoresObjeto(cliente, "id") + ")";
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
	public HashSet<Cliente> searchBy(Cliente cliente, String atributoWhere, String string) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT " + FuncoesAuxiliaresDAO.retornaAtributosObjetoString(cliente)
				+ " FROM " + table + " WHERE " + atributoWhere + " LIKE '%" + string + "%'";
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Cliente> retornoConsulta = RetornaConsultaDAO.run(rs, cliente);
			conexaoJDBC.closeConn(ps, rs);
			return retornoConsulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public HashSet<Cliente> readTable(Cliente cliente) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT * FROM " + table;
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Cliente> retornoConsulta = RetornaConsultaDAO.run(rs, cliente);
			conexaoJDBC.closeConn(ps, rs);
			return retornoConsulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Long update(Cliente cliente) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlupdate = FuncoesAuxiliaresDAO.criaSqlUpdate(cliente, table);
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
	public HashSet<Cliente> findInSet(Cliente cliente, String atributoWhere, String stringPesquisa) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT " + FuncoesAuxiliaresDAO.retornaAtributosObjetoString(cliente)
				+ " FROM " + table + " WHERE FIND_IN_SET('" + stringPesquisa + "'," + atributoWhere
				+ ")";
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Cliente> retornoConsulta = RetornaConsultaDAO.run(rs, cliente);
			conexaoJDBC.closeConn(ps, rs);
			return retornoConsulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}