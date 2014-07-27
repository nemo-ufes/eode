package br.ufes.inf.nemo.odercp.rcpapp.pespective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IFolderLayout;

import br.ufes.inf.nemo.odercp.rcpapp.userControl.pdl.AcessProfile;
import br.ufes.inf.nemo.odercp.rcpapp.userControl.tml.ApplAuthenticUser;

public class PerspectiveODE implements IPerspectiveFactory {

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		@SuppressWarnings("unused")
		String editorArea = layout.getEditorArea();
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		{
			IFolderLayout folderLayout = layout.createFolder("folderPE", IPageLayout.LEFT, 0.26f, "org.eclipse.ui.editorss");
			folderLayout.addView("org.eclipse.ui.navigator.ProjectExplorer");

		}

		{
			IFolderLayout folderLayout = layout.createFolder("folderODE", IPageLayout.BOTTOM, 0.75f, "org.eclipse.ui.editorss");
			folderLayout.addView("org.eclipse.ui.views.PropertySheet");
			folderLayout.addView("org.eclipse.ui.views.ProblemView");
			if (ApplAuthenticUser.getCorrentUser().getAcessProfile() == AcessProfile.Administrator) {
				folderLayout.addView("br.ufes.inf.nemo.odercp.rcpapp.views.ViewDataODE");
			}

		}

	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {}

}
