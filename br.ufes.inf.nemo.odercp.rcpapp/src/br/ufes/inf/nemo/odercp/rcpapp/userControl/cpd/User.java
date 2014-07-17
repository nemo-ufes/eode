package br.ufes.inf.nemo.odercp.rcpapp.userControl.cpd;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;

/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class User {

	private String login;

	private String password;

	private HumanResource humanResource;

	private AcessProfile acessProfile;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HumanResource getHumanResource() {
		return humanResource;
	}

	public void setHumanResource(HumanResource humanResource) {
		this.humanResource = humanResource;
	}

	public AcessProfile getAcessProfile() {
		return acessProfile;
	}

	public void setAcessProfile(AcessProfile acessProfile) {
		this.acessProfile = acessProfile;
	}

}
