package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KArtefact;

/**
 * Page Create KActivity to choice kArtefact products
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateKActivityChoiceKArtefactproducts extends WizardPage {

	Button checks[];
	KArtefact kArtefacts[];

	/**
	 * Create the wizard.
	 */
	public PageCreateKActivityChoiceKArtefactproducts() {
		super("Page Create KActivity");
		setTitle("Page Create KActivity");
		setDescription("Choice KArtefacts products");
		kArtefacts = ApplCRUDKArtefact.getever();
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

}
