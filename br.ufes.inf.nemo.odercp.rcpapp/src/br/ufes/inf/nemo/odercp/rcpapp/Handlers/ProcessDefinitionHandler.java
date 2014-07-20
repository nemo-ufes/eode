package br.ufes.inf.nemo.odercp.rcpapp.Handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;


import br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cui.PageProcessDefine;

/**
 * 
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class ProcessDefinitionHandler extends AbstractHandler {

	/** @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent) */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PageProcessDefine pageProcessDefine = new PageProcessDefine();
		pageProcessDefine.main();
		return null;
	}

}
