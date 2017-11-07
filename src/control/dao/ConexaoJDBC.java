package control.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConexaoFactory;

public class ConexaoJDBC {

	public Connection conn() {
		ConexaoFactory conFactory = new ConexaoFactory.ConexaoFactoryBuilder()
				.nomeDb("store?autoReconnect=true&useSSL=false").host("localhost:3306").tipoDb("mysql").senha("1234")
				.usuario("root").build();

		String url = "jdbc:" + conFactory.getDbType() + "://" + conFactory.getHost() + "/" + conFactory.getDbName();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, conFactory.getUsuario(), conFactory.getSenha());
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PreparedStatement ps(String sql) {
		try {
			PreparedStatement ps = conn().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			return ps;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PreparedStatement ps(String sql, int psKey) {
		try {
			PreparedStatement ps = conn().prepareStatement(sql, psKey);
			return ps;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConn(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void closeConn(PreparedStatement ps, ResultSet rs) {
		try {
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void closeConn(Connection conn, PreparedStatement ps) {
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void closeConn(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConn(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}