package com.davecoss.java.plugin;

public interface Plugin {
	
	public void init() throws PluginInitException;
	
	public String[] list_functions() throws PluginException;
	
	public void destroy() throws PluginException;

}
