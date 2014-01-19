package com.davecoss.java.plugin;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;

import javax.swing.JDialog;

public class LocalStoragePlugin implements StoragePlugin {
	
	private File jarfile = null;
	
	public LocalStoragePlugin () {
		
	}
	
	@Override
	public String get_protocol() {
		return "file";
	}
	
	@Override
	public void init(PrintStream output, InputStream input) throws PluginInitException {
		// Nothing to do.
	}

        @Override
	public void init(JDialog parent) throws PluginInitException {
	    // Nothing to do
	}


	@Override
	public void destroy() throws PluginException {
		// Nothing to do
	}

	@Override
	public File get_jarfile() {
		return jarfile;
	}

	@Override
	public File set_jarfile(File file) {
		return (jarfile = file);
	}

	@Override
	public URI saveStream(InputStream input, int amount_to_write, URI destination) throws PluginException {
		OutputStream output = null;
		try {
			output = new FileOutputStream(destination.getPath());
			int buffersize = 4096;
			byte[] buffer = new byte[buffersize];
			int amount_read = 0;
			int total_written = 0;
			while((amount_read = input.read(buffer, 0, buffersize)) != -1) {
				if(amount_to_write == -1) {
					output.write(buffer, 0, amount_read);
				} else if(amount_read + total_written > amount_to_write) {
					output.write(buffer, 0, amount_to_write - total_written - amount_read);
					break;
				} else {
					output.write(buffer, 0, amount_to_write);
				}
				total_written += amount_read;
			}
			return destination;
		} catch (Exception e) {
			throw new PluginException("Error writing file '" + destination.getPath() + "'", e);
		} finally {
			try {
				if(output != null)
					output.close();
			} catch (IOException e) {
				throw new PluginException("Error closing output stream: " + e.getMessage(), e);
			}
		}
		
	}

	@Override
	public URI mkdir(String path) {
		File newdir = new File(path);
		newdir.mkdir();
		return newdir.toURI();
	}

	@Override
	public boolean isFile(URI uri) {
		return (new File(uri.getPath())).isFile();
	}

	@Override
	public boolean exists(URI uri) {
		File file = new File(uri.getPath());
		return file.exists();
	}

	@Override
	public URI[] listFiles(URI uri) {
		File dir = new File(uri.getPath());
		File[] files = dir.listFiles();
		URI[] uris = new URI[files.length];
		int idx = 0;
		for(File file : files) {
			uris[idx++] = file.toURI();
		}
		return uris;
	}

	@Override
	public InputStream getInputStream(URI uri) throws PluginException {
		try {
			return new FileInputStream(uri.getPath());
		} catch (FileNotFoundException fnfe) {
			throw new PluginException("Unable to open file '" + uri.getPath() + "'", fnfe);
		}
	}
	
	@Override
	public OutputStream getOutputStream(URI uri) throws PluginException {
		try {
			return new FileOutputStream(uri.getPath());
		} catch (FileNotFoundException e) {
			throw new PluginException("Error getting output stream for '" + uri.toString() + "'", e);
		}
	}

	@Override
	public void init(Console console) throws PluginInitException {
		// Nothing to do
	}
}
