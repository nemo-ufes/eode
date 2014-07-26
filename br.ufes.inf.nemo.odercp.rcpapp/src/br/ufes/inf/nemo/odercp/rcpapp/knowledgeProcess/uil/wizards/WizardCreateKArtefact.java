package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.wizards;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.mtl.ApplCRUDKArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKArtefactChoiceDepends;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKArtefactChoicesubArtefacts;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil.PageCreateKnowledge;

public class WizardCreateKArtefact extends Wizard {
	private PageCreateKnowledge pageCreateKnowledge;
	private PageCreateKArtefactChoicesubArtefacts pageCreateKArtefactChoicesubArtefacts;
	private PageCreateKArtefactChoiceDepends pageCreateKArtefactChoiceDepends;

	public WizardCreateKArtefact() {
		setWindowTitle("Wizard Create KArtefact");
		pageCreateKnowledge = new PageCreateKnowledge();
		pageCreateKArtefactChoicesubArtefacts = new PageCreateKArtefactChoicesubArtefacts();
		pageCreateKArtefactChoiceDepends = new PageCreateKArtefactChoiceDepends();
	}

	@Override
	public void addPages() {
		addPage(pageCreateKnowledge);
		addPage(pageCreateKArtefactChoicesubArtefacts);
		addPage(pageCreateKArtefactChoiceDepends);
	}

	@Override
	public boolean performFinish() {
		Set<KArtefact> depends = new HashSet<KArtefact>();
		Set<KArtefact> subArtefacts = new HashSet<KArtefact>();

		/** Depends */
		for (int i = 0; i < pageCreateKArtefactChoiceDepends.getChecks().length; i++) {
			if (pageCreateKArtefactChoiceDepends.getChecks()[i].getSelection() == true) {
				depends.add(pageCreateKArtefactChoiceDepends.getHashdepends().get(pageCreateKArtefactChoiceDepends.getChecks()[i].getText()));
			}
		}

		/** subKartefacts */
		for (int i = 0; i < pageCreateKArtefactChoicesubArtefacts.getChecks().length; i++) {
			if (pageCreateKArtefactChoicesubArtefacts.getChecks()[i].getSelection() == true) {
				subArtefacts.add(pageCreateKArtefactChoicesubArtefacts.getHashsubArtefacts().get(pageCreateKArtefactChoicesubArtefacts.getChecks()[i].getText()));
			}
		}

		return ApplCRUDKArtefact.createKArtefact(pageCreateKnowledge.getName(), pageCreateKnowledge.getDescription(), depends, subArtefacts);
	}

}
