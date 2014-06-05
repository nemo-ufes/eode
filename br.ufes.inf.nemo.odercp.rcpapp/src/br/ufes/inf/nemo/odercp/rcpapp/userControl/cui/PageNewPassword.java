/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.userControl.cui;


import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

/**
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 */
public class PageNewPassword extends WizardPage {
	public Text getTxtoldPassword() {
		return txtoldPassword;
	}

	public void setTxtoldPassword(Text txtoldPassword) {
		this.txtoldPassword = txtoldPassword;
	}

	public Text getTxtnewPassword() {
		return txtnewPassword;
	}

	public void setTxtnewPassword(Text txtnewPassword) {
		this.txtnewPassword = txtnewPassword;
	}

	public Text getTxtrepeatNewPassword() {
		return txtrepeatNewPassword;
	}

	public void setTxtrepeatNewPassword(Text txtrepeatNewPassword) {
		this.txtrepeatNewPassword = txtrepeatNewPassword;
	}

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
		lbNameUser
				.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));

		Label lblOldPassword = new Label(container, SWT.NONE);
		lblOldPassword.setText("Old Password:");

		txtoldPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtoldPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		txtoldPassword.setText("");

		Label lblNewPassword = new Label(container, SWT.NONE);
		lblNewPassword.setText("New Password:");

		txtnewPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtnewPassword.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		txtnewPassword.setText("");
		
				Label lblRepeatNewPassword = new Label(container, SWT.NONE);
				lblRepeatNewPassword.setText("Repeat New Password:");


		txtrepeatNewPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtrepeatNewPassword.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		txtrepeatNewPassword.setText("");
		
		
	}
}
