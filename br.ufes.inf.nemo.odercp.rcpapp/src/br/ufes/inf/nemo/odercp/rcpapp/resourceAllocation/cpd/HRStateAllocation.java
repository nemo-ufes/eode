package br.ufes.inf.nemo.odercp.rcpapp.resourceAllocation.cpd;

/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public enum HRStateAllocation {

	WaitingStartActivity("Waiting Start Activity"),
	WaitingStartParticipation("Waiting Start Participation"),
	Ongoing("Ongoing"), OngoingAdjustments("Ongoing Adjustments"),
	ReviewClosure("Review Closure"),
	Closed("Closed"),
	Canceled("Canceled");

	private String label;

	private HRStateAllocation(String label) {
		this.label = label;
	}

	public String toString() {
		return this.label;
	}
}
