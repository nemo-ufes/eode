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

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.tml.ApplCRUDKArtefact;

/**
 * Page Create
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateArtefactChoiceKArtefact extends WizardPage {

	Button radios[];
	KArtefact kartefacts[];
	Map<String, KArtefact> hashKartefacts;

	/**
	 * Create the wizard.
	 */
	public PageCreateArtefactChoiceKArtefact() {
		super("Page Create Artefact");
		setTitle("Page Create Artefact");
		setDescription("Choice KArtefact");
		kartefacts = ApplCRUDKArtefact.getever();
		hashKartefacts = new HashMap<String, KArtefact>();
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
		if (kartefacts.length > 0) radios = new Button[kartefacts.length];
		for (i = 0; i < kartefacts.length; i++) {
			radios[i] = new Button(container, SWT.RADIO);
			radios[i].setText(kartefacts[i].getName());
			hashKartefacts.put(kartefacts[i].getName(), kartefacts[i]);
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

	/** Getter for radios. */
	public Button[] getRadios() {
		return radios;
	}

	/** Getter for hashKprocesses. */
	public Map<String, KArtefact> getHashKartefacts() {
		return hashKartefacts;
	}

}
