package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt.ApplCRUDSpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageCreateStandardProcess;

public class WizardCreateStandardProcess extends Wizard {

	PageCreateStandardProcess pageCreateStandardProcess;

	public WizardCreateStandardProcess() {
		setWindowTitle("Wizard Standard Process");
		pageCreateStandardProcess = new PageCreateStandardProcess();
	}

	@Override
	public void addPages() {
		addPage(pageCreateStandardProcess);
	}

	@Override
	public boolean performFinish() {
		SpecificStandardProcess standardProcess = new SpecificStandardProcess();
		standardProcess.setName(pageCreateStandardProcess.getTxtName().getText());
		standardProcess.setDescription(pageCreateStandardProcess.getTxtDescription().getText());
		standardProcess.setIsDefine(false);
		return ApplCRUDSpecificStandardProcess.create(standardProcess);
	}

}
