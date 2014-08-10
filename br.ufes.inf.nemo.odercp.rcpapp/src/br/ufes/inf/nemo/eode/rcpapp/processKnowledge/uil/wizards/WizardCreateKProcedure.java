package br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.tml.ApplCRUDKProcedure;
import br.ufes.inf.nemo.eode.rcpapp.processKnowledge.uil.PageCreateKnowledge;

public class WizardCreateKProcedure extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;

	public WizardCreateKProcedure() {
		setWindowTitle("Wizard Create KProcess");
		pageCreateKnowledge = new PageCreateKnowledge();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
	}

	@Override
	public boolean performFinish() {

		return ApplCRUDKProcedure.createKProcedure(pageCreateKnowledge.getName(),
				pageCreateKnowledge.getDescription());
	}

}
