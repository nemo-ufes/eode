package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui.wizards;

import java.util.ArrayList;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Button;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt.ApplCRUDHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui.PageDefineTeam;

public class WizardDefineTeam extends Wizard {
	PageDefineTeam pageDefineTeam;
	protected ArrayList<HumanResource> selectedHR = new ArrayList<HumanResource>();
	protected HumanResource[] HRs = ApplCRUDHumanResource.getever();

	public WizardDefineTeam() {
		setWindowTitle("Wizard Define Team");
		pageDefineTeam = new PageDefineTeam();
	}

	@Override
	public void addPages() {
		addPage(pageDefineTeam);
	}

	@Override
	public boolean performFinish() {
		Button[] checks = pageDefineTeam.getChecks();
		for (int i = 0; i < checks.length; i++) {
			if (checks[i].getSelection()) selectedHR.add(HRs[i]);

		}
		HumanResource[] vectorselectedHR = (HumanResource[]) selectedHR.toArray();
		return false;
	}

}
