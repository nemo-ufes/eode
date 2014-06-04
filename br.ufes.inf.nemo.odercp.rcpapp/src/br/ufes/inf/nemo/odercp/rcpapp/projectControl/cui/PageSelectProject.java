package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt.ApplCRUDProject;
import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cpd.Project;

public class PageSelectProject extends WizardPage {
	protected HashMap<String, Project> hashprojects;
	protected Button[] radios;

	/**
	 * Create the wizard.
	 */
	public PageSelectProject() {
		super("Page Select Project");
		setTitle("Page Select Project ");
		setDescription(" Select Project");
		hashprojects = ApplCRUDProject.geteverProjectsWorkspace();
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
		if (projects.length > 0) radios = new Button[projects.length];
		for (i = 0; i < projects.length; i++) {
			radios[i] = new Button(container, SWT.RADIO);
			radios[i].setText(projects[i]);
			radios[i].setBounds(10, 45 + (30 * i), 350, 30);
		}
		if (projects.length > 0) {
			radios[0].setSelection(true);
		}

	}

	public Button[] getRadios() {
		return radios;
	}
}
