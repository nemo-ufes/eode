package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKActivity;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KActivity;

/**
 * Page s
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateStandardActivityChoiceKActivity extends WizardPage {

	Button radios[];
	KActivity kActivity[];
	Map<String, KActivity> hashKActivity;
	 KActivity kactivity;

	/**
	 * Create the wizard.
	 */
	public PageCreateStandardActivityChoiceKActivity() {
		super("Page Create Activity");
		setTitle("Page Create Activity");
		setDescription("Choice KActivity");
		kActivity = ApplCRUDKActivity.getever();
		hashKActivity = new HashMap<String, KActivity>();
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
		if (kActivity.length > 0)
			radios = new Button[kActivity.length];
		for (i = 0; i < kActivity.length; i++) {
			radios[i] = new Button(container, SWT.RADIO);
			radios[i].setText(kActivity[i].getName());
			hashKActivity.put(kActivity[i].getName(), kActivity[i]);
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

	public Map<String, KActivity> getHashKActivity() {
		return hashKActivity;
	}

	/**
	 * @return the kactivity
	 */
	public KActivity getKactivity() {
		return kactivity;
	}

}
