package model;

import interfaces.IcontratoModel;

public class Armazem implements IcontratoModel {
	Integer id;
	String armazem_Nome;
	Integer tipoDeArmazem;

	public Armazem(Integer id, String armazem_Nome, Integer tipoDeArmazem) {
		super();
		this.id = id;
		this.armazem_Nome = armazem_Nome;
		this.tipoDeArmazem = tipoDeArmazem;
	}

	public Armazem() {
		super();
	}

	public static class ArmazemBuilder {

		Integer id, tipoDeArmazem;
		String armazem_Nome;

		public ArmazemBuilder tipoDeArmazem(Integer tipoDeArmazem) {
			this.tipoDeArmazem = tipoDeArmazem;
			return this;
		}

		public ArmazemBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public ArmazemBuilder armazem_Nome(String armazem_Nome) {
			this.armazem_Nome = armazem_Nome;
			return this;
		}

		public Armazem build() {
			return new Armazem(id, armazem_Nome, tipoDeArmazem);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArmazem_Nome() {
		return armazem_Nome;
	}

	public void setArmazem_Nome(String armazem_Nome) {
		this.armazem_Nome = armazem_Nome;
	}

	public Integer getTipoDeArmazem() {
		return tipoDeArmazem;
	}

	public void setTipoDeArmazem(Integer tipoDeArmazem) {
		this.tipoDeArmazem = tipoDeArmazem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((armazem_Nome == null) ? 0 : armazem_Nome.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipoDeArmazem == null) ? 0 : tipoDeArmazem.hashCode());
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
		Armazem other = (Armazem) obj;
		if (armazem_Nome == null) {
			if (other.armazem_Nome != null)
				return false;
		} else if (!armazem_Nome.equals(other.armazem_Nome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipoDeArmazem == null) {
			if (other.tipoDeArmazem != null)
				return false;
		} else if (!tipoDeArmazem.equals(other.tipoDeArmazem))
			return false;
		return true;
	}

}
