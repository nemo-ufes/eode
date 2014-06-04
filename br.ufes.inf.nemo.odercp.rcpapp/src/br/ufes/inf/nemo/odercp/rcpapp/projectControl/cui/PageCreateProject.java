package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

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
		container.setLayout(new GridLayout(2, false));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
				new Label(container, SWT.NONE);
		
				Label lblDescription = new Label(container, SWT.NONE);
				lblDescription.setText("Description:");
				
						textDescription = new Text(container, SWT.BORDER | SWT.MULTI);
						GridData gd_textDescription = new GridData(SWT.FILL, SWT.FILL, true, true,1 , 1);
						gd_textDescription.heightHint = 104;
						textDescription.setLayoutData(gd_textDescription);
	}

	public String getTextDescription() {
		return textDescription.getText();
	}
}
