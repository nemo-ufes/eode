package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd;


import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */

public class HumanResource {

	protected String name;
	private boolean active;
	private Integer workLoad;
	private String phone;
	private String email;
	private KHumanResource role;

	public HumanResource() {
		setActive(true);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(Integer workLoad) {
		this.workLoad = workLoad;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public KHumanResource getRole() {
		return role;
	}

	public void setRole(KHumanResource role) {
		this.role = role;
	}

	

	
}