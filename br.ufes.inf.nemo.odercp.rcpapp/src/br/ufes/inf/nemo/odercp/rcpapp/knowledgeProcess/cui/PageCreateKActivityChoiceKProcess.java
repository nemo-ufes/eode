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

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cmt.ApplCRUDKProcess;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.cpd.KProcess;

/**
 * Page Create KActivity to choice kProcess
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageCreateKActivityChoiceKProcess extends WizardPage {

	Button radios[];
	KProcess kProcesses[];
	Map<String, KProcess> hashKprocesses;

	/**
	 * Create the wizard.
	 */
	public PageCreateKActivityChoiceKProcess() {
		super("Page Create KActivity");
		setTitle("Page Create KActivity");
		setDescription("Choice KProcess");
		kProcesses = ApplCRUDKProcess.getever();
		hashKprocesses = new HashMap<String, KProcess>();
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
		if (kProcesses.length > 0) radios = new Button[kProcesses.length];
		for (i = 0; i < kProcesses.length; i++) {
			radios[i] = new Button(container, SWT.RADIO);
			radios[i].setText(kProcesses[i].getName());
			hashKprocesses.put(kProcesses[i].getName(), kProcesses[i]);
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
	public Map<String, KProcess> getHashKprocesses() {
		return hashKprocesses;
	}

}
