package br.ufes.inf.nemo.odercp.rcpapp;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public interface OdeRcpAppBundleInfoProvider {
	Bundle getBundle();

	/**
	 * Retrieves the bundle's ID.
	 * 
	 * @return A string containing the bundle's ID.
	 */
	String getBundleId();

	/**
	 * Retrieves the bundle's context.
	 * 
	 * @return The bundle's context.
	 */
	BundleContext getContext();

	/**
	 * Retrieves the ID of the part stack in which editors should be opened.
	 * 
	 * @return The ID of the part stack in which editors should be opened.
	 */
	String getEditorStackId();
}
