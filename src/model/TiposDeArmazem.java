package model;

import interfaces.IcontratoModel;

public class TiposDeArmazem implements IcontratoModel {
	Integer id;
	String tipoDeArmazem_Nome;

	public TiposDeArmazem(Integer id, String tipoDeArmazem_Nome) {
		super();
		this.id = id;
		this.tipoDeArmazem_Nome = tipoDeArmazem_Nome;
	}

	public TiposDeArmazem() {
		super();
	}

	public static class tipoDeArmazemBuilder {

		Integer id;
		String tipoDeArmazem_Nome;

		public tipoDeArmazemBuilder Id(Integer id) {
			this.id = id;
			return this;
		}

		public tipoDeArmazemBuilder tipoDeArmazem_Nome(String tipoDeArmazem_Nome) {
			this.tipoDeArmazem_Nome = tipoDeArmazem_Nome;
			return this;
		}

		public TiposDeArmazem build() {
			return new TiposDeArmazem(id, tipoDeArmazem_Nome);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoDeArmazem_Nome() {
		return tipoDeArmazem_Nome;
	}

	public void setTipoDeArmazem_Nome(String tipoDeArmazem_Nome) {
		this.tipoDeArmazem_Nome = tipoDeArmazem_Nome;
	}

}
