package com.davecoss.java.plugin;

import java.io.InputStream;
import java.net.URI;


public interface StoragePlugin extends Plugin {

	public String get_protocol();
	
	public URI saveuri(InputStream input, int amount_to_write, URI destination);
	
	public URI mkdir(String path);
	
}
