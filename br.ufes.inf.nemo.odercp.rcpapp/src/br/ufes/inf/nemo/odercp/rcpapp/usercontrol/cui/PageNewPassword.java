/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class PageNewPassword extends WizardPage {

	/**
	 * Create the wizard.
	 */
	public PageNewPassword() {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
	}

}
