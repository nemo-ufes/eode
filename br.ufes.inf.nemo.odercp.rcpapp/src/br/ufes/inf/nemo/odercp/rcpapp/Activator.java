package br.ufes.inf.nemo.odercp.rcpapp;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
/**
 * Activator for the utility bundle. Among other things, this bundle (and its activator) is responsible for the logging
 * mechanism.
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */





import br.ufes.inf.nemo.odercp.rcpapp.usercontrol.cui.WindowAthenticUser;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		WindowAthenticUser.main(null);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		
	}
	
	
	
	

}
