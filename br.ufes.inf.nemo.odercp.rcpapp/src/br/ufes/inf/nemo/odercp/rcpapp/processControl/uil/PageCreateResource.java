package br.ufes.inf.nemo.odercp.rcpapp.processControl.uil;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PageCreateResource extends WizardPage {
	private Text txtname;

	/**
	 * Create the wizard.
	 */
	public PageCreateResource() {
		super("wizardPage");
		setTitle("Wizard Page Create Resource");
		setDescription("Basic Data Resource");
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
		txtname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		txtname.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(txtname.getText().isEmpty()))
					setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

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
}
