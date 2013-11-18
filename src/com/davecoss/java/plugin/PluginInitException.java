package com.davecoss.java.plugin;

public class PluginInitException extends PluginException {

	private static final long serialVersionUID = -5881261429292964722L;

	public PluginInitException() {
		super();
	}

	public PluginInitException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PluginInitException(String message, Throwable cause) {
		super(message, cause);
	}

	public PluginInitException(Throwable cause) {
		super(cause);
	}

	public PluginInitException(String message) {
		super(message);
	}
	
	
	
}
