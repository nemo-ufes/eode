package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui.PageCreateKnowledge;

public class WizardCreateKLifeCycleModel extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;

	public WizardCreateKLifeCycleModel() {
		setWindowTitle("Wizard Create KLife-Cycle Model");
		pageCreateKnowledge = new PageCreateKnowledge();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
