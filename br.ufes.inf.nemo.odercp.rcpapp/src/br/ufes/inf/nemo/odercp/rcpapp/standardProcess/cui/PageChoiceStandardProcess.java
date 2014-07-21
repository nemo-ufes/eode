package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cmt.ApplCRUDGeneralStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd.GeneralStandardProcess;

public class PageChoiceStandardProcess {
	Button radios[];
	GeneralStandardProcess generalStandardProcesses[];
	Map<String, GeneralStandardProcess> hashgeneralprocesses;
	static Shell shell;
	GeneralStandardProcess generalStandardProcess;
	PageStandardProcessDefine pageProcessDefine;

	/**
	 * Launch the application.
	 * 
	 * @param generalStandardProcess
	 * 
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void main(PageStandardProcessDefine pageProcess) {
		this.pageProcessDefine = pageProcess;
		Display display = Display.getDefault();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell.setSize(588, 450);
		shell.setText("Choice Standard Process");

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

		scrolledComposite.setBounds(0, 0, 584, 370);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Button btnChoice = new Button(shell, SWT.NONE);
		btnChoice.setBounds(210, 376, 75, 25);
		btnChoice.setText("Choice");
		btnChoice.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				pageProcessDefine.generalStandardProcess = generalStandardProcess;
				shell.close();
			}

		});

		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(291, 376, 75, 25);
		btnCancel.setText("Cancel");
		btnCancel.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				pageProcessDefine.generalStandardProcess = null;
				shell.close();
			}

		});

		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setBounds(0, 0, 584, 366);
		scrolledComposite.setContent(composite);

		hashgeneralprocesses = new HashMap<String, GeneralStandardProcess>();
		generalStandardProcesses = ApplCRUDGeneralStandardProcess.getever();

		int i, size = 0, j = 0;
		if (generalStandardProcesses != null) {

			for (i = 0; i < generalStandardProcesses.length; i++) {
				if (!generalStandardProcesses[i].isDefine()) {
					size++;
				}
			}
			if (size > 0) {
				radios = new Button[size];

				for (i = 0; i < generalStandardProcesses.length; i++) {
					if (!generalStandardProcesses[i].isDefine()) {
						radios[j] = new Button(composite, SWT.RADIO);
						radios[j]
								.setText(generalStandardProcesses[i].getName());
						hashgeneralprocesses.put(
								generalStandardProcesses[i].getName(),
								generalStandardProcesses[i]);
						radios[j].setBounds(10, 45 + (30 * j), 350, 24);
						radios[j].addSelectionListener(new SelectionListener() {

							@Override
							public void widgetSelected(SelectionEvent e) {
								Button radio = (Button) e.item;
								pageProcessDefine.generalStandardProcess = generalStandardProcess = hashgeneralprocesses
										.get(radio.getText());

							}

							@Override
							public void widgetDefaultSelected(SelectionEvent e) {

							}

						});
						j++;
					}
				}

				radios[0].setSelection(true);
				pageProcessDefine.generalStandardProcess = generalStandardProcess = hashgeneralprocesses
						.get(radios[0].getText());

				shell.open();
				shell.layout();
				while (!shell.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
			} else {
				MessageDialog.openConfirm(null, "Confirmation",
						"Don't have Standard Process no define.");
			}
		} else {
			MessageDialog.openConfirm(null, "Confirmation",
					"Don't have Standard Process no define.");
		}

	}
}
