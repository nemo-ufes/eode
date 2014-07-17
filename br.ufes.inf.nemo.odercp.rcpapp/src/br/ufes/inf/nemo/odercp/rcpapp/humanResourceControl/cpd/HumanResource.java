package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd;


import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
/**
 * Class Human Resource with yours attributes and features.
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the workLoad
	 */
	public Integer getWorkLoad() {
		return workLoad;
	}

	/**
	 * @param workLoad the workLoad to set
	 */
	public void setWorkLoad(Integer workLoad) {
		this.workLoad = workLoad;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public KHumanResource getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(KHumanResource role) {
		this.role = role;
	}
	
	
	
}