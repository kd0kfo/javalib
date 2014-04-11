package com.davecoss.java.plugin;

import java.io.Console;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collection;

import javax.swing.JDialog;

public abstract class Plugin {
	
	public abstract void init(Console console) throws PluginInitException;
	
	public abstract void init(JDialog parent) throws PluginInitException;
	
	public abstract void destroy() throws PluginException;
	
	public abstract File getJarfile();

	public abstract File setJarfile(File file);
	
	
	/**
	 * Based on the plugin type name, returns the specific class.
	 * 
	 * If no class is defined for the provided type, a PluginException is thrown.
	 */
	public Class getPluginByType(String type) throws PluginException {
		throw new PluginException(String.format("%s does not implement getPluginByType.", this.getClass().getName()));
	}
	
}
