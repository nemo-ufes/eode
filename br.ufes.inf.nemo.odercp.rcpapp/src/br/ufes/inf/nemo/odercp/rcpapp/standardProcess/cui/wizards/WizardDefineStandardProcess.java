package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageCreateStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageDefineMacroActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageDefineSubStandardProcess;

public class WizardDefineStandardProcess extends Wizard {

	PageCreateStandardProcess pageCreateStandardProcess;
	PageDefineSubStandardProcess pageDefineSubStandardProcess;
	PageDefineMacroActivityStandardProcess pageDefineMacroActivityStandardProcess;

	public WizardDefineStandardProcess() {
		setWindowTitle("Wizard Define Process");

		pageCreateStandardProcess = new PageCreateStandardProcess();
		pageDefineSubStandardProcess = new PageDefineSubStandardProcess();
		pageDefineMacroActivityStandardProcess = new PageDefineMacroActivityStandardProcess();
	}

	@Override
	public void addPages() {
		addPage(pageCreateStandardProcess);
		addPage(pageDefineSubStandardProcess);
		addPage(pageDefineMacroActivityStandardProcess);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
