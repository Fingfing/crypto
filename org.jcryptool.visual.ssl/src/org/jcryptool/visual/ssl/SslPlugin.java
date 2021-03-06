package org.jcryptool.visual.ssl;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class SslPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.jcryptool.visual.ssl"; //$NON-NLS-1$

	// The shared instance
	private static SslPlugin plugin;
	
	/**
	 * The constructor
	 */
	public SslPlugin() {
		plugin=this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	//public void start(BundleContext context) throws Exception {
		//super.start(context);
		//plugin = this;
	//}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	//public void stop(BundleContext context) throws Exception {
		//plugin = null;
		//super.stop(context);
	//}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SslPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	//public static ImageDescriptor getImageDescriptor(String path) {
		//return imageDescriptorFromPlugin(PLUGIN_ID, path);
	//}
}
