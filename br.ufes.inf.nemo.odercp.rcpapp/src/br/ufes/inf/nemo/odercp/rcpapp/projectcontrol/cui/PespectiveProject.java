package br.ufes.inf.nemo.odercp.rcpapp.projectcontrol.cui;

import javax.annotation.PostConstruct;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PespectiveProject implements IPerspectiveFactory {

	/**
	 * Creates the initial layout for a page.
	 */
	@PostConstruct
	public void createPartControl(Composite parent) {
		
	}
	@PostConstruct
	public void createInitialLayout(IPageLayout layout) {
//		String editorArea = layout.getEditorArea();
//		addFastViews(layout);
//		addViewShortcuts(layout);
//		addPerspectiveShortcuts(layout);
		layout.addView("org.eclipse.ui.navigator.ProjectExplorer", IPageLayout.LEFT, 0.36f, IPageLayout.ID_EDITOR_AREA);
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}
