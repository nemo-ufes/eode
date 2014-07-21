package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;


import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageStandardProcessDefine;

/**
 * 
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class StandardProcessDefinitionHandler extends AbstractHandler {

	/** @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent) */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PageStandardProcessDefine pageProcessDefine = new PageStandardProcessDefine();
		pageProcessDefine.main();
		return null;
	}

}
