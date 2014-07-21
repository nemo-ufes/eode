package br.ufes.inf.nemo.odercp.rcpapp.processControl.cui.wizard;

import org.eclipse.jface.wizard.Wizard;


import br.ufes.inf.nemo.odercp.rcpapp.processControl.cmt.ApplCRUDArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cpd.Artefact;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cui.PageCreateArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.processControl.cui.PageCreateArtefactChoiceKArtefact;

public class WizardCreateArtefact extends Wizard {

	PageCreateArtefact pageCreateArtefact;
	PageCreateArtefactChoiceKArtefact pageCreateArtefactChoiceKArtefact;

	public WizardCreateArtefact() {
		setWindowTitle(" Wizard Create Artefact");
		pageCreateArtefact = new PageCreateArtefact();
		pageCreateArtefactChoiceKArtefact = new PageCreateArtefactChoiceKArtefact();
	}

	@Override
	public void addPages() {
		addPage(pageCreateArtefact);
		addPage(pageCreateArtefactChoiceKArtefact);
	}

	@Override
	public boolean performFinish() {
		Artefact artefact = new Artefact();
		artefact.setName(pageCreateArtefact.getTxtname().getText());

		for (int i = 0; i < pageCreateArtefactChoiceKArtefact.getRadios().length; i++) {
			if (pageCreateArtefactChoiceKArtefact.getRadios()[i].getSelection()) {

				artefact.setkArtefact(pageCreateArtefactChoiceKArtefact
						.getHashKartefacts()
						.get(pageCreateArtefactChoiceKArtefact.getRadios()[i]
								.getText()));

				continue;
			}
		}
		return ApplCRUDArtefact.Create(artefact);
	}
}
