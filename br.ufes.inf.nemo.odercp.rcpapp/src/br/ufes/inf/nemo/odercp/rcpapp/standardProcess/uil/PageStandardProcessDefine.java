package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.uil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KArtefact;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KHumanResource;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KProcedure;
import br.ufes.inf.nemo.odercp.rcpapp.knowledgeProcess.pdl.KResource;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.mtl.ApplCRUDActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.mtl.ApplCRUDSpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl.ActivityStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl.GeneralStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl.SpecificStandardProcess;
import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.pdl.StandardProcess;

public class PageStandardProcessDefine {
	Shell shell;
	GeneralStandardProcess generalStandardProcess;
	SpecificStandardProcess specificStandardProcessselected;
	Tree tree;
	TreeItem root;
	Composite composite;
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	Button btnDefineStandardProcess;
	LinkedList<SpecificStandardProcess> subkprocesses;
	HashMap<String, SpecificStandardProcess> hashKprocess;
	List listavaliablesprocess;
	List listselectionsprocess;
	SpecificStandardProcess processEngineering;
	Combo combo;
	CTabFolder tabFolder;
	PageStandardProcessDefine pageProcessDefine;
	List listAvaliablesMA;
	List listSelectionsMA;
	HashMap<String, ActivityStandardProcess> hashActivies;
	HashMap<TreeItem, SpecificStandardProcess> hashStandardProcesses;
	ActivityStandardProcess activitiesStandardProcess[];
	private Text txtName;
	private Text txtDescription;
	private Button btnMandatory;
	private ActivityStandardProcess activityStandardProcessSelected;
	private boolean firsttime;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void main() {
		pageProcessDefine = this;
		Display display = Display.getDefault();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell.setSize(800, 680);
		shell.setText(" Standard Process Define");

		Menu menuBar = new Menu(shell, SWT.BAR);

		MenuItem cascadeStandardMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeStandardMenu.setText("&Standard Process");

		Menu standardMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeStandardMenu.setMenu(standardMenu);

		MenuItem createItem = new MenuItem(standardMenu, SWT.PUSH);
		createItem.setText("&Create Standard Process");
		createItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PageCreateStandardProcess pageCreateStandardProcess = new PageCreateStandardProcess();
				pageCreateStandardProcess.main();
			}
		});

		MenuItem choiceItem = new MenuItem(standardMenu, SWT.PUSH);
		choiceItem.setText("&Choice Standard Process");
		choiceItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				PageChoiceStandardProcess pageChoiceStandardProcess = new PageChoiceStandardProcess();
				pageChoiceStandardProcess.main(pageProcessDefine);

			}
		});

		MenuItem defineItem = new MenuItem(standardMenu, SWT.PUSH);
		defineItem.setText("&Define Standard Process");
		defineItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tree.removeAll();
				tree.setVisible(false);
				createtree();

			}
		});

		shell.setMenuBar(menuBar);

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

		scrolledComposite.setBounds(0, 0, 794, 591);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setBounds(0, 0, 794, 591);
		composite.setLayout(new GridLayout(4, false));
		scrolledComposite.setContent(composite);

		tree = new Tree(composite, SWT.BORDER);
		GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_tree.widthHint = 219;
		tree.setLayoutData(gd_tree);
		// tree.setVisible(false);
		new Label(composite, SWT.NONE);
		// Aqui
		tabFolder = new CTabFolder(composite, SWT.BORDER);
		GridData gd_tabFolder = new GridData(SWT.LEFT, SWT.FILL, false, true,
				2, 1);
		gd_tabFolder.widthHint = 488;
		tabFolder.setLayoutData(gd_tabFolder);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		CTabItem tabItemSubProcess = new CTabItem(tabFolder, SWT.NONE);
		tabItemSubProcess.setText("Sub Process");

		Form frmSubProcess = formToolkit.createForm(tabFolder);
		tabItemSubProcess.setControl(frmSubProcess);
		formToolkit.paintBordersFor(frmSubProcess);
		frmSubProcess.setText("Sub Process");
		frmSubProcess.getBody().setLayout(new GridLayout(4, false));

		// Form Sub Process
		subkprocesses = new LinkedList<SpecificStandardProcess>();
		hashKprocess = new HashMap<String, SpecificStandardProcess>();
		for (int i = 0; i < ApplCRUDSpecificStandardProcess.getever().length; i++) {
			subkprocesses.add(ApplCRUDSpecificStandardProcess.getever()[i]);
			hashKprocess.put(
					ApplCRUDSpecificStandardProcess.getever()[i].getName(),
					ApplCRUDSpecificStandardProcess.getever()[i]);
		}
		Composite frmSubProcessbody = frmSubProcess.getBody();
		new Label(frmSubProcess.getBody(), SWT.NONE);
		new Label(frmSubProcess.getBody(), SWT.NONE);
		new Label(frmSubProcess.getBody(), SWT.NONE);
		new Label(frmSubProcess.getBody(), SWT.NONE);

		Label lblProcessOfEnginnering = new Label(frmSubProcessbody, SWT.NONE);
		lblProcessOfEnginnering.setFont(SWTResourceManager.getFont("Segoe UI",
				13, SWT.NORMAL));
		formToolkit.adapt(lblProcessOfEnginnering, true, true);
		lblProcessOfEnginnering.setText("Process of Enginnering:");
		new Label(frmSubProcess.getBody(), SWT.NONE);

		combo = new Combo(frmSubProcessbody, SWT.READ_ONLY);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false, 2,
				1);
		gd_combo.widthHint = 219;
		combo.setLayoutData(gd_combo);
		for (int i = 0; i < subkprocesses.size(); i++) {
			if (subkprocesses.get(i).getkProcess().isEngineering()) {
				combo.add(subkprocesses.get(i).getName());
				combo.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						generalStandardProcess.getSpecialization().remove(
								processEngineering);
						processEngineering = hashKprocess.get(combo
								.getItem(combo.getSelectionIndex()));
						generalStandardProcess.getSpecialization().add(
								processEngineering);
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {

					}
				});
			}
		}

		if (subkprocesses.size() > 0) {
			combo.select(0);
			processEngineering = hashKprocess.get(combo.getItem(0));

		}

		Label lblOthersProcess = new Label(frmSubProcessbody, SWT.NONE);
		lblOthersProcess.setFont(SWTResourceManager.getFont("Segoe UI", 13,
				SWT.NORMAL));
		lblOthersProcess.setText("Others Process:");
		formToolkit.adapt(lblOthersProcess, true, true);

		new Label(frmSubProcess.getBody(), SWT.NONE);
		new Label(frmSubProcess.getBody(), SWT.NONE);

		new Label(frmSubProcessbody, SWT.NONE);
		new Label(frmSubProcess.getBody(), SWT.NONE);
		new Label(frmSubProcess.getBody(), SWT.NONE);
		new Label(frmSubProcess.getBody(), SWT.NONE);
		new Label(frmSubProcessbody, SWT.NONE);

		Label lblAvaliable = new Label(frmSubProcessbody, SWT.NONE);
		lblAvaliable.setFont(SWTResourceManager.getFont("Segoe UI", 12,
				SWT.NORMAL));
		lblAvaliable.setText("Avaliable:");
		formToolkit.adapt(lblAvaliable, true, true);
		new Label(frmSubProcess.getBody(), SWT.NONE);

		Label lblSelections = new Label(frmSubProcessbody, SWT.NONE);
		lblSelections.setFont(SWTResourceManager.getFont("Segoe UI", 12,
				SWT.NORMAL));
		lblSelections.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1));
		lblSelections.setText("Selected:");
		formToolkit.adapt(lblSelections, true, true);
		new Label(frmSubProcess.getBody(), SWT.NONE);

		listavaliablesprocess = new List(frmSubProcessbody, SWT.BORDER);
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4);
		listavaliablesprocess.setLayoutData(gd_list);
		gd_list.widthHint = 230;
		for (int i = 0; i < subkprocesses.size(); i++) {
			if (!subkprocesses.get(i).getkProcess().isEngineering())
				listavaliablesprocess.add(subkprocesses.get(i).getName());
		}

		Button select_one = new Button(frmSubProcessbody, SWT.NONE);
		GridData gd_button = new GridData(SWT.FILL, SWT.FILL, false, false, 1,
				1);
		gd_button.widthHint = 25;
		select_one.setLayoutData(gd_button);
		select_one.setText(">");
		select_one.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listavaliablesprocess.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listselectionsprocess.add(selections[i]);
					generalStandardProcess.getSpecialization().add(
							hashKprocess.get(selections[i]));
					listavaliablesprocess.remove(selections[i]);
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listavaliablesprocess.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listselectionsprocess.add(selections[i]);
					generalStandardProcess.getSpecialization().add(
							hashKprocess.get(selections[i]));
					listavaliablesprocess.remove(selections[i]);

				}

			}

		});

		listselectionsprocess = new List(frmSubProcessbody, SWT.BORDER);
		GridData gd_list_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 4);
		listselectionsprocess.setLayoutData(gd_list_1);
		gd_list_1.widthHint = 226;

		Button select_all = new Button(frmSubProcessbody, SWT.NONE);
		select_all.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		select_all.setText(">>");
		select_all.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listavaliablesprocess.getItems();

				for (int i = 0; i < selections.length; i++) {
					listselectionsprocess.add(selections[i]);
					generalStandardProcess.getSpecialization().add(
							hashKprocess.get(selections[i]));

				}
				listavaliablesprocess.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listavaliablesprocess.getItems();

				for (int i = 0; i < selections.length; i++) {
					listselectionsprocess.add(selections[i]);
					generalStandardProcess.getSpecialization().add(
							hashKprocess.get(selections[i]));

				}
				listavaliablesprocess.removeAll();

			}

		});

		Button deselect_one = new Button(frmSubProcessbody, SWT.NONE);
		deselect_one.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		deselect_one.setText("<");
		deselect_one.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listselectionsprocess.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listavaliablesprocess.add(selections[i]);
					generalStandardProcess.getSpecialization().remove(
							hashKprocess.get(selections[i]));
					listselectionsprocess.remove(selections[i]);

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listselectionsprocess.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listavaliablesprocess.add(selections[i]);
					generalStandardProcess.getSpecialization().remove(
							hashKprocess.get(selections[i]));
					listselectionsprocess.remove(selections[i]);

				}

			}

		});

		Button deselect_all = new Button(frmSubProcessbody, SWT.NONE);
		deselect_all.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false,
				false, 1, 1));
		deselect_all.setText("<<");

		deselect_all.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listselectionsprocess.getItems();

				for (int i = 0; i < selections.length; i++) {
					listavaliablesprocess.add(selections[i]);
					generalStandardProcess.getSpecialization().remove(
							hashKprocess.get(selections[i]));

				}
				listselectionsprocess.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listselectionsprocess.getItems();

				for (int i = 0; i < selections.length; i++) {
					listavaliablesprocess.add(selections[i]);
					generalStandardProcess.getSpecialization().remove(
							hashKprocess.get(selections[i]));

				}
				listselectionsprocess.removeAll();

			}

		});
		new Label(frmSubProcess.getBody(), SWT.NONE);
		new Label(frmSubProcess.getBody(), SWT.NONE);
		new Label(frmSubProcess.getBody(), SWT.NONE);

		Button btnDefineSP = new Button(frmSubProcess.getBody(), SWT.NONE);
		btnDefineSP.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		formToolkit.adapt(btnDefineSP, true, true);
		btnDefineSP.setText("Define");
		btnDefineSP.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				generalStandardProcess.getSpecialization().add(
						processEngineering);
				createtree();
			}

		});

		// MAcroAc

		CTabItem tabItemMacroActivity = new CTabItem(tabFolder, SWT.NONE);
		tabItemMacroActivity.setText("Macro Activity");

		Form frmMacroActivity = formToolkit.createForm(tabFolder);
		tabItemMacroActivity.setControl(frmMacroActivity);
		formToolkit.paintBordersFor(frmMacroActivity);
		frmMacroActivity.setText("Macro Activity");

		Composite compositeMacroActivity = frmMacroActivity.getBody();
		frmMacroActivity.getBody().setLayout(new GridLayout(3, false));

		Label label = new Label(frmMacroActivity.getBody(), SWT.NONE);
		formToolkit.adapt(label, true, true);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);

		Label lblAvaliableMA = new Label(compositeMacroActivity, SWT.NONE);
		lblAvaliableMA.setFont(SWTResourceManager.getFont("Segoe UI", 12,
				SWT.NORMAL));
		lblAvaliableMA.setText("Avaliable:");
		formToolkit.adapt(lblAvaliableMA, true, true);
		new Label(frmMacroActivity.getBody(), SWT.NONE);

		Label lblSelectionsMA = new Label(compositeMacroActivity, SWT.NONE);
		lblSelectionsMA.setFont(SWTResourceManager.getFont("Segoe UI", 12,
				SWT.NORMAL));
		lblSelectionsMA.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1));
		lblSelectionsMA.setText("Selected:");
		formToolkit.adapt(lblSelectionsMA, true, true);

		listAvaliablesMA = new List(compositeMacroActivity, SWT.BORDER);
		GridData gd_listMA = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 15);
		listAvaliablesMA.setLayoutData(gd_listMA);
		gd_listMA.widthHint = 230;

		Button select_oneMA = new Button(compositeMacroActivity, SWT.NONE);
		GridData gd_buttonMA = new GridData(SWT.FILL, SWT.FILL, false, false,
				1, 1);
		gd_buttonMA.widthHint = 25;
		select_oneMA.setLayoutData(gd_buttonMA);
		select_oneMA.setText(">");
		select_oneMA.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listAvaliablesMA.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsMA.add(selections[i]);
					specificStandardProcessselected
							.getActivityStandardProcesses().add(
									hashActivies.get(selections[i]));
					listAvaliablesMA.remove(selections[i]);
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listAvaliablesMA.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsMA.add(selections[i]);
					specificStandardProcessselected
							.getActivityStandardProcesses().add(
									hashActivies.get(selections[i]));
					listAvaliablesMA.remove(selections[i]);

				}

			}

		});
		activitiesStandardProcess = ApplCRUDActivityStandardProcess.getever();
		hashActivies = new HashMap<String, ActivityStandardProcess>();
		for (int i = 0; i < activitiesStandardProcess.length; i++) {
			listAvaliablesMA.add(activitiesStandardProcess[i].getName());
			hashActivies.put(activitiesStandardProcess[i].getName(),
					activitiesStandardProcess[i]);
		}

		listSelectionsMA = new List(compositeMacroActivity, SWT.BORDER);
		GridData gd_listspMA = new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				15);
		listSelectionsMA.setLayoutData(gd_listspMA);
		gd_listspMA.widthHint = 226;

		Button select_allMA = new Button(compositeMacroActivity, SWT.NONE);
		select_allMA.setText(">>");
		select_allMA.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listAvaliablesMA.getItems();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsMA.add(selections[i]);
					specificStandardProcessselected
							.getActivityStandardProcesses().add(
									hashActivies.get(selections[i]));

				}
				listAvaliablesMA.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listAvaliablesMA.getItems();

				for (int i = 0; i < selections.length; i++) {
					listSelectionsMA.add(selections[i]);
					specificStandardProcessselected
							.getActivityStandardProcesses().add(
									hashActivies.get(selections[i]));

				}
				listAvaliablesMA.removeAll();

			}

		});

		Button deselect_oneMA = new Button(compositeMacroActivity, SWT.NONE);
		deselect_oneMA.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		deselect_oneMA.setText("<");
		deselect_oneMA.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listSelectionsMA.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesMA.add(selections[i]);
					specificStandardProcessselected
							.getActivityStandardProcesses().remove(
									hashActivies.get(selections[i]));
					listSelectionsMA.remove(selections[i]);

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listSelectionsMA.getSelection();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesMA.add(selections[i]);
					specificStandardProcessselected
							.getActivityStandardProcesses().remove(
									hashActivies.get(selections[i]));
					listSelectionsMA.remove(selections[i]);

				}

			}

		});

		Button deselect_allMA = new Button(compositeMacroActivity, SWT.NONE);
		deselect_allMA.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1));
		deselect_allMA.setText("<<");

		deselect_allMA.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selections = listSelectionsMA.getItems();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesMA.add(selections[i]);
					specificStandardProcessselected
							.getActivityStandardProcesses().remove(
									hashActivies.get(selections[i]));
				}
				listSelectionsMA.removeAll();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selections = listSelectionsMA.getItems();

				for (int i = 0; i < selections.length; i++) {
					listAvaliablesMA.add(selections[i]);
					specificStandardProcessselected
							.getActivityStandardProcesses().remove(
									hashActivies.get(selections[i]));

				}
				listSelectionsMA.removeAll();

			}

		});
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);
		new Label(frmMacroActivity.getBody(), SWT.NONE);

		Button btnDefineMA = new Button(compositeMacroActivity, SWT.NONE);
		btnDefineMA.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		formToolkit.adapt(btnDefineMA, true, true);
		btnDefineMA.setText("Define");
		btnDefineMA.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (listSelectionsMA.getItemCount() > 0) {
					generalStandardProcess.setIsDefine(true);
				}
				createtree();
			}

		});
		// Activity Standard
		CTabItem tabItemActivityProcess = new CTabItem(tabFolder, SWT.NONE);
		tabItemActivityProcess.setText("Activity Standard Process");

		Form frmActivityStandardProcess = formToolkit.createForm(tabFolder);
		tabItemActivityProcess.setControl(frmActivityStandardProcess);
		formToolkit.paintBordersFor(frmActivityStandardProcess);
		frmActivityStandardProcess.setText("Activity Standard Process");
		frmActivityStandardProcess.getBody()
				.setLayout(new GridLayout(2, false));
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);

		Label lblName = new Label(frmActivityStandardProcess.getBody(),
				SWT.NONE);
		lblName.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		formToolkit.adapt(lblName, true, true);
		lblName.setText("Name:");

		txtName = new Text(frmActivityStandardProcess.getBody(), SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		formToolkit.adapt(txtName, true, true);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);

		txtDescription = new Text(frmActivityStandardProcess.getBody(),
				SWT.BORDER);
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 10));
		formToolkit.adapt(txtDescription, true, true);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);

		Label lblDescription = new Label(frmActivityStandardProcess.getBody(),
				SWT.NONE);
		lblDescription.setFont(SWTResourceManager.getFont("Segoe UI", 13,
				SWT.NORMAL));
		formToolkit.adapt(lblDescription, true, true);
		lblDescription.setText("Description:");
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);

		btnMandatory = new Button(frmActivityStandardProcess.getBody(),
				SWT.CHECK);
		btnMandatory.setFont(SWTResourceManager.getFont("Segoe UI", 12,
				SWT.NORMAL));
		formToolkit.adapt(btnMandatory, true, true);
		btnMandatory.setText("Mandatory");
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);
		new Label(frmActivityStandardProcess.getBody(), SWT.NONE);

		Button btnDefineAcP = new Button(frmActivityStandardProcess.getBody(),
				SWT.NONE);
		btnDefineAcP.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		formToolkit.adapt(btnDefineAcP, true, true);
		btnDefineAcP.setText("Define");
		btnDefineAcP.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				activityStandardProcessSelected.setName(txtName.getText());
				activityStandardProcessSelected.setDescription(txtDescription
						.getText());
				activityStandardProcessSelected.setMandatory(btnMandatory
						.getSelection());

			}

		});

		specificStandardProcessselected = processEngineering;

		tree.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TreeItem ti = (TreeItem) e.item;
				if (!ti.equals(root)) {
					specificStandardProcessselected = hashStandardProcesses
							.get(ti);
					populateMacro(hashStandardProcesses.get(ti));
					populateActivity(hashActivies.get(ti.getText()));
				}
			}

			private void populateActivity(
					ActivityStandardProcess activityStandardProcess) {
				if (activityStandardProcess != null) {
					activityStandardProcessSelected = activityStandardProcess;
					txtName.setText(activityStandardProcess.getName());
					txtDescription.setText(activityStandardProcess
							.getDescription());
					btnMandatory.setSelection(activityStandardProcess
							.isMandatory());
				}
			}

			private void populateMacro(
					SpecificStandardProcess specificStandardProcess) {
				if (specificStandardProcess != null) {
					listAvaliablesMA.removeAll();
					listSelectionsMA.removeAll();
					for (int i = 0; i < activitiesStandardProcess.length; i++) {
						if (specificStandardProcess
								.getActivityStandardProcesses().contains(
										activitiesStandardProcess[i])) {
							listSelectionsMA.add(activitiesStandardProcess[i]
									.getName());
						} else {
							listAvaliablesMA.add(activitiesStandardProcess[i]
									.getName());
						}

					}
				}
			}

		});

		tabFolder.setVisible(false);
		tree.setVisible(false);
		tabFolder.setSelection(0);
		firsttime = false;

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createtree() {

		if (generalStandardProcess != null) {
			if (!firsttime) {

				if (!generalStandardProcess.getSpecialization().isEmpty()) {
					generalStandardProcess
							.setSpecificStandardProcesses(new LinkedHashSet<SpecificStandardProcess>());

					Iterator<StandardProcess> it = generalStandardProcess
							.getSpecialization().iterator();
					StandardProcess standardProcess;
					SpecificStandardProcess specificStandardProcess;
					while (it.hasNext()) {
						standardProcess = it.next();
						if (standardProcess instanceof SpecificStandardProcess) {
							specificStandardProcess = (SpecificStandardProcess) standardProcess;
							generalStandardProcess
									.getSpecificStandardProcesses().add(
											specificStandardProcess);
						}
					}
					firsttime = true;
				}
			}

			tree.removeAll();

			tree.setVisible(true);
			root = new TreeItem(tree, SWT.NONE);
			root.setText(generalStandardProcess.getName());

			tabFolder.setVisible(true);

			TreeItem item;
			// specificStandardProcess.getSpecialization().add(processEngineering);

			if (!generalStandardProcess.getSpecialization().isEmpty()) {

				hashStandardProcesses = new HashMap<TreeItem, SpecificStandardProcess>();

				item = new TreeItem(root, SWT.NONE);
				item.setText(processEngineering.getName());
				hashStandardProcesses.put(item, processEngineering);
				populateProcess(item, processEngineering);

				Iterator<StandardProcess> itsubprocesses = generalStandardProcess
						.getSpecialization().iterator();
				SpecificStandardProcess auxspecificStandardProcess;
				while (itsubprocesses.hasNext()) {

					auxspecificStandardProcess = (SpecificStandardProcess) itsubprocesses
							.next();
					if (!auxspecificStandardProcess.equals(processEngineering)) {
						item = new TreeItem(root, SWT.NONE);
						item.setText(auxspecificStandardProcess.getName());
						hashStandardProcesses.put(item,
								auxspecificStandardProcess);
						populateProcess(item, auxspecificStandardProcess);
					}
				}
			}

		} else {
			MessageDialog.openConfirm(null, "Confirmation",
					"Choice Standard Process to define.");
		}
	}

	private void populateProcess(TreeItem item,
			SpecificStandardProcess auxspecificStandardProcess) {

		if (auxspecificStandardProcess.getActivityStandardProcesses() != null
				&& !auxspecificStandardProcess.getActivityStandardProcesses()
						.isEmpty()) {

			TreeItem auxitem;
			int size = auxspecificStandardProcess
					.getActivityStandardProcesses().size();

			ActivityStandardProcess[] activitiesStandardProcess = auxspecificStandardProcess
					.getActivityStandardProcesses().toArray(
							new ActivityStandardProcess[size]);
			int j = size - 1;
			for (int i = j; i >= 0; i--) {

				auxitem = new TreeItem(item, SWT.NONE, 0);
				auxitem.setText(activitiesStandardProcess[i].getName());

				populateactivity(auxitem, activitiesStandardProcess[i]);
			}

		}

	}

	private void populateactivity(TreeItem item,
			ActivityStandardProcess activityStandardProcess) {

		TreeItem auxItem;
		// kProcedures
		TreeItem itemKprocedure;
		itemKprocedure = new TreeItem(item, SWT.NONE, 0);
		itemKprocedure.setText("Procedures");
		if (activityStandardProcess.getkProcedures() != null
				&& !activityStandardProcess.getkProcedures().isEmpty()) {
			Iterator<KProcedure> itKProcedures = activityStandardProcess
					.getkProcedures().iterator();
			KProcedure kProcedure;
			while (itKProcedures.hasNext()) {
				kProcedure = itKProcedures.next();
				auxItem = new TreeItem(itemKprocedure, SWT.NONE, 0);
				auxItem.setText(kProcedure.getName());

			}
		}
		// kHumanResource
		TreeItem itemKHumanResource;
		itemKHumanResource = new TreeItem(item, SWT.NONE, 0);
		itemKHumanResource.setText("Human Resources");
		if (activityStandardProcess.getkHumanResources() != null
				&& !activityStandardProcess.getkHumanResources().isEmpty()) {
			Iterator<KHumanResource> itKHumanResources = activityStandardProcess
					.getkHumanResources().iterator();
			KHumanResource kHumanResource;
			while (itKHumanResources.hasNext()) {
				kHumanResource = itKHumanResources.next();
				auxItem = new TreeItem(itemKHumanResource, SWT.NONE, 0);
				auxItem.setText(kHumanResource.getName());
			}
		}
		// KResources
		TreeItem itemKResource;
		itemKResource = new TreeItem(item, SWT.NONE, 0);
		itemKResource.setText("Resources");
		if (activityStandardProcess.getkResources() != null
				&& !activityStandardProcess.getkResources().isEmpty()) {
			Iterator<KResource> itKResources = activityStandardProcess
					.getkResources().iterator();
			KResource kResource;
			while (itKResources.hasNext()) {
				kResource = itKResources.next();
				auxItem = new TreeItem(itemKResource, SWT.NONE, 0);
				auxItem.setText(kResource.getName());
			}
		}
		// KArtefacts
		TreeItem itemKArtefacts;
		itemKArtefacts = new TreeItem(item, SWT.NONE, 0);
		itemKArtefacts.setText("Artefacts");

		TreeItem iteminputs;
		iteminputs = new TreeItem(itemKArtefacts, SWT.NONE, 0);
		iteminputs.setText("Inputs");
		if (activityStandardProcess.getInputs() != null
				&& !activityStandardProcess.getInputs().isEmpty()) {
			Iterator<KArtefact> itInputs = activityStandardProcess.getInputs()
					.iterator();
			KArtefact input;
			while (itInputs.hasNext()) {
				input = itInputs.next();
				auxItem = new TreeItem(iteminputs, SWT.NONE, 0);
				auxItem.setText(input.getName());
			}
		}

		TreeItem itemproducts;
		itemproducts = new TreeItem(itemKArtefacts, SWT.NONE, 0);
		itemproducts.setText("Products");
		if (activityStandardProcess.getProducts() != null
				&& !activityStandardProcess.getProducts().isEmpty()) {
			Iterator<KArtefact> itproducts = activityStandardProcess
					.getProducts().iterator();
			KArtefact product;
			while (itproducts.hasNext()) {
				product = itproducts.next();
				auxItem = new TreeItem(itemproducts, SWT.NONE, 0);
				auxItem.setText(product.getName());
			}
		}
		// PreActivies
		TreeItem itemPreActivies;
		itemPreActivies = new TreeItem(item, SWT.NONE, 0);
		itemPreActivies.setText("PreActivities");
		if (activityStandardProcess.getPreActivityStandardProcesses() != null
				&& !activityStandardProcess.getPreActivityStandardProcesses()
						.isEmpty()) {
			Iterator<ActivityStandardProcess> itpreactivities = activityStandardProcess
					.getPreActivityStandardProcesses().iterator();
			ActivityStandardProcess preactivity;

			while (itpreactivities.hasNext()) {
				preactivity = itpreactivities.next();
				auxItem = new TreeItem(itemPreActivies, SWT.NONE, 0);
				auxItem.setText(preactivity.getName());

				// populateactivity(auxItem, preactivity);

			}
		}

		// SubActivies
		TreeItem itemSubActivies;
		itemSubActivies = new TreeItem(item, SWT.NONE, 0);
		itemSubActivies.setText("SubActivities");
		if (activityStandardProcess.getSubActivityStandardProcesses() != null
				&& !activityStandardProcess.getSubActivityStandardProcesses()
						.isEmpty()) {
			Iterator<ActivityStandardProcess> itSubactivities = activityStandardProcess
					.getSubActivityStandardProcesses().iterator();
			ActivityStandardProcess subactivity;
			while (itSubactivities.hasNext()) {
				subactivity = itSubactivities.next();
				auxItem = new TreeItem(itemSubActivies, SWT.NONE, 0);
				auxItem.setText(subactivity.getName());
				populateactivity(auxItem, subactivity);

			}
		}

	}
}
