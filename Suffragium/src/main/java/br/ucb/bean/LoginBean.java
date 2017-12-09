package br.ucb.bean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import br.ucb.dao.LoginDAO;
import br.ucb.entity.Login;
import br.ucb.security.Util;

@SessionScoped
@ManagedBean(name = "loginBean", eager = true)
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -65113916663963880L;

	private Login login = new Login();
	private LoginDAO loginDAO = new LoginDAO();
	// private LoginT loginT = new LoginT();

	public String envia() {

		login = loginDAO.buscarLogin(login.getLogin(), login.getSenha());

		if (login == null) {
			login = new Login();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha inválido",
					"e-mail ou senha inválido.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;

		} else {

			HttpSession session = Util.getSession();
			session.setAttribute("login", login);
			return "/home.xhtml";
		}

	}


	public String logout() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Você foi deslogado", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		HttpSession session = Util.getSession();
		session.invalidate();
		return "/loginPage.xhtml";

	}

	/*
	 * public String logout() { HttpSession session = Util.getSession();
	 * session.invalidate(); return "/loginPage.xhtml"; }
	 */
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public static byte[] hashPassword(final char[] password, final byte[] salt, final int iterations,
			final int keyLength) {

		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
			SecretKey key = skf.generateSecret(spec);
			byte[] res = key.getEncoded();
			return res;

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}

}
