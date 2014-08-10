package br.ufes.inf.nemo.eode.rcpapp.projectControl.uil;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.eode.rcpapp.projectControl.tml.ApplCRUDProject;

public class PageDeleteProject extends WizardPage {
	protected Button[] radios;

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
		String[] projects = ApplCRUDProject.getevernameProjectsWorkspace();

		setPageComplete(false);

		if (projects.length > 0) radios = new Button[projects.length];
		for (i = 0; i < projects.length; i++) {
			radios[i] = new Button(container, SWT.RADIO);
			radios[i].setText(projects[i]);
			radios[i].setBounds(10, 45 + (30 * i), 350, 30);
		}
		if (projects.length > 0) {
			radios[0].setSelection(true);
			setPageComplete(true);

		}

	}

	public Button[] getRadios() {
		return radios;
	}

}
