package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKSoftwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KSoftwareResource;

/**
 * Page Create KActivity to choice Kresources
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateKActivityChoiceKResources extends WizardPage {

	Button checks[];
	KHardwareResource kHardwareResources[];
	KSoftwareResource kSoftwareResources[];
	Map<String, KResource> hashkResources;

	/**
	 * Create the wizard.
	 */
	public PageCreateKActivityChoiceKResources() {
		super("Page Create KActivity");
		setTitle("Page Create KActivity");
		setDescription("Choice Kprocedures");
		kHardwareResources = ApplCRUDKHardwareResource.getever();
		kSoftwareResources = ApplCRUDKSoftwareResource.getever();
		hashkResources = new HashMap<String, KResource>();
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		int i;
		if (kHardwareResources.length > 0 || kSoftwareResources.length > 0) checks = new Button[kHardwareResources.length + kSoftwareResources.length];
		for (i = 0; i < kHardwareResources.length; i++) {
			checks[i] = new Button(container, SWT.CHECK);
			checks[i].setText(kHardwareResources[i].getName());
			hashkResources.put(kHardwareResources[i].getName(), kHardwareResources[i]);
			checks[i].setBounds(10, 45 + (30 * i), 350, 24);
			checks[i].addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					setPageComplete(true);

				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub

				}

			});

		}
		for (; i < kHardwareResources.length + kSoftwareResources.length; i++) {
			checks[i] = new Button(container, SWT.CHECK);
			checks[i].setText(kSoftwareResources[i - kHardwareResources.length].getName());
			hashkResources.put(kSoftwareResources[i - kHardwareResources.length].getName(), kSoftwareResources[i - kHardwareResources.length]);
			checks[i].setBounds(10, 45 + (30 * i), 350, 24);
			checks[i].addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					setPageComplete(true);

				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub

				}

			});

		}

		setPageComplete(false);

	}

	/** Getter for checks. */
	public Button[] getChecks() {
		return checks;
	}

	/** Getter for hashkResources. */
	public Map<String, KResource> getHashkResources() {
		return hashkResources;
	}

}
