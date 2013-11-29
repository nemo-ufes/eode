package br.ufes.inf.nemo.odercp.rcpapp;

import br.ufes.inf.nemo.util.logging.LogUtil;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator, OdeRcpAppBundleInfoProvider {
	/** ID of the part stack in which editors should be opened. */

	/** The bundle's context. */
	private static BundleContext context;

	/** The bundle itself. */
	private static Bundle bundle;

	/** The bundle's ID. */
	private static String bundleId;

	/** @see it.unitn.disi.unagi.rcpapp.IUnagiRcpAppBundleInfoProvider#getBundle() */
	public Bundle getBundle() {
		return bundle;
	}

	/** @see it.unitn.disi.unagi.rcpapp.IUnagiRcpAppBundleInfoProvider#getBundleId() */
	public String getBundleId() {
		return bundleId;
	}

	/** @see it.unitn.disi.unagi.rcpapp.IUnagiRcpAppBundleInfoProvider#getContext() */
	public BundleContext getContext() {
		return context;
	}

	/** @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext) */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Activator.bundle = context.getBundle();
		Activator.bundleId = bundle.getSymbolicName();

		// Initializes the logger.
		ServiceTracker<LogService, LogService> logTracker = new ServiceTracker<LogService, LogService>(context, LogService.class, null);
		logTracker.open();
		LogUtil.initialize(logTracker.getService());
		LogUtil.log.info("Unagi RCP Application has started."); //$NON-NLS-1$
	}

	/** @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext) */
	public void stop(BundleContext bundleContext) throws Exception {
		LogUtil.log.info("Unagi RCP Application has stopped."); //$NON-NLS-1$
	}

	/** @see it.unitn.disi.unagi.rcpapp.IUnagiRcpAppBundleInfoProvider#getEditorStackId() */
	@Override
	public String getEditorStackId() {
		return null;
	}
}
