package br.ufes.inf.nemo.eode.rcpapp.standardProcess.pdl;

import java.util.Set;

public class Combination {

	private String name;
	private StandardProcessLifeCycleModel lifeCycleModel;
	private Set<ActivityStandardProcess> ordersActivities;
	private int order;
	
	/** Constructor. */
	public Combination() {
		super();
	}
	/** Getter for name. */
	public String getName() {
		return name;
	}
	/** Setter for name. */
	public void setName(String name) {
		this.name = name;
	}
	/** Getter for lifeCycleModel. */
	public StandardProcessLifeCycleModel getLifeCycleModel() {
		return lifeCycleModel;
	}
	/** Setter for lifeCycleModel. */
	public void setLifeCycleModel(StandardProcessLifeCycleModel lifeCycleModel) {
		this.lifeCycleModel = lifeCycleModel;
	}
	/** Getter for ordersActivities. */
	public Set<ActivityStandardProcess> getOrdersActivities() {
		return ordersActivities;
	}
	/** Setter for ordersActivities. */
	public void setOrdersActivities(Set<ActivityStandardProcess> ordersActivities) {
		this.ordersActivities = ordersActivities;
	}
	/** Getter for order. */
	public int getOrder() {
		return order;
	}
	/** Setter for order. */
	public void setOrder(int order) {
		this.order = order;
	}

}
