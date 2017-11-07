package model;

import interfaces.IcontratoModel;

public class Produto implements IcontratoModel  {
	// USE store;
	// CREATE TABLE produto (
	// id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	// nome VARCHAR(100) NOT NULL,
	// unidadeMedida VARCHAR(10) NOT NULL,
	// tipoEmbalagem VARCHAR(10),
	// qtdPorEmbalagem INT,
	// fornecedor VARCHAR(100) NOT NULL,
	// estoque VARCHAR(100) NOT NULL
	// );

	private Integer id, qtdPorEmbalagem, tipoEmbalagem;
	private String nome, unidadeMedida, fornecedor, estoque;

	private Produto(Integer id, String nome, String unidadeMedida, Integer tipoEmbalagem,
			Integer qtdPorEmbalagem, String fornecedor, String estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.unidadeMedida = unidadeMedida;
		this.tipoEmbalagem = tipoEmbalagem;
		this.qtdPorEmbalagem = qtdPorEmbalagem;
		this.fornecedor = fornecedor;
		this.estoque = estoque;
	}

	public Produto() {
	}

	public static class ProdutoBuilder {
		private Integer id, qtdPorEmbalagem, tipoEmbalagem;
		private String nome, unidadeMedida, fornecedor, estoque;

		public ProdutoBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public ProdutoBuilder unidadeMedida(String unidadeMedida) {
			this.unidadeMedida = unidadeMedida;
			return this;
		}

		public ProdutoBuilder tipoEmbalagem(Integer tipoEmbalagem) {
			this.tipoEmbalagem = tipoEmbalagem;
			return this;
		}

		public ProdutoBuilder qtdPorEmbalagem(Integer qtdPorEmbalagem) {
			this.qtdPorEmbalagem = qtdPorEmbalagem;
			return this;
		}

		public ProdutoBuilder fornecedor(String fornecedor) {
			this.fornecedor = fornecedor;
			return this;
		}

		public ProdutoBuilder estoque(String estoque) {
			this.estoque = estoque;
			return this;
		}

		public ProdutoBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public Produto build() {
			return new Produto(id, nome, unidadeMedida, tipoEmbalagem, qtdPorEmbalagem, fornecedor,
					estoque);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Integer getTipoEmbalagem() {
		return tipoEmbalagem;
	}

	public void setTipoEmbalagem(Integer tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}

	public Integer getQtdPorEmbalagem() {
		return qtdPorEmbalagem;
	}

	public void setQtdPorEmbalagem(Integer qtdPorEmbalagem) {
		this.qtdPorEmbalagem = qtdPorEmbalagem;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
