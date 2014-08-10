package br.ufes.inf.nemo.eode.rcpapp.standardProcess.uil;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.ufes.inf.nemo.eode.rcpapp.standardProcess.pdl.GeneralStandardProcess;
import br.ufes.inf.nemo.eode.rcpapp.standardProcess.tml.ApplCRUDGeneralStandardProcess;

public class PageCreateStandardProcess {
	private Text txtName;
	private Text txtDescription;
	Button btnCreate;
	static Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void main() {
		Display display = Display.getDefault();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN );
		shell.setSize(450, 227);
		shell.setText("Create Standard Process");
		shell.setLayout(new GridLayout(2, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		Label lblName = new Label(shell, SWT.NONE);
		lblName.setText("Name:");

		txtName = new Text(shell, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		txtName.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				btnCreate.setEnabled(true);
			}

		});

		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		txtDescription = new Text(shell, SWT.BORDER);
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 3));

		Label lblDescription = new Label(shell, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblDescription.setText("Description:");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		btnCreate = new Button(shell, SWT.NONE);
		btnCreate.setText("Create");
		btnCreate.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				GeneralStandardProcess standardProcess = new GeneralStandardProcess();
				standardProcess.setName(txtName.getText());
				standardProcess.setDescription(txtDescription.getText());
				ApplCRUDGeneralStandardProcess.create(standardProcess);
				shell.close();
			}

		});
		btnCreate.setEnabled(false);

		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				shell.close();
			}

		});

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
