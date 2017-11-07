package model;

import interfaces.IcontratoModel;

public class Cliente implements IcontratoModel {

	private Integer id;
	private String razaoSocial, nomeFantasia, endereco, telefone, email, nomeContato, prazo, cpf, cnpj, inscEstadual,
			inscMunic, inscSuframa;

	private Cliente(Integer id, String razaoSocial, String nomeFantasia, String endereco, String telefone, String email,
			String nomeContato, String prazo, String cpf, String cnpj, String inscEstadual, String inscMunic,
			String inscSuframa) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.nomeContato = nomeContato;
		this.prazo = prazo;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.inscEstadual = inscEstadual;
		this.inscMunic = inscMunic;
		this.inscSuframa = inscSuframa;
	}

	public Cliente() {
	}

	public static class ClienteBuilder {
		private Integer id;
		private String razaoSocial, nomeFantasia, endereco, telefone, email, nomeContato, prazo, cpf, cnpj,
				inscEstadual, inscMunic, inscSuframa;

		public ClienteBuilder id(Integer id) {
			this.id = id;
			return this;

		}

		public ClienteBuilder razaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
			return this;

		}

		public ClienteBuilder nomeFantasia(String nomeFantasia) {
			this.nomeFantasia = nomeFantasia;
			return this;

		}

		public ClienteBuilder endereco(String endereco) {
			this.endereco = endereco;
			return this;

		}

		public ClienteBuilder email(String email) {
			this.email = email;
			return this;

		}

		public ClienteBuilder nomeContato(String nomeContato) {
			this.nomeContato = nomeContato;
			return this;

		}

		public ClienteBuilder prazo(String prazo) {
			this.prazo = prazo;
			return this;

		}

		public ClienteBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;

		}

		public ClienteBuilder cnpj(String cnpj) {
			this.cnpj = cnpj;
			return this;

		}

		public ClienteBuilder inscEstadual(String inscEstadual) {
			this.inscEstadual = inscEstadual;
			return this;

		}

		public ClienteBuilder inscMunic(String inscMunic) {
			this.inscMunic = inscMunic;
			return this;

		}

		public ClienteBuilder inscSuframa(String inscSuframa) {
			this.inscSuframa = inscSuframa;
			return this;

		}

		public ClienteBuilder telefone(String telefone) {
			this.telefone = telefone;
			return this;

		}

		public Cliente build() {
			return new Cliente(id, razaoSocial, nomeFantasia, endereco, telefone, email, nomeContato, prazo, cpf, cnpj,
					inscEstadual, inscMunic, inscSuframa);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscMunic() {
		return inscMunic;
	}

	public void setInscMunic(String inscMunic) {
		this.inscMunic = inscMunic;
	}

	public String getInscSuframa() {
		return inscSuframa;
	}

	public void setInscSuframa(String inscSuframa) {
		this.inscSuframa = inscSuframa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
