package model;

import interfaces.IcontratoModel;

public class Menu implements Comparable<Menu>, IcontratoModel {

	private String menu_Label, menu_Descricao;
	private Integer id, idMenuPai, ordem;

	public Menu(String menu_Label, String menu_Descricao, Integer id, Integer idMenuPai,
			Integer ordem) {
		super();
		this.menu_Label = menu_Label;
		this.menu_Descricao = menu_Descricao;
		this.id = id;
		this.idMenuPai = idMenuPai;
		this.ordem = ordem;
	}

	public Menu() {
		super();
	}

	public static class MenuBuilder {
		private String menu_Label, menu_Descricao;
		private Integer id, idMenuPai, ordem;

		public MenuBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public MenuBuilder ordem(Integer ordem) {
			this.ordem = ordem;
			return this;
		}

		public MenuBuilder idMenuPai(Integer idMenuPai) {
			this.idMenuPai = idMenuPai;
			return this;
		}

		public MenuBuilder menu_Label(String menu_Label) {
			this.menu_Label = menu_Label;
			return this;
		}

		public MenuBuilder menu_Descricao(String menu_Descricao) {
			this.menu_Descricao = menu_Descricao;
			return this;
		}

		public Menu build() {
			return new Menu(menu_Label, menu_Descricao, id, idMenuPai, ordem);

		}
	}

	public String getMenu_Label() {
		return menu_Label;
	}

	public void setMenu_Label(String menu_Label) {
		this.menu_Label = menu_Label;
	}

	public String getMenu_Descricao() {
		return menu_Descricao;
	}

	public void setMenu_Descricao(String menu_Descricao) {
		this.menu_Descricao = menu_Descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdMenuPai() {
		return idMenuPai;
	}

	public void setIdMenuPai(Integer idMenuPai) {
		this.idMenuPai = idMenuPai;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idMenuPai == null) ? 0 : idMenuPai.hashCode());
		result = prime * result + ((menu_Descricao == null) ? 0 : menu_Descricao.hashCode());
		result = prime * result + ((menu_Label == null) ? 0 : menu_Label.hashCode());
		result = prime * result + ((ordem == null) ? 0 : ordem.hashCode());
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
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idMenuPai == null) {
			if (other.idMenuPai != null)
				return false;
		} else if (!idMenuPai.equals(other.idMenuPai))
			return false;
		if (menu_Descricao == null) {
			if (other.menu_Descricao != null)
				return false;
		} else if (!menu_Descricao.equals(other.menu_Descricao))
			return false;
		if (menu_Label == null) {
			if (other.menu_Label != null)
				return false;
		} else if (!menu_Label.equals(other.menu_Label))
			return false;
		if (ordem == null) {
			if (other.ordem != null)
				return false;
		} else if (!ordem.equals(other.ordem))
			return false;
		return true;
	}

	@Override
	public int compareTo(Menu o) {
		if (o.idMenuPai < this.idMenuPai) {
			return 1;
		} else if (o.idMenuPai == this.idMenuPai) {
			if (o.ordem > this.ordem) {
				return 1;
			} else if (o.ordem == this.ordem) {
				if ((o.menu_Descricao.charAt(0) > this.menu_Descricao.charAt(0))) {
					return 1;
				} else if (o.menu_Descricao.charAt(0) == this.menu_Descricao.charAt(0)) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

}
