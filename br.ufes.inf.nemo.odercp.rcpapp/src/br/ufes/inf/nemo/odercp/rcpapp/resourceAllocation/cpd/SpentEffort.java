package br.ufes.inf.nemo.odercp.rcpapp.resourceAllocation.cpd;

import java.util.Date;

/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class SpentEffort {

	private HRAllocation hRAllocation;
	private int amountHours;
	private Date date;
	private String observation;

	public HRAllocation gethRAllocation() {
		return hRAllocation;
	}

	public void sethRAllocation(HRAllocation hRAllocation) {
		this.hRAllocation = hRAllocation;
	}

	public int getAmountHours() {
		return amountHours;
	}

	public void setAmountHours(int amountHours) {
		this.amountHours = amountHours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

}
