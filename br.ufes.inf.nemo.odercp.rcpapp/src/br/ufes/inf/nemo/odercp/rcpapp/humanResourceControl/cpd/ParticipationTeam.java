package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd;

import java.util.Date;
import java.util.Set;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class ParticipationTeam {

	private Team team;
	private HumanResource humanResource;
	private Set<KHumanResource> roles;
	private Date dtBegin;
	private Date dtend;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

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

	public Date getDtBegin() {
		return dtBegin;
	}

	public void setDtBegin(Date dtBegin) {
		this.dtBegin = dtBegin;
	}

	public Date getDtend() {
		return dtend;
	}

	public void setDtend(Date dtend) {
		this.dtend = dtend;
	}

}
