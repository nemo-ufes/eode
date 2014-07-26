package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.uil.wizards;

import java.util.ArrayList;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Button;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.mtl.ApplCRUDHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.mtl.ApplDefineTeam;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.pdl.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.uil.PageDefineTeam;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.mtl.ApplSelectProject;

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
		if (ApplSelectProject.getSelected() != null) {
			Button[] checks = pageDefineTeam.getChecks();
			for (int i = 0; i < checks.length; i++) {
				if (checks[i].getSelection()) selectedHR.add(HRs[i]);

			}
			HumanResource[] vectorselectedHR = (HumanResource[]) selectedHR.toArray();
			return ApplDefineTeam.DefineTeam(vectorselectedHR, ApplSelectProject.getSelected());
		}
		else {

		}
		return false;
	}

}
