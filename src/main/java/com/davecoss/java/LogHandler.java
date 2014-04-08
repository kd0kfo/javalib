package com.davecoss.java;

import java.io.OutputStream;

public interface LogHandler {

	enum Level {VERBOSE, DEBUG, INFO, WARN, ERROR, FATAL };
	
	public void setLevel(Level newlevel);
	public Level getLevel();

	public OutputStream setLogStream(OutputStream stream);
	
	public void fatal(String msg);
	public void fatal(String msg, Throwable throwable);
	
	public void error(String msg);
	public void error(String msg, Throwable throwable);
	
	public void debug(String msg);
	public void debug(String msg, Throwable throwable);
	
	public void warn(String msg);
	public void warn(String msg, Throwable throwable);
	
	public void info(String msg);
	public void info(String msg, Throwable throwable);
	
	public void verbose(String msg);
	public void verbose(String msg, Throwable throwable);
}
