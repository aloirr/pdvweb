package model;

public class Estacao {
	private Integer id;
	private String ip, status, infoAdicional, nome;

	private Estacao(int id, String nome, String ip, String status, String infoAdicional) {
		this.nome = nome;
		this.id = id;
		this.ip = ip;
		this.status = status;
		this.infoAdicional = infoAdicional;
	}

	public Estacao() {
	};

	public static class EstacaoBuilder {
		private int id;
		private String nome, ip, status, infoAdicional;

		public EstacaoBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public EstacaoBuilder id(int id) {
			this.id = id;
			return this;
		}

		public EstacaoBuilder ip(String ip) {
			this.ip = ip;
			return this;
		}

		public EstacaoBuilder status(String status) {
			this.status = status;
			return this;
		}

		public EstacaoBuilder infoAdicional(String infoAdicional) {
			this.infoAdicional = infoAdicional;
			return this;
		}

		public Estacao build() {
			return new Estacao(id, nome, ip, status, infoAdicional);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Estacao other = (Estacao) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
