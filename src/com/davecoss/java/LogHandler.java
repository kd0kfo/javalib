package com.davecoss.java;

public interface LogHandler {

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
}
