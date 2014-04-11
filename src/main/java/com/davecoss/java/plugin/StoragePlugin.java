package com.davecoss.java.plugin;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;


public abstract class StoragePlugin extends Plugin {

	public abstract String get_protocol();
	
	public abstract URI mkdir(String path) throws PluginException;
	
	public abstract boolean isFile(URI uri) throws PluginException;

	public abstract boolean exists(URI uri) throws PluginException;

	public abstract URI[] listFiles(URI uri) throws PluginException;

	/**
	 * Read input from the provided stream. Store it into the File/URI specified in the destination parameter.
	 * 
	 * @param input InputStream Stream to be read
	 * @param amount_to_read int Amount to read. -1 indicates read until EOF.
	 * @param destination URI
	 */
	public abstract URI saveStream(InputStream input, int amount_to_read, URI destination) throws PluginException;

	public abstract InputStream getInputStream(URI uri) throws PluginException;

	public abstract OutputStream getOutputStream(URI uri) throws PluginException;
	
}
