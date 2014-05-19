package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class PageCreateProject extends WizardPage {
	private Text textDescription;

	/**
	 * Create the wizard.
	 */
	public PageCreateProject() {
		super("Page Create Project");
		setTitle("Page description Project ");
		setDescription(" Description of Project");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);

		textDescription = new Text(container, SWT.BORDER | SWT.MULTI);
		textDescription.setBounds(171, 10, 383, 217);

		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setBounds(10, 10, 95, 24);
		lblDescription.setText("Description:");
	}

	public String getTextDescription() {
		return textDescription.getText();
	}
}
