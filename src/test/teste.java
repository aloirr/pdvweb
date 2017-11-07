package test;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named("testeBean")
@SessionScoped
public class teste implements Serializable {
	private String validador;

	public void validar() {
		this.validador = "true";

	}

	public void invalidar() {
		this.validador = "false";
private MenuModel menu;
	}

	public String getValidador() {
		return validador;
	}

	public void setValidador(String validador) {
		this.validador = validador;
	}

}
