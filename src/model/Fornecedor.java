package model;

import interfaces.IcontratoModel;

public class Fornecedor implements IcontratoModel {
	private Integer id;
	private String cpf, cnpj, inscMunic, inscEstadual, inscSuframa, razaoSocial, nomeFantasia,
			endereco, telefone, nomeContato, email, prazo, representante;

	private Fornecedor(int id, String cpf, String cnpj, String inscMunic, String inscEstadual,
			String inscSuframa, String razaoSocial, String nomeFantasia, String endereco,
			String telefone, String nomeContato, String email, String prazo, String representante) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.inscMunic = inscMunic;
		this.inscEstadual = inscEstadual;
		this.inscSuframa = inscSuframa;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nomeContato = nomeContato;
		this.email = email;
		this.prazo = prazo;
		this.representante = representante;
	}

	public Fornecedor() {
	};

	public static class FornecedorBuilder {
		private int id;
		private String cpf, cnpj, inscMunic, inscEstadual, inscSuframa, razaoSocial, nomeFantasia,
				endereco, telefone, nomeContato, email, prazo, representante;

		public FornecedorBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public FornecedorBuilder cnpj(String cnpj) {
			this.cnpj = cnpj;
			return this;
		}

		public FornecedorBuilder inscMunic(String inscMunic) {
			this.inscMunic = inscMunic;
			return this;
		}

		public FornecedorBuilder inscEstadual(String inscEstadual) {
			this.inscEstadual = inscEstadual;
			return this;
		}

		public FornecedorBuilder inscSuframa(String inscSuframa) {
			this.inscSuframa = inscSuframa;
			return this;
		}

		public FornecedorBuilder id(int id) {
			this.id = id;
			return this;
		}

		public FornecedorBuilder razaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
			return this;
		}

		public FornecedorBuilder nomeFantasia(String nomeFantasia) {
			this.nomeFantasia = nomeFantasia;
			return this;
		}

		public FornecedorBuilder endereco(String endereco) {
			this.endereco = endereco;
			return this;
		}

		public FornecedorBuilder telefone(String telefone) {
			this.telefone = telefone;
			return this;
		}

		public FornecedorBuilder nomeContato(String nomeContato) {
			this.nomeContato = nomeContato;
			return this;
		}

		public FornecedorBuilder email(String email) {
			this.email = email;
			return this;
		}

		public FornecedorBuilder prazo(String prazo) {
			this.prazo = prazo;
			return this;
		}

		public FornecedorBuilder representante(String representante) {
			this.representante = representante;
			return this;
		}

		public Fornecedor build() {
			return new Fornecedor(id, cpf, cnpj, inscMunic, inscEstadual, inscSuframa, razaoSocial,
					nomeFantasia, endereco, telefone, nomeContato, email, prazo, representante);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
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

	public String getInscMunic() {
		return inscMunic;
	}

	public void setInscMunic(String inscMunic) {
		this.inscMunic = inscMunic;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
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
		result = prime * result + id;
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
		Fornecedor other = (Fornecedor) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
