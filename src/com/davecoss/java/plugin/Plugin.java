package com.davecoss.java.plugin;

import java.util.Collection;

public interface Plugin {
	
	public void init() throws PluginInitException;
	
	public Collection<String> list_functions() throws PluginException;
	
	public void destroy() throws PluginException;

}
