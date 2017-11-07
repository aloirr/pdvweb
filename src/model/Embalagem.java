package model;

import interfaces.IcontratoModel;

public class Embalagem implements IcontratoModel {

	Integer id, conversor;
	String embalagem_Label;

	public Embalagem(Integer id, String embalagem_Label) {
		super();
		this.id = id;
		this.embalagem_Label = embalagem_Label;
	}

	public Embalagem() {
		super();
	}

	public static class EmbalagemBuilder {

		Integer id;
		String embalagem_Label;

		public EmbalagemBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public EmbalagemBuilder embalagem_Label(String embalagem_Label) {
			this.embalagem_Label = embalagem_Label;
			return this;
		}

		public Embalagem build() {
			return new Embalagem(id, embalagem_Label);
		}
	}

	public Integer getEmbalagem_Id() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmbalagem_Label() {
		return embalagem_Label;
	}

	public void setEmbalagem_Label(String embalagem_Label) {
		this.embalagem_Label = embalagem_Label;
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
		Embalagem other = (Embalagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
