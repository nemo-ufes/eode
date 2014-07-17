package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Tree;

public class PageStandardActivityProcess extends WizardPage {

	private Text textDescription;
	private Text txtName;
	private Button btnCheckButtonmandatory;

	/**
	 * Create the wizard.
	 */
	public PageStandardActivityProcess() {
		super("wizardPage");
		setTitle("Page Standard Activity Process");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Tree tree = new Tree(container, SWT.BORDER);
		GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 9);
		gd_tree.widthHint = 297;
		tree.setLayoutData(gd_tree);
		
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblName = new Label(container, SWT.NONE);
		lblName.setText("Name:");

		txtName = new Text(container, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setText("Description:");

		textDescription = new Text(container, SWT.BORDER | SWT.MULTI);
		GridData gd_textDescription = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_textDescription.heightHint = 104;
		textDescription.setLayoutData(gd_textDescription);

		Label lblMandatory = new Label(container, SWT.NONE);
		lblMandatory.setText("Mandatory:");

		btnCheckButtonmandatory = new Button(container, SWT.CHECK);

		Button btnUpdate = new Button(container, SWT.NONE);
		btnUpdate.setText("Update...");

		Button btnDelete = new Button(container, SWT.NONE);
		btnDelete.setText("Delete...");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
	}

	public String getTextDescription() {
		return textDescription.getText();
	}
}
