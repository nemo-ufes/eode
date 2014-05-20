/**
 * 
 */
package br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cui;


import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

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

		Label lblUser = new Label(container, SWT.NONE);
		lblUser.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblUser.setBounds(39, 10, 70, 22);
		lblUser.setText("User:");

		Label lbNameUser = new Label(container, SWT.NONE);
		lbNameUser
				.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lbNameUser.setBounds(205, 15, 383, 17);

		Label lblOldPassword = new Label(container, SWT.NONE);
		lblOldPassword.setBounds(39, 64, 111, 17);
		lblOldPassword.setText("Old Password:");

		txtoldPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtoldPassword.setBounds(205, 54, 236, 27);
		txtoldPassword.setText("");

		Label lblNewPassword = new Label(container, SWT.NONE);
		lblNewPassword.setBounds(39, 123, 111, 17);
		lblNewPassword.setText("New Password:");

		Label lblRepeatNewPassword = new Label(container, SWT.NONE);
		lblRepeatNewPassword.setBounds(39, 179, 157, 17);
		lblRepeatNewPassword.setText("Repeat New Password:");

		txtnewPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtnewPassword.setBounds(205, 113, 236, 27);
		txtnewPassword.setText("");


		txtrepeatNewPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtrepeatNewPassword.setBounds(205, 169, 236, 27);
		txtrepeatNewPassword.setText("");
		
		
	}
}
