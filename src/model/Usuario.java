package model;

public class Usuario {
	private Integer id;
	private String login, senha, nome, cpf, endereco, telefone, permissoes;

	private Usuario(Integer id, String login, String senha, String nome, String cpf,
			String endereco, String telefone, String permissoes) {
		this.login = login;
		this.id = id;
		this.permissoes = permissoes;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Usuario() {
	}

	public static class UsuarioBuilder {
		private Integer id;
		private String login, senha, nome, cpf, endereco, telefone, permissoes;

		public UsuarioBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public UsuarioBuilder permissoes(String permissoes) {
			this.permissoes = permissoes;
			return this;
		}

		public UsuarioBuilder login(String login) {
			this.login = login;
			return this;
		}

		public UsuarioBuilder senha(String senha) {
			this.senha = senha;
			return this;
		}

		public UsuarioBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public UsuarioBuilder endereco(String endereco) {
			this.endereco = endereco;
			return this;
		}

		public UsuarioBuilder telefone(String telefone) {
			this.telefone = telefone;
			return this;
		}

		public UsuarioBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public Usuario build() {
			return new Usuario(id, login, senha, nome, cpf, endereco, telefone, permissoes);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(String permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((permissoes == null) ? 0 : permissoes.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permissoes == null) {
			if (other.permissoes != null)
				return false;
		} else if (!permissoes.equals(other.permissoes))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
