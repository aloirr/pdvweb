package viewTest2;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import control.dao.UsuarioDAO;
import model.Usuario;
import model.Usuario.UsuarioBuilder;
import util.Md5;

@SuppressWarnings("serial")
@Named("sessionBean")
@SessionScoped
public class Session implements Runnable, Serializable {
	private Integer id, sessaoId;
	private String login, senha;
	private Usuario usuarioSessao;

	// public Sessao(Integer id, Integer sessaoId, String login, String
	// passwordMd5, Usuario usuarioSessao) {
	// super();
	// this.id = id;
	// this.sessaoId = sessaoId;
	// this.login = login;
	// this.senha = passwordMd5;
	// this.usuarioSessao = usuarioSessao;
	//
	// }

	// public Sessao() {
	// }

	public void logar(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		this.run();
		if (this.sessaoId != null) {
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", login);
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);
	}

	@Override
	public void run() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioBuilder usuario = new Usuario.UsuarioBuilder();
		usuario.login(login);
		usuario.senha(Md5.gerar(senha));
		usuarioSessao = usuarioDAO.validaSenha(usuario.build());
		if (usuarioSessao != null) {
			this.sessaoId = ThreadLocalRandom.current().nextInt();
			// GerarMenu menu = new GerarMenu();
			// menu.run(usuarioSessao);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSessaoId() {
		return sessaoId;
	}

	public void setSessaoId(Integer sessaoId) {
		this.sessaoId = sessaoId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuarioSessao() {
		return usuarioSessao;
	}

	public void setUsuarioSessao(Usuario usuarioSessao) {
		this.usuarioSessao = usuarioSessao;
	}

}
