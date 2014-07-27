package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.uil;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKHumanResource;

/**
 * Page Create KActivity to choice kHRs
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateKActivityChoiceKHumanResource extends WizardPage {

	Button checks[];
	KHumanResource kHumanResources[];
	Map<String, KHumanResource> hashKhumanResources;

	/**
	 * Create the wizard.
	 */
	public PageCreateKActivityChoiceKHumanResource() {
		super("Page Create KActivity");
		setTitle("Page Create KActivity");
		setDescription("Choice Knowledge Human Resource");
		kHumanResources = ApplCRUDKHumanResource.getever();
		hashKhumanResources = new HashMap<String, KHumanResource>();
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
		if (kHumanResources.length > 0) checks = new Button[kHumanResources.length];
		for (i = 0; i < kHumanResources.length; i++) {
			checks[i] = new Button(container, SWT.CHECK);
			checks[i].setText(kHumanResources[i].getName());
			hashKhumanResources.put(kHumanResources[i].getName(), kHumanResources[i]);
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

			setPageComplete(false);

		}

	}

	/** Getter for checks. */
	public Button[] getChecks() {
		return checks;
	}

	/** Getter for hashKhumanResources. */
	public Map<String, KHumanResource> getHashKhumanResources() {
		return hashKhumanResources;
	}

}
