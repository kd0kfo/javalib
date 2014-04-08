package com.davecoss.java;

import java.io.OutputStream;

public class Logger implements LogHandler {

	protected static LogHandler log = null;
	protected static Logger instance = null;
	
	protected Logger() {
		// nothing to do
	}
	
	public static Logger getInstance() {
		if(instance == null)
			instance = new Logger();
		return instance;
	}
	
	public static LogHandler setLog(LogHandler newlog) {
		log = newlog;
		return log;
	}
	
	@Override
	public void setLevel(Level newlevel) {
		log.setLevel(newlevel);
	}

	@Override
	public Level getLevel() {
		return log.getLevel();
	}

	@Override
	public OutputStream setLogStream(OutputStream stream) {
		return log.setLogStream(stream);
	}

	@Override
	public void fatal(String msg) {
		if(log == null)
			return;
		log.fatal(msg);
	}

	@Override
	public void fatal(String msg, Throwable throwable) {
		if(log == null)
			return;
		log.fatal(msg, throwable);
	}

	@Override
	public void error(String msg) {
		if(log == null)
			return;
		log.error(msg);
	}

	@Override
	public void error(String msg, Throwable throwable) {
		if(log == null)
			return;
		log.error(msg, throwable);
	}

	@Override
	public void debug(String msg) {
		if(log == null)
			return;
		log.debug(msg);
	}

	@Override
	public void debug(String msg, Throwable throwable) {
		if(log == null)
			return;
		log.debug(msg, throwable);
	}

	@Override
	public void warn(String msg) {
		if(log == null)
			return;
		log.warn(msg);
	}

	@Override
	public void warn(String msg, Throwable throwable) {
		if(log == null)
			return;
		log.warn(msg, throwable);
	}

	@Override
	public void info(String msg) {
		if(log == null)
			return;
		log.info(msg);
	}

	@Override
	public void info(String msg, Throwable throwable) {
		if(log == null)
			return;
		log.info(msg, throwable);
	}
	
	@Override
	public void verbose(String msg) {
		if(log == null)
			return;
		log.verbose(msg);
	}

	@Override
	public void verbose(String msg, Throwable throwable) {
		if(log == null)
			return;
		log.verbose(msg, throwable);
	}
	
	public static Level parseLevel(String level) {
		return Level.valueOf(level);
	}

}
