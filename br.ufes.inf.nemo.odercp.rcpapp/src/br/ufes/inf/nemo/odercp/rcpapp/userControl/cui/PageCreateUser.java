package br.ufes.inf.nemo.odercp.rcpapp.userControl.cui;

import java.util.HashMap;

import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cmt.ApplCRUDHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cpd.HumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.userControl.cpd.AcessProfile;

public class PageCreateUser extends WizardPage {
	private Text humanResource;
	private Text login;
	private Text password;
	private Combo combo;

	/**
	 * Create the wizard.
	 */
	public PageCreateUser() {
		super("wizardPage");
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

		HumanResource[] HRs = ApplCRUDHumanResource.getever();
		String[] namesHR = new String[HRs.length];
		for (int i = 0; i < HRs.length; i++) {
			namesHR[i] = HRs[i].getName();
			//humanResource.setData(namesHR[i], HRs[i]);
		}

		Label lblHumanResource = new Label(container, SWT.NONE);
		lblHumanResource.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblHumanResource.setText("Human Resource*:");

		humanResource = new Text(container, SWT.BORDER);
		humanResource.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new AutoCompleteField(humanResource, new TextContentAdapter(), namesHR);

		Label lblLogin = new Label(container, SWT.NONE);
		lblLogin.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblLogin.setText("Login*:");

		login = new Text(container, SWT.BORDER);
		login.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblPassword.setText("Password*:");

		password = new Text(container, SWT.BORDER);
		password.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblAcessProfile = new Label(container, SWT.NONE);
		lblAcessProfile.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		lblAcessProfile.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblAcessProfile.setText("Acess Profile*:");

		combo = new Combo(container, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo.add(AcessProfile.Administrator.getName());
		combo.add(AcessProfile.Developer.getName());
	
	}
}
