package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt.ApplCRUDSpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.SpecificStandardProcess;

/**
 * Choice Standard Process
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class PageChoiceStardardProcess extends WizardPage {

	Button radios[];
	SpecificStandardProcess specificStandardProcesses[];
	Map<String, SpecificStandardProcess> hashstandardProcesses;
	SpecificStandardProcess specificStandardProcess;
	PageDefineSubStandardProcess pageDefineSubStandardProcess;

	/**
	 * Create the wizard.
	 */
	public PageChoiceStardardProcess() {
		super("Page Standard Process");
		setTitle("Page Choice Standard Process");
		specificStandardProcesses = ApplCRUDSpecificStandardProcess.getever();
		hashstandardProcesses = new HashMap<String, SpecificStandardProcess>();
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(final Composite parent) {

		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));

		setPageComplete(false);

		if (specificStandardProcesses != null && specificStandardProcesses.length > 0) {
			int tam = 0, j = 0;
			for (int i = 0; i < specificStandardProcesses.length; i++) {
				if (!specificStandardProcesses[i].isDefine()) {
					tam++;
				}
			}

			radios = new Button[tam];
			for (int i = 0; i < specificStandardProcesses.length; i++) {
				if (!specificStandardProcesses[i].isDefine()) {
					radios[j] = new Button(container, SWT.RADIO);
					radios[j].setText(specificStandardProcesses[i].getName());
					hashstandardProcesses.put(specificStandardProcesses[i].getName(), specificStandardProcesses[i]);
					radios[j].setBounds(10, 45 + (30 * j), 350, 24);
					radios[j].addSelectionListener(new SelectionListener() {

						@Override
						public void widgetSelected(SelectionEvent e) {
							Button bu = (Button) e.item;
							specificStandardProcess = hashstandardProcesses.get(bu.getText());
							for (int i = 0; i < getWizard().getPages().length; i++) {
								if (getWizard().getPages()[i] instanceof PageDefineSubStandardProcess) {

									pageDefineSubStandardProcess = (PageDefineSubStandardProcess) getWizard().getPages()[i];
									pageDefineSubStandardProcess.setSpecificStandardProcess(specificStandardProcess);
								}
							}
							pageDefineSubStandardProcess.createControl(parent);
							pageDefineSubStandardProcess.getControl().pack();
						
						}

						@Override
						public void widgetDefaultSelected(SelectionEvent e) {

						}
					});
					j++;
				}
			}

			if (specificStandardProcesses.length > 0) {
				if (tam > 0) {
					radios[0].setSelection(true);
					specificStandardProcess = hashstandardProcesses.get(radios[0].getText());
					// pega a prox page
					for (int i = 0; i < getWizard().getPages().length; i++) {
						if (getWizard().getPages()[i] instanceof PageDefineSubStandardProcess) {

							pageDefineSubStandardProcess = (PageDefineSubStandardProcess) getWizard().getPages()[i];
							pageDefineSubStandardProcess.setSpecificStandardProcess(specificStandardProcess);
						}
					}
					setPageComplete(true);
				}
				else {
					MessageDialog.openConfirm(null, "Problem", "ever standard process is define.");
					parent.getShell().close();

				}
			}
			else {

				MessageDialog.openConfirm(null, "Problem", "wihtout Standard Process that not is define.");
				parent.getShell().close();

			}

		}
		else {
			MessageDialog.openConfirm(null, "Problem", "wihtout Standard Process back to menu to create.");
			parent.getShell().close();

		}
	}

	/** Getter for checks. */
	public Button[] getChecks() {
		return radios;
	}

	public SpecificStandardProcess getStandardProcess() {
		return specificStandardProcess;
	}

}
