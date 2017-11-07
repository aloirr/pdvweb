package model;

public class ConexaoFactory {
	private String host, url, usuario, senha, dbType, dbName;
	private String conexaoAtiva;

	private ConexaoFactory(String host, String usuario, String senha, String dbType, String dbName) {
		this.host = host;
		this.usuario = usuario;
		this.senha = senha;
		this.dbType = dbType;
		this.dbName = dbName;
	}

	public ConexaoFactory() {

	}

	public static class ConexaoFactoryBuilder {
		private String host, usuario, senha, dbType, dbName;

		public ConexaoFactoryBuilder() {
		}

		public ConexaoFactoryBuilder host(String host) {
			this.host = host;
			return this;
		}

		public ConexaoFactoryBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public ConexaoFactoryBuilder senha(String senha) {
			this.senha = senha;
			return this;
		}

		public ConexaoFactoryBuilder tipoDb(String dbType) {
			this.dbType = dbType;
			return this;
		}

		public ConexaoFactoryBuilder nomeDb(String dbName) {
			this.dbName = dbName;
			return this;
		}

		public ConexaoFactory build() {
			return new ConexaoFactory(host, usuario, senha, dbType, dbName);
		}
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getConexaoAtiva() {
		return conexaoAtiva;
	}

	public void setConexaoAtiva(String conexaoAtiva) {
		this.conexaoAtiva = conexaoAtiva;
	}

}
