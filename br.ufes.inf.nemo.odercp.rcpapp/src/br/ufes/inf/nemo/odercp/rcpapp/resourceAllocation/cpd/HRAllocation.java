package br.ufes.inf.nemo.odercp.rcpapp.resourceAllocation.cpd;

import java.util.Date;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.Activity;

/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class HRAllocation {

	private HumanResource humanResource;
	private Activity activity;
	private KHumanResource kHumanResource;
	private Date dtBeginProvided;
	private Date dtEndProvided;
	private Date dtBeginEffective;
	private Date dtEndEffective;
	private HRStateAllocation state;
	private Integer dedication;

	public HRAllocation() {
	}

	public HumanResource getHumanResource() {
		return humanResource;
	}

	public void setHumanResource(HumanResource humanResource) {
		this.humanResource = humanResource;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public KHumanResource getkHumanResource() {
		return kHumanResource;
	}

	public void setkHumanResource(KHumanResource kHumanResource) {
		this.kHumanResource = kHumanResource;
	}

	public Date getDtBeginProvided() {
		return dtBeginProvided;
	}

	public void setDtBeginProvided(Date dtBeginProvided) {
		this.dtBeginProvided = dtBeginProvided;
	}

	public Date getDtEndProvided() {
		return dtEndProvided;
	}

	public void setDtEndProvided(Date dtEndProvided) {
		this.dtEndProvided = dtEndProvided;
	}

	public Date getDtBeginEffective() {
		return dtBeginEffective;
	}

	public void setDtBeginEffective(Date dtBeginEffective) {
		this.dtBeginEffective = dtBeginEffective;
	}

	public Date getDtEndEffective() {
		return dtEndEffective;
	}

	public void setDtEndEffective(Date dtEndEffective) {
		this.dtEndEffective = dtEndEffective;
	}

	public HRStateAllocation getState() {
		return state;
	}

	public void setState(HRStateAllocation state) {
		this.state = state;
	}

	public Integer getDedication() {
		return dedication;
	}

	public void setDedication(Integer dedication) {
		this.dedication = dedication;
	}

}
