/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.userControl.uil;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

import br.ufes.inf.nemo.odercp.rcpapp.userControl.mtl.ApplAuthenticUser;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class PageNewPassword extends WizardPage {

	private Text txtoldPassword;
	private Text txtnewPassword;
	private Text txtrepeatNewPassword;

	/**
	 * Create the wizard.
	 */
	public PageNewPassword() {
		super("wizardPageNewPassword");
		setTitle("New Password");
		setDescription("");
	}

	/** Getter for txtoldPassword. */
	public Text getTxtoldPassword() {
		return txtoldPassword;
	}

	/** Setter for txtoldPassword. */
	public void setTxtoldPassword(Text txtoldPassword) {
		this.txtoldPassword = txtoldPassword;
	}

	/** Getter for txtnewPassword. */
	public Text getTxtnewPassword() {
		return txtnewPassword;
	}

	/** Setter for txtnewPassword. */
	public void setTxtnewPassword(Text txtnewPassword) {
		this.txtnewPassword = txtnewPassword;
	}

	/** Getter for txtrepeatNewPassword. */
	public Text getTxtrepeatNewPassword() {
		return txtrepeatNewPassword;
	}

	/** Setter for txtrepeatNewPassword. */
	public void setTxtrepeatNewPassword(Text txtrepeatNewPassword) {
		this.txtrepeatNewPassword = txtrepeatNewPassword;
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

		Label lblUser = new Label(container, SWT.NONE);
		lblUser.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblUser.setText("User:");

		Label lbNameUser = new Label(container, SWT.NONE);
		lbNameUser.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lbNameUser.setText(ApplAuthenticUser.getCorrentUser().getHumanResource().getName());

		Label lblOldPassword = new Label(container, SWT.NONE);
		lblOldPassword.setText("Old Password:");

		txtoldPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtoldPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		txtoldPassword.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (!(txtoldPassword.getText().isEmpty() || txtnewPassword.getText().isEmpty() || txtrepeatNewPassword.getText().isEmpty())) setPageComplete(true);

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Label lblNewPassword = new Label(container, SWT.NONE);
		lblNewPassword.setText("New Password:");

		txtnewPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtnewPassword.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		txtnewPassword.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (!(txtoldPassword.getText().isEmpty() || txtnewPassword.getText().isEmpty() || txtrepeatNewPassword.getText().isEmpty())) setPageComplete(true);

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Label lblRepeatNewPassword = new Label(container, SWT.NONE);
		lblRepeatNewPassword.setText("Repeat New Password:");

		txtrepeatNewPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtrepeatNewPassword.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		txtrepeatNewPassword.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (!(txtoldPassword.getText().isEmpty() || txtnewPassword.getText().isEmpty() || txtrepeatNewPassword.getText().isEmpty())) setPageComplete(true);

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		setPageComplete(false);
	}
}
