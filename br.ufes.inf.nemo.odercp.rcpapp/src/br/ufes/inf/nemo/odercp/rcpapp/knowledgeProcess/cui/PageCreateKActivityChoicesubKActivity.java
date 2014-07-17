package br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KActivity;

/**
 * Page Create KActivity to choice ksubActivities
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateKActivityChoicesubKActivity extends WizardPage {

	Button checks[];
	KActivity subkActivities[];
	Map<String, KActivity> hashsubActivities;

	/**
	 * Create the wizard.
	 */
	public PageCreateKActivityChoicesubKActivity() {
		super("Page Create KActivity");
		setTitle("Page Create KActivity");
		setDescription("Choice subKActivities");
		subkActivities = ApplCRUDKActivity.getever();
		hashsubActivities = new HashMap<String, KActivity>();
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
		if (subkActivities.length > 0) checks = new Button[subkActivities.length];
		for (i = 0; i < subkActivities.length; i++) {
			checks[i] = new Button(container, SWT.CHECK);
			checks[i].setText(subkActivities[i].getName());
			hashsubActivities.put(subkActivities[i].getName(), subkActivities[i]);
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

	/** Getter for hashsubActivities. */
	public Map<String, KActivity> getHashsubActivities() {
		return hashsubActivities;
	}

}
