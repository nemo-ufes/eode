package br.ufes.inf.nemo.eode.rcpapp.processControl.pdl;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.pdl.KResource;

public class Resource {

	String name;
	KResource kResource;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the kResource
	 */
	public KResource getkResource() {
		return kResource;
	}

	/**
	 * @param kResource
	 *            the kResource to set
	 */
	public void setkResource(KResource kResource) {
		this.kResource = kResource;
	}

}
