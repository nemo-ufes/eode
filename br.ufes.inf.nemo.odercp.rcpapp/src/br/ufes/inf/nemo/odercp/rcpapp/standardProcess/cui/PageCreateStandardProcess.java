package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

public class PageCreateStandardProcess extends WizardPage {

	private Text txtname;
	private Text txtDescription;
	private Label lblDescription;
	private Text txtName;

	/**
	 * Create the wizard.
	 */
	public PageCreateStandardProcess() {
		super("wizardPage");
		setTitle("Page Create Standard Process");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(2, false));
		new Label(container.getShell(), SWT.NONE);
		new Label(container.getShell(), SWT.NONE);
		new Label(container.getShell(), SWT.NONE);
		new Label(container.getShell(), SWT.NONE);
		new Label(container.getShell(), SWT.NONE);

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblName = new Label(container, SWT.NONE);
		lblName.setText("Name:");
		
		txtName = new Text(container, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		
		txtDescription = new Text(container, SWT.BORDER);
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));
		
		Label lblDescription_1 = new Label(container, SWT.NONE);
		lblDescription_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDescription_1.setText("Description:");
		new Label(container, SWT.NONE);
		
	}
}
