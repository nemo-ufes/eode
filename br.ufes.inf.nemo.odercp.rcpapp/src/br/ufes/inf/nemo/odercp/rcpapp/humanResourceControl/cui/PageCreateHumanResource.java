package br.ufes.inf.nemo.odercp.rcpapp.humanResourceControl.cui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHumanResource;

public class PageCreateHumanResource extends WizardPage {
	private Text name;
	private Text workLoad;
	private Text email;
	private Text phone;
	private Combo comboRole;
	private Button CheckActive;
	Map<String, KHumanResource> hashKHR;

	/**
	 * Create the wizard.
	 */
	public PageCreateHumanResource() {
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
		container.setLayout(new GridLayout(2, false));

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblName = new Label(container, SWT.NONE);
		lblName.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblName.setText("Name*:");

		name = new Text(container, SWT.BORDER);
		name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblCheckActive = new Label(container, SWT.NONE);
		lblCheckActive.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblCheckActive.setText("Active*:");

		CheckActive = new Button(container, SWT.CHECK);
		CheckActive.setSelection(true);

		Label lblWorkload = new Label(container, SWT.NONE);
		lblWorkload.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblWorkload.setText("WorkLoad*:");

		workLoad = new Text(container, SWT.BORDER);
		workLoad.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		workLoad.addListener(SWT.Verify, new Listener() {

			@Override
			public void handleEvent(Event e) {
				String string = e.text;
				char[] chars = new char[string.length()];
				string.getChars(0, chars.length, chars, 0);
				for (int i = 0; i < chars.length; i++) {
					if (!('0' <= chars[i] && chars[i] <= '9')) {
						e.doit = false;
						return;
					}
				}
			}

		});

		Label lblEmail = new Label(container, SWT.NONE);
		lblEmail.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblEmail.setText("Email*:");

		email = new Text(container, SWT.BORDER);
		email.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblPhone = new Label(container, SWT.NONE);
		lblPhone.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblPhone.setText("Phone*:");

		phone = new Text(container, SWT.BORDER);
		phone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblRole = new Label(container, SWT.NONE);
		lblRole.setFont(SWTResourceManager.getFont("Ubuntu", 11, SWT.NORMAL));
		lblRole.setText("Role*:");

		comboRole = new Combo(container, SWT.READ_ONLY);
		comboRole.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		KHumanResource[] everKHR = ApplCRUDKHumanResource.getever();
		hashKHR = new HashMap<String, KHumanResource>();
		for (int i = 0; i < everKHR.length; i++) {
			comboRole.add(everKHR[i].getName());
			comboRole.setData(everKHR[i].getName(), everKHR[i]);
			hashKHR.put(everKHR[i].getName(), everKHR[i]);
		}

		phone.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(name.getText().isEmpty() || workLoad.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty())) setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		name.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(name.getText().isEmpty() || workLoad.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty())) setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		workLoad.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(name.getText().isEmpty() || workLoad.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty())) setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		email.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!(name.getText().isEmpty() || workLoad.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty())) setPageComplete(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		comboRole.select(0);
		setPageComplete(false);
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

	public Button getCheckActive() {
		return CheckActive;
	}

	public KHumanResource getKHR() {
		return hashKHR.get(getComboRole());
	}
}
