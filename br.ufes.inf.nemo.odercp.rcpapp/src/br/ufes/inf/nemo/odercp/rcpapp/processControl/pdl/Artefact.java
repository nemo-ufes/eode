package br.ufes.inf.nemo.odercp.rcpapp.processControl.pdl;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KArtefact;

public class Artefact {

	private String name;
	private KArtefact kArtefact;

	public Artefact() {
		super();
	}

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
	 * @return the kArtefact
	 */
	public KArtefact getkArtefact() {
		return kArtefact;
	}

	/**
	 * @param kArtefact the kArtefact to set
	 */
	public void setkArtefact(KArtefact kArtefact) {
		this.kArtefact = kArtefact;
	}

}
