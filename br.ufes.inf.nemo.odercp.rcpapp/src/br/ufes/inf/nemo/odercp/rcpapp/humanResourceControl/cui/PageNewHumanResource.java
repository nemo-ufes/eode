package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

public class PageNewHumanResource extends WizardPage {
	private Text name;
	private Text workLoad;
	private Text email;
	private Text phone;
	private Combo comboRole;

	/**
	 * Create the wizard.
	 */
	public PageNewHumanResource() {
		super("wizardPageNewHumanResource");
		setTitle("Wizard Page New Human Resource");
		setDescription(" Basic Data  ");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);

		Label lblName = new Label(container, SWT.NONE);
		lblName.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblName.setBounds(10, 30, 70, 17);
		lblName.setText("Name*:");

		name = new Text(container, SWT.BORDER);
		name.setBounds(146, 20, 370, 27);

		Button CheckActive = new Button(container, SWT.CHECK);
		CheckActive.setSelection(true);
		CheckActive.setBounds(146, 63, 115, 24);

		Label lblCheckActive = new Label(container, SWT.NONE);
		lblCheckActive.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblCheckActive.setBounds(10, 70, 70, 17);
		lblCheckActive.setText("Active*:");

		Label lblWorkload = new Label(container, SWT.NONE);
		lblWorkload.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblWorkload.setBounds(10, 110, 94, 17);
		lblWorkload.setText("WorkLoad*:");

		workLoad = new Text(container, SWT.BORDER);
		workLoad.setBounds(146, 100, 75, 27);

		Label lblEmail = new Label(container, SWT.NONE);
		lblEmail.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblEmail.setBounds(10, 150, 101, 17);
		lblEmail.setText("Email*:");

		email = new Text(container, SWT.BORDER);
		email.setBounds(146, 140, 370, 27);

		Label lblPhone = new Label(container, SWT.NONE);
		lblPhone.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblPhone.setBounds(10, 190, 70, 17);
		lblPhone.setText("Phone*:");

		Label lblRole = new Label(container, SWT.NONE);
		lblRole.setFont(SWTResourceManager.getFont("Ubuntu", 12, SWT.NORMAL));
		lblRole.setBounds(10, 230, 70, 17);
		lblRole.setText("Role*:");

		phone = new Text(container, SWT.BORDER);
		phone.setBounds(146, 180, 370, 27);

		comboRole = new Combo(container, SWT.NONE);
		comboRole.setBounds(146, 218, 239, 29);
		KHumanResource[] everKHR = ApplCRUDKHumanResource.getever();
		Set<KHumanResource> hashKHR = new HashSet<KHumanResource>();
		for (int i = 0; i < everKHR.length; i++) {
			comboRole.add(everKHR[i].getName());
			hashKHR.add(everKHR[i]);
		}
		comboRole.getText();
	}

	/** Getter for name. */
	public String getName() {
		return name.getText();
	}

	/** Setter for name. */
	public void setName(String name) {
		this.name.setText(name);
	}

	/** Getter for workLoad. */
	public Integer getWorkLoad() {
		return Integer.parseInt(workLoad.getText());
	}

	/** Setter for workLoad. */
	public void setWorkLoad(int workLoad) {
		this.workLoad.setText(String.valueOf(workLoad));
	}

	/** Getter for email. */
	public String getEmail() {
		return email.getText();
	}

	/** Setter for email. */
	public void setEmail(String email) {
		this.email.setText(email);
	}

	/** Getter for phone. */
	public String getPhone() {
		return phone.getText();
	}

	/** Setter for phone. */
	public void setPhone(String phone) {
		this.phone.setText(phone);
	}

	/** Getter for comboRole. */
	public String getComboRole() {
		return comboRole.getText();
	}

}
