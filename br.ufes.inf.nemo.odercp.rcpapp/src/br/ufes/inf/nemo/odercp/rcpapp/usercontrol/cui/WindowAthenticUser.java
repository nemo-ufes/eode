package br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cui;

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
import br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cmt.AplAuthenticUser;

public class WindowAthenticUser {

	protected Shell shlLoginOdercp;
	private Text user;
	private Text password;
	private boolean logger;

	public boolean isLogger() {
		return logger;
	}

	public void setLogger(boolean logger) {
		this.logger = logger;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowAthenticUser window = new WindowAthenticUser();
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
		createContents(display);
		SwtUtil.centralize(shlLoginOdercp);
		shlLoginOdercp.open();
		shlLoginOdercp.layout();
		// WHen closed the window exit system
		shlLoginOdercp.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
				if (!isLogger())
					System.exit(0);
			}
		});
		while (!shlLoginOdercp.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(Display display) {
		shlLoginOdercp = new Shell(display, SWT.CLOSE);
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
					boolean verification = AplAuthenticUser.verification1(
							user.getText(), password.getText());
					if (verification == true) {
						setLogger(true);
						shlLoginOdercp.close();
					} else {
						MessageBox messageBox = new MessageBox(shlLoginOdercp,
								SWT.OK);
						messageBox.setText("ODE RCP");
						messageBox.setMessage("Username or password wrong!");
						messageBox.open();
					}

				}
			}

		});

		Button btnCancel = new Button(shlLoginOdercp, SWT.NONE);
		btnCancel.setBounds(288, 209, 91, 29);
		btnCancel.setText("Cancel");
		btnCancel.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				shlLoginOdercp.close();
				System.exit(0);

			}
		});

		Label lblOdercp = new Label(shlLoginOdercp, SWT.NONE);
		lblOdercp.setAlignment(SWT.CENTER);
		lblOdercp.setFont(SWTResourceManager.getFont("DejaVu Sans", 14,
				SWT.BOLD | SWT.ITALIC));
		lblOdercp.setBounds(212, 31, 97, 36);
		lblOdercp.setText("ODE-RCP");

	}

}
