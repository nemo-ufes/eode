package br.ufes.inf.nemo.odercp.rcpapp.processControl.uil;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KSoftwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKHardwareResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKSoftwareResource;

/**
 * Page Create
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateResourceChoiceKResources extends WizardPage {

	Button radios[];
	KHardwareResource kHardwareResources[];
	KSoftwareResource kSoftwareResources[];
	Map<String, KResource> hashkResources;

	/**
	 * Create the wizard.
	 */
	public PageCreateResourceChoiceKResources() {
		super("Page Create Resource");
		setTitle("Page Create Resource");
		setDescription("Choice KResource");
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
		if (kHardwareResources.length > 0 || kSoftwareResources.length > 0)
			radios = new Button[kHardwareResources.length
					+ kSoftwareResources.length];
		for (i = 0; i < kHardwareResources.length; i++) {
			radios[i] = new Button(container, SWT.RADIO);
			radios[i].setText(kHardwareResources[i].getName());
			hashkResources.put(kHardwareResources[i].getName(),
					kHardwareResources[i]);
			radios[i].setBounds(10, 45 + (30 * i), 350, 24);
			radios[i].addSelectionListener(new SelectionListener() {

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
			radios[i] = new Button(container, SWT.RADIO);
			radios[i].setText(kSoftwareResources[i - kHardwareResources.length]
					.getName());
			hashkResources
					.put(kSoftwareResources[i - kHardwareResources.length]
							.getName(), kSoftwareResources[i
							- kHardwareResources.length]);
			radios[i].setBounds(10, 45 + (30 * i), 350, 24);
			radios[i].addSelectionListener(new SelectionListener() {

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

	public Button[] getRadios() {
		return radios;
	}

	/** Getter for hashkResources. */
	public Map<String, KResource> getHashkResources() {
		return hashkResources;
	}

}
