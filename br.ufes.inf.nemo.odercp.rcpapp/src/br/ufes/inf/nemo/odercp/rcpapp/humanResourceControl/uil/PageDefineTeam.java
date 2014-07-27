package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.uil;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.pdl.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.tml.ApplCRUDHumanResource;

public class PageDefineTeam extends WizardPage {
	protected HumanResource[] HRs = ApplCRUDHumanResource.getever();
	protected Button[] checks;

	public Button[] getChecks() {
		return checks;
	}

	/**
	 * Create the wizard.
	 */
	public PageDefineTeam() {
		super("wizardPage Define Team");
		setTitle("Page Define Team");
		setDescription("Define Team at project selected");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);

		int i;
		if (HRs.length > 0) checks = new Button[HRs.length];
		for (i = 0; i < HRs.length; i++) {
			checks[i] = new Button(container, SWT.CHECK);
			checks[i].setText(HRs[i].getName());
			checks[i].setSelection(true);
			checks[i].setBounds(10, 45 + (30 * i), 350, 24);

		}
	}
}
