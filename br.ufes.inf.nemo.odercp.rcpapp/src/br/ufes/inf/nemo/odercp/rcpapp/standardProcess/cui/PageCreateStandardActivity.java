package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PageCreateStandardActivity extends WizardPage {
	
	private Text txtname;
	private Text txtdescription;

	/**
	 * Create the wizard.
	 */
	public PageCreateStandardActivity() {
		super("wizardPageActivity");
		setTitle("Wizard Page Create Activity");
		setDescription("Basic Data Standard Activity");
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

		Label lblName = new Label(container, SWT.NONE);
		lblName.setText("Name*:");

		txtname = new Text(container, SWT.BORDER);
		txtname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtname.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(txtname.getText().isEmpty() || txtdescription.getText()
						.isEmpty()))
					setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setText("Description*:");

		txtdescription = new Text(container, SWT.BORDER | SWT.MULTI);
		txtdescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		txtdescription.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(txtname.getText().isEmpty() || txtdescription.getText()
						.isEmpty()))
					setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		setPageComplete(false);
	}

	/**
	 * @return the txtname
	 */
	public Text getTxtname() {
		return txtname;
	}

	/**
	 * @param txtname the txtname to set
	 */
	public void setTxtname(Text txtname) {
		this.txtname = txtname;
	}

	/**
	 * @return the txtdescription
	 */
	public Text getTxtdescription() {
		return txtdescription;
	}

	/**
	 * @param txtdescription the txtdescription to set
	 */
	public void setTxtdescription(Text txtdescription) {
		this.txtdescription = txtdescription;
	}


}
