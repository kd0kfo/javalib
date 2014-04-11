package com.davecoss.java.plugin;

import java.io.OutputStream;


public abstract class NamedOutputStream extends Plugin {

	/**
	 * Wraps the provided stream with the provided name
	 */
	public abstract OutputStream getOutputStream(OutputStream output, String name) throws PluginException;
	
}
