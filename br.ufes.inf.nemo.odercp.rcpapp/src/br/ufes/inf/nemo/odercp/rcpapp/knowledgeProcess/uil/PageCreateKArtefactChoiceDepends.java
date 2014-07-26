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

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.mtl.ApplCRUDKArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KArtefact;

/**
 * Page Create KArtefact to choice kArtefacts dependes 
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateKArtefactChoiceDepends extends WizardPage {

	Button checks[];
	KArtefact kArtefacts[];
	Map<String, KArtefact> hashdepends;

	/**
	 * Create the wizard.
	 */
	public PageCreateKArtefactChoiceDepends() {
		super("Page Create KArtefact");
		setTitle("Page Create KArtefact");
		setDescription("Choice KArtefacts Dependes");
		kArtefacts = ApplCRUDKArtefact.getever();
		hashdepends = new HashMap<String, KArtefact>();
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
		if (kArtefacts.length > 0) checks = new Button[kArtefacts.length];
		for (i = 0; i < kArtefacts.length; i++) {
			checks[i] = new Button(container, SWT.CHECK);
			checks[i].setText(kArtefacts[i].getName());
			hashdepends.put(kArtefacts[i].getName(), kArtefacts[i]);
			checks[i].setBounds(10, 45 + (30 * i), 350, 24);
			checks[i].addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					setPageComplete(true);

				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {

				}

			});

			setPageComplete(false);

		}
	}

	/** Getter for checks. */
	public Button[] getChecks() {
		return checks;
	}

	/** Getter for hashdepends. */
	public Map<String, KArtefact> getHashdepends() {
		return hashdepends;
	}

}
