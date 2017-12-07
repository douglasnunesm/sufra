package br.ucb.bean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.ucb.dao.LoginDAO;
import br.ucb.entity.Login;

@RequestScoped
@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -65113916663963880L;

	private Login login = new Login();
	private LoginDAO loginDAO = new LoginDAO();
	//private LoginT loginT = new LoginT();

	public String envia() {
		login = loginDAO.buscarLogin(login.getLogin(), login.getSenha());
		if (login == null) {
			login = new Login();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado",
					"e-mail ou senha inválido.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;

		} else {
			return "/home.xhtml";
		}

	}

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
