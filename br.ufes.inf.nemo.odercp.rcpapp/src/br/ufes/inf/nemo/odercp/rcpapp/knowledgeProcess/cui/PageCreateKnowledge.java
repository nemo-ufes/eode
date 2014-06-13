package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class PageCreateKnowledge extends WizardPage {
	private Text name;
	private Text description;

	/**
	 * Create the wizard.
	 */
	public PageCreateKnowledge() {
		super("wizardPageKnowledge");
		setTitle("Wizard Page Create Knowledge");
		setDescription("Basic Data Knowledge");
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

		name = new Text(container, SWT.BORDER);
		name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		name.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(name.getText().isEmpty() || description.getText().isEmpty())) setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDescription.setText("Description*:");

		description = new Text(container, SWT.BORDER|SWT.MULTI);
		description.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		description.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(name.getText().isEmpty() || description.getText().isEmpty())) setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		setPageComplete(false);
	}

}
