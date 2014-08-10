package br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.tml.ApplCRUDKProcess;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.PageCreateKnowledge;

public class WizardCreateKProcess extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;

	public WizardCreateKProcess() {
		setWindowTitle("Wizard Create KProcedure");
		pageCreateKnowledge = new PageCreateKnowledge();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
	}

	@Override
	public boolean performFinish() {

		return ApplCRUDKProcess.createKProcess(pageCreateKnowledge.getName(), pageCreateKnowledge.getDescription(), pageCreateKnowledge.getBtnIsEng().getSelection());
	}

}
