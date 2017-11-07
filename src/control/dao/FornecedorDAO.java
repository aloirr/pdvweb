package control.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import interfaces.IcontratoDAO;
import model.Fornecedor;
import util.FuncoesAuxiliaresDAO;
import util.RetornaConsultaDAO;

public class FornecedorDAO implements IcontratoDAO<Fornecedor> {

	private static final String table = "fornecedor";

	@Override
	public Integer insert(Fornecedor fornecedor) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlInsert = "INSERT INTO " + table + " ("
				+ FuncoesAuxiliaresDAO.retornaAtributosObjetoString(fornecedor, "id") + ") VALUES("
				+ FuncoesAuxiliaresDAO.retornaValoresObjeto(fornecedor, "id") + ")";
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
	public HashSet<Fornecedor> searchBy(Fornecedor fornecedor, String atributoWhere, String string) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT " + FuncoesAuxiliaresDAO.retornaAtributosObjetoString(fornecedor)
				+ " FROM " + table + " WHERE " + atributoWhere + " LIKE '%" + string + "%'";
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Fornecedor> retornoConsulta = RetornaConsultaDAO.run(rs, fornecedor);
			conexaoJDBC.closeConn(ps, rs);
			return retornoConsulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public HashSet<Fornecedor> readTable(Fornecedor fornecedor) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT * FROM " + table;
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Fornecedor> retornoConsulta = RetornaConsultaDAO.run(rs, fornecedor);
			conexaoJDBC.closeConn(ps, rs);
			return retornoConsulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Long update(Fornecedor fornecedor) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlupdate = FuncoesAuxiliaresDAO.criaSqlUpdate(fornecedor, table);
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
	public HashSet<Fornecedor> findInSet(Fornecedor fornecedor, String atributoWhere,
			String stringPesquisa) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
		String sqlread = "SELECT " + FuncoesAuxiliaresDAO.retornaAtributosObjetoString(fornecedor)
				+ " FROM " + table + " WHERE FIND_IN_SET('" + stringPesquisa + "'," + atributoWhere
				+ ")";
		PreparedStatement ps = conexaoJDBC.ps(sqlread);
		ResultSet rs;
		try {
			rs = ps.executeQuery();
			HashSet<Fornecedor> retornoConsulta = RetornaConsultaDAO.run(rs, fornecedor);
			conexaoJDBC.closeConn(ps, rs);
			return retornoConsulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}