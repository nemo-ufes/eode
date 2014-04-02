package br.ufes.inf.nemo.odercp.rcpapp.Util;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class WUsersUtil {

	protected Shell shlLoginOdercp;
	private Text user;
	private Text password;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WUsersUtil window = new WUsersUtil();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		SwtUtil.centralize(shlLoginOdercp);
		shlLoginOdercp.open();
		shlLoginOdercp.layout();
		while (!shlLoginOdercp.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLoginOdercp = new Shell();
		shlLoginOdercp.setSize(450, 300);
		shlLoginOdercp.setText("Login ODE-RCP");

		user = new Text(shlLoginOdercp, SWT.BORDER);
		user.setBounds(139, 73, 240, 27);

		Label lblUser = new Label(shlLoginOdercp, SWT.NONE);
		lblUser.setBounds(34, 83, 70, 17);
		lblUser.setText("User:");

		password = new Text(shlLoginOdercp, SWT.BORDER | SWT.PASSWORD);
		password.setBounds(139, 127, 240, 27);

		Label lblPassword = new Label(shlLoginOdercp, SWT.NONE);
		lblPassword.setBounds(34, 137, 70, 17);
		lblPassword.setText("Password:");

		Button btnLogin = new Button(shlLoginOdercp, SWT.NONE);
		btnLogin.setBounds(139, 209, 91, 29);
		btnLogin.setText("Login");
		btnLogin.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				String selecteduser = user.getText();
				String selectedpass = password.getText();

				if (selectedpass.isEmpty() || selecteduser.isEmpty()) {
					MessageBox messageBox = new MessageBox(shlLoginOdercp,
							SWT.OK | SWT.ICON_WARNING);
					if (selectedpass.isEmpty() && selecteduser.isEmpty())
						messageBox.setMessage("Enter the User and password");
					else if (selectedpass.isEmpty())
						messageBox.setMessage("Enter the Password");
					else if (selecteduser.isEmpty())
						messageBox.setMessage("Enter the User");
					messageBox.open();
				} else {
					boolean verification = LoginODERCP.verification(
							user.getText(), password.getText());
					if(verification==true){
						MessageBox messageBox = new MessageBox(shlLoginOdercp,
								SWT.OK);
						messageBox.setText("ODE RCP");
						messageBox.setMessage("Welcome:" + user.getText());
						messageBox.open();
					}
						
					
					
				}
			}

		});

		Button btnCancel = new Button(shlLoginOdercp, SWT.NONE);
		btnCancel.setBounds(288, 209, 91, 29);
		btnCancel.setText("Cancel");

		Label lblOdercp = new Label(shlLoginOdercp, SWT.NONE);
		lblOdercp.setAlignment(SWT.CENTER);
		lblOdercp.setFont(SWTResourceManager.getFont("DejaVu Sans", 14,
				SWT.BOLD | SWT.ITALIC));
		lblOdercp.setBounds(212, 31, 97, 36);
		lblOdercp.setText("ODE-RCP");

	}
}
