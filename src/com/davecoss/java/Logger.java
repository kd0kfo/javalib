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
		log.fatal(msg);
	}

	@Override
	public void fatal(String msg, Throwable throwable) {
		log.fatal(msg, throwable);
	}

	@Override
	public void error(String msg) {
		log.error(msg);
	}

	@Override
	public void error(String msg, Throwable throwable) {
		log.error(msg, throwable);
	}

	@Override
	public void debug(String msg) {
		log.debug(msg);
	}

	@Override
	public void debug(String msg, Throwable throwable) {
		log.debug(msg, throwable);
	}

	@Override
	public void warn(String msg) {
		log.warn(msg);
	}

	@Override
	public void warn(String msg, Throwable throwable) {
		log.warn(msg, throwable);
	}

	@Override
	public void info(String msg) {
		log.info(msg);
	}

	@Override
	public void info(String msg, Throwable throwable) {
		log.info(msg, throwable);
	}
	
	public static Level parseLevel(String level) {
		return Level.valueOf(level);
	}

}
