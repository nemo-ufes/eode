package br.ufes.inf.nemo.odercp.rcpapp.resourceAllocation.cpd;

import java.util.Date;

/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class HRCancellationAllocation {

	private HRAllocation hRAllocation;
	private String reason;
	private Date date;
	private HRStateAllocation previousState;

	public HRAllocation gethRAllocation() {
		return hRAllocation;
	}

	public void sethRAllocation(HRAllocation hRAllocation) {
		this.hRAllocation = hRAllocation;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public HRStateAllocation getPreviousState() {
		return previousState;
	}

	public void setPreviousState(HRStateAllocation previousState) {
		this.previousState = previousState;
	}

}
