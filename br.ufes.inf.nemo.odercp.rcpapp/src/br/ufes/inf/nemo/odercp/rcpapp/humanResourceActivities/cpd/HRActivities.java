package br.ufes.inf.nemo.odercp.rcpapp.humanResourceActivities.cpd;

import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */

public class HRActivities {

	private HumanResource humanResource;
	private Set<KHumanResource> roles;

	public HumanResource getHumanResource() {
		return humanResource;
	}

	public void setHumanResource(HumanResource humanResource) {
		this.humanResource = humanResource;
	}

	public Set<KHumanResource> getRoles() {
		return roles;
	}

	public void setRoles(Set<KHumanResource> roles) {
		this.roles = roles;
	}

}
