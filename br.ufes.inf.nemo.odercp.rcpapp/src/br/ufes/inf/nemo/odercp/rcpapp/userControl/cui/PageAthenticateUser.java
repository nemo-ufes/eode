package br.ufes.inf.nemo.odercp.rcpapp.userControl.cui;

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

import br.ufes.inf.nemo.odercp.rcpapp.userControl.cmt.ApplAuthenticUser;
import br.ufes.inf.nemo.odercp.rcpapp.util.SwtUtil;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class PageAthenticateUser {

	protected Shell shlLoginOdercp;
	private Text user;
	private Text password;
	// variable used when user looger because when page is closed ODE run
	private boolean logger;
	Button btnStayConnected;

	/**
	 * @return the stayconnected
	 */
	public boolean isStayconnected() {
		return btnStayConnected.getSelection();
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
	public static void start() {
		try {
			PageAthenticateUser window = new PageAthenticateUser();
			window.open();
		}
		catch (Exception e) {
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

		while (!shlLoginOdercp.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents(Display display) {
		shlLoginOdercp = new Shell(display, SWT.CLOSE);
		shlLoginOdercp.setSize(446, 359);
		shlLoginOdercp.setText("Login ODE-RCP");
		shlLoginOdercp.setLayout(new GridLayout(3, false));

		Label label = new Label(shlLoginOdercp, SWT.NONE);
		GridData gd_label = new GridData(SWT.CENTER, SWT.CENTER, true, true, 3, 1);
		gd_label.heightHint = 90;
		gd_label.widthHint = 126;
		label.setLayoutData(gd_label);
		label.setImage(ResourceManager.getPluginImage("br.ufes.inf.nemo.odercp.rcpapp", "images/ode.jpg"));

		Label lblUser = new Label(shlLoginOdercp, SWT.NONE);
		lblUser.setText("User:");

		user = new Text(shlLoginOdercp, SWT.BORDER);
		user.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

		new Label(shlLoginOdercp, SWT.NONE);
		new Label(shlLoginOdercp, SWT.NONE);
		new Label(shlLoginOdercp, SWT.NONE);

		Label lblPassword = new Label(shlLoginOdercp, SWT.NONE);
		lblPassword.setText("Password:");

		password = new Text(shlLoginOdercp, SWT.BORDER | SWT.PASSWORD);
		password.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		new Label(shlLoginOdercp, SWT.NONE);
		new Label(shlLoginOdercp, SWT.NONE);
		new Label(shlLoginOdercp, SWT.NONE);

		new Label(shlLoginOdercp, SWT.NONE);
		btnStayConnected = new Button(shlLoginOdercp, SWT.CHECK);
		btnStayConnected.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		btnStayConnected.setSelection(true);
		btnStayConnected.setText("Stay Connected");
		new Label(shlLoginOdercp, SWT.NONE);

		Button btnLogin = new Button(shlLoginOdercp, SWT.NONE);
		GridData gd_btnLogin = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnLogin.widthHint = 125;
		btnLogin.setLayoutData(gd_btnLogin);
		btnLogin.setText("Login");
		btnLogin.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				String selecteduser = user.getText();
				String selectedpass = password.getText();

				if (selectedpass.isEmpty() || selecteduser.isEmpty()) {
					MessageBox messageBox = new MessageBox(shlLoginOdercp, SWT.OK | SWT.ICON_WARNING);
					if (selectedpass.isEmpty() && selecteduser.isEmpty()) messageBox.setMessage("Enter the User and password");
					else if (selectedpass.isEmpty()) messageBox.setMessage("Enter the Password");
					else if (selecteduser.isEmpty()) messageBox.setMessage("Enter the User");
					messageBox.open();
				}
				else {
					boolean verification = ApplAuthenticUser.verification(user.getText(), password.getText(), btnStayConnected.getSelection());
					if (verification == true) {
						setLogger(true);
						shlLoginOdercp.close();
					}
					else {
						MessageBox messageBox = new MessageBox(shlLoginOdercp, SWT.OK);
						messageBox.setText("ODE RCP");
						messageBox.setMessage("Username or password wrong!");
						messageBox.open();
					}

				}
			}

		});

		Button btnCancel = new Button(shlLoginOdercp, SWT.NONE);
		GridData gd_btnCancel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnCancel.widthHint = 125;
		btnCancel.setLayoutData(gd_btnCancel);
		btnCancel.setText("Cancel");
		btnCancel.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				shlLoginOdercp.close();
				System.exit(0);

			}
		});
		shlLoginOdercp.open();
		shlLoginOdercp.layout();
		// WHen closed the window exit system
		shlLoginOdercp.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
				if (!isLogger()) System.exit(0);
			}
		});

	}
}
