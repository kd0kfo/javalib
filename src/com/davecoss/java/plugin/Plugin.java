package com.davecoss.java.plugin;

import java.io.File;
import java.util.Collection;

public interface Plugin {
	
	public void init() throws PluginInitException;
	
	public Collection<String> list_functions() throws PluginException;
	
	public boolean has_function(String function_name) throws PluginException;
	
	public void destroy() throws PluginException;
	
	public File get_jarfile();

	public File set_jarfile(File file);
}
