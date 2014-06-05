package br.ufes.inf.nemo.odercp.rcpapp.userControl.cui;

import java.util.HashMap;

import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt.ApplCRUDHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.userControl.cpd.AcessProfile;

public class PageCreateUser extends WizardPage {
	private Text humanResource;
	private Text login;
	private Text password;
	private Combo combo;
	private HashMap<String, HumanResource> hashHR;
	private HumanResource[] HRs;
	private HashMap<String, AcessProfile> hashacessProfile;

	/**
	 * Create the wizard.
	 */
	public PageCreateUser() {
		super("wizardPageCreateUser");
		setTitle("Wizard Page Create User");
		setDescription("Basic Data ");
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
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblHumanResource = new Label(container, SWT.NONE);
		lblHumanResource.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblHumanResource.setText("Human Resource*:");

		humanResource = new Text(container, SWT.BORDER);
		humanResource.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		HRs = ApplCRUDHumanResource.getever();
		String[] namesHR = new String[HRs.length];
		hashHR = new HashMap<String, HumanResource>();
		for (int i = 0; i < HRs.length; i++) {
			namesHR[i] = HRs[i].getName();
			humanResource.setData(namesHR[i], HRs[i]);
			hashHR.put(namesHR[i], HRs[i]);
		}
		new AutoCompleteField(humanResource, new TextContentAdapter(), namesHR);

		humanResource.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(login.getText().isEmpty() || password.getText().isEmpty() || humanResource.getText().isEmpty())) setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Label lblLogin = new Label(container, SWT.NONE);
		lblLogin.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblLogin.setText("Login*:");

		login = new Text(container, SWT.BORDER);
		login.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		login.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(login.getText().isEmpty() || password.getText().isEmpty() || humanResource.getText().isEmpty())) setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblPassword.setText("Password*:");

		password = new Text(container, SWT.BORDER | SWT.PASSWORD);
		password.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		password.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(login.getText().isEmpty() || password.getText().isEmpty() || humanResource.getText().isEmpty())) setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Label lblAcessProfile = new Label(container, SWT.NONE);
		lblAcessProfile.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblAcessProfile.setText("Acess Profile*:");

		combo = new Combo(container, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo.add(AcessProfile.Administrator.getName());
		combo.add(AcessProfile.Developer.getName());
		combo.select(0);
		hashacessProfile = new HashMap<String, AcessProfile>();
		hashacessProfile.put(AcessProfile.Administrator.getName(), AcessProfile.Administrator);
		hashacessProfile.put(AcessProfile.Developer.getName(), AcessProfile.Developer);
		setPageComplete(false);
	}

	public HumanResource getHumanResource() {
		return (HumanResource) humanResource.getData(humanResource.getText());
	}

	public String getLogin() {
		return login.getText();
	}

	public String getPassword() {
		return password.getText();
	}

	public AcessProfile getAcessProfile() {
		return hashacessProfile.get(combo.getText());
	}
}
