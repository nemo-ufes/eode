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
import br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cmt.ApplAuthenticUser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;

public class PageAthenticateUser {

	protected Shell shlLoginOdercp;
	private Text user;
	private Text password;
	private boolean logger;
	private boolean stayconnected;

	/**
	 * @return the stayconnected
	 */
	public boolean isStayconnected() {
		return stayconnected;
	}

	/**
	 * @param stayconnected the stayconnected to set
	 */
	public void setStayconnected(boolean stayconnected) {
		this.stayconnected = stayconnected;
	}

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
			PageAthenticateUser window = new PageAthenticateUser();
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
		
		Button btnStayConnected = new Button(shlLoginOdercp, SWT.CHECK);
		btnStayConnected.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stayconnected=true;
			}
		});
		btnStayConnected.setBounds(190, 245, 151, 24);
		btnStayConnected.setText("Stay Connected");
		
		Label label = new Label(shlLoginOdercp, SWT.NONE);
		label.setImage(ResourceManager.getPluginImage("br.ufes.inf.nemo.odercp.rcpapp", "images/ode.jpg"));
		label.setBounds(167, 24, 137, 81);
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
		shlLoginOdercp.setSize(446, 359);
		shlLoginOdercp.setText("Login ODE-RCP");

		user = new Text(shlLoginOdercp, SWT.BORDER);
		user.setBounds(129, 142, 240, 27);

		Label lblUser = new Label(shlLoginOdercp, SWT.NONE);
		lblUser.setBounds(24, 152, 70, 17);
		lblUser.setText("User:");

		password = new Text(shlLoginOdercp, SWT.BORDER | SWT.PASSWORD);
		password.setBounds(129, 196, 240, 27);

		Label lblPassword = new Label(shlLoginOdercp, SWT.NONE);
		lblPassword.setBounds(24, 206, 70, 17);
		lblPassword.setText("Password:");
		
		stayconnected = false;

		Button btnLogin = new Button(shlLoginOdercp, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLogin.setBounds(135, 286, 91, 29);
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
					boolean verification = ApplAuthenticUser.verification(
							user.getText(), password.getText(),stayconnected);
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
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCancel.setBounds(278, 286, 91, 29);
		btnCancel.setText("Cancel");
		btnCancel.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				shlLoginOdercp.close();
				System.exit(0);

			}
		});

	}
}
