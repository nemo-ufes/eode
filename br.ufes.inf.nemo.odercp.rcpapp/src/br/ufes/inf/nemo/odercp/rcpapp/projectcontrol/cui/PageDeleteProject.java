package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cmt.ApplShowProjects;

public class PageDeleteProject extends WizardPage {
	protected String[] projects = ApplShowProjects.showProjects();
	protected Button[] radios;
	private String chosenProject;

	public String getChosenProject() {
		return chosenProject;
	}

	/**
	 * Create the wizard.
	 */
	public PageDeleteProject() {
		super("Page Delete Project");
		setTitle("Page delete Project ");
		setDescription(" Delete Project");
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
		if (projects.length > 0)
			radios = new Button[projects.length];
		for (i = 0; i < projects.length; i++) {
			radios[i] = new Button(this.getShell(), SWT.RADIO);
			radios[i].setText(projects[i]);
			radios[i].setBounds(10, 45 + (30 * i), 750, 30);
		}
		if (projects.length > 0) {
			radios[0].setSelection(true);
			chosenProject = radios[0].getText();
		}

	}

}
