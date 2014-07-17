package br.ufes.inf.nemo.odercp.rcpapp.projectControl.cmt;

import br.ufes.inf.nemo.odercp.rcpapp.projectControl.cpd.Project;

public class ApplSelectProject {
	protected static Project selected;

	public static Project getSelected() {
		return selected;
	}

	public static void setSelected(Project project) {
		selected = project;
	}
	
}
