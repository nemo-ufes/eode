package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.wizards;

import org.eclipse.jface.wizard.Wizard;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageChoiceStardardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageDefineMacroActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageDefineSubStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageStandardActivityProcess;

public class WizardDefineStandardProcess extends Wizard {

	PageChoiceStardardProcess pageChoiceStardardProcess;
	PageDefineSubStandardProcess pageDefineSubStandardProcess;
	PageDefineMacroActivityStandardProcess pageDefineMacroActivityStandardProcess;
	PageStandardActivityProcess pageStandardActivityProcess;

	public WizardDefineStandardProcess() {
		setWindowTitle("Wizard Define Process");

		pageChoiceStardardProcess = new PageChoiceStardardProcess();
		pageDefineSubStandardProcess = new PageDefineSubStandardProcess();
		pageDefineMacroActivityStandardProcess = new PageDefineMacroActivityStandardProcess();
		pageStandardActivityProcess = new PageStandardActivityProcess();
	}

	@Override
	public void addPages() {
		addPage(pageChoiceStardardProcess);
		addPage(pageDefineSubStandardProcess);
		addPage(pageDefineMacroActivityStandardProcess);
		addPage(pageStandardActivityProcess);
	}

	@Override
	public boolean performFinish() {
		
		return false;
	}
	

}
