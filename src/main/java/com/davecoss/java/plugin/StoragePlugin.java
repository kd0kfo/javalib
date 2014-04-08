package com.davecoss.java.plugin;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;


public interface StoragePlugin extends Plugin {

	public String get_protocol();
	
	public URI mkdir(String path) throws PluginException;
	
	public boolean isFile(URI uri) throws PluginException;

	public boolean exists(URI uri) throws PluginException;

	public URI[] listFiles(URI uri) throws PluginException;

	/**
	 * Read input from the provided stream. Store it into the File/URI specified in the destination parameter.
	 * 
	 * @param input InputStream Stream to be read
	 * @param amount_to_read int Amount to read. -1 indicates read until EOF.
	 * @param destination URI
	 */
	public URI saveStream(InputStream input, int amount_to_read, URI destination) throws PluginException;

	public InputStream getInputStream(URI uri) throws PluginException;

	public OutputStream getOutputStream(URI uri) throws PluginException;
	
}
