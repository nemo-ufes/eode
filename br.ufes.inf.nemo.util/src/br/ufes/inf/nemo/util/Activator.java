package br.ufes.inf.nemo.util;


import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Activator for the utility bundle. Among other things, this bundle (and its activator) is responsible for the logging
 * mechanism.
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
public class Activator implements BundleActivator {

	/** The bundle's context. */
	private static BundleContext context;

	/** The bundle itself. */
	private static Bundle bundle;

	/** The bundle's ID. */
	private static String bundleId;

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public static BundleContext getContext() {
		return context;
	}

	public static void setContext(BundleContext context) {
		Activator.context = context;
	}

	public static Bundle getBundle() {
		return bundle;
	}

	public static void setBundle(Bundle bundle) {
		Activator.bundle = bundle;
	}

	public static String getBundleId() {
		return bundleId;
	}

	public static void setBundleId(String bundleId) {
		Activator.bundleId = bundleId;
	}


}
