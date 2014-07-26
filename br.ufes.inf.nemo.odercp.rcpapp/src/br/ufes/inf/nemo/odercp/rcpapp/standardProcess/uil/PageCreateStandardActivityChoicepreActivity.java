package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.uil;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.mtl.ApplCRUDActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl.ActivityStandardProcess;

/**
 * Page
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateStandardActivityChoicepreActivity extends WizardPage {

	Button checks[];
	ActivityStandardProcess preActivities[];
	Map<String, ActivityStandardProcess> hashpreactivities;

	/**
	 * Create the wizard.
	 */
	public PageCreateStandardActivityChoicepreActivity() {
		super("Page Create Standard Activity");
		setTitle("Page Create  Standard Activity");
		setDescription("Choice preActivities");
		preActivities = ApplCRUDActivityStandardProcess.getever();
		hashpreactivities = new HashMap<String, ActivityStandardProcess>();
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
		if (preActivities.length > 0) checks = new Button[preActivities.length];
		for (i = 0; i < preActivities.length; i++) {
			checks[i] = new Button(container, SWT.CHECK);
			checks[i].setText(preActivities[i].getName());
			hashpreactivities.put(preActivities[i].getName(), preActivities[i]);
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

	public Map<String, ActivityStandardProcess> getHashpreactivities() {
		return hashpreactivities;
	}

}
