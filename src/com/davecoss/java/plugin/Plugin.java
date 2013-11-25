package com.davecoss.java.plugin;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collection;

import javax.swing.JDialog;

public interface Plugin {
	
    public void init(PrintStream output, InputStream input) throws PluginInitException;

    public void init(JDialog parent) throws PluginInitException;
	
	public Collection<String> list_functions() throws PluginException;
	
	public boolean has_function(String function_name) throws PluginException;
	
	public void destroy() throws PluginException;
	
	public File get_jarfile();

	public File set_jarfile(File file);
}
