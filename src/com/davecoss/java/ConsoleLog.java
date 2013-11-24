package com.davecoss.java;

import java.io.OutputStream;
import java.io.PrintWriter;


public class ConsoleLog implements LogHandler {

	private String prefix = "";
	private PrintWriter log = new PrintWriter(System.err);
	protected Level level = Level.ERROR;
	
	public ConsoleLog(String prefix) {
		this.prefix = prefix + " - ";
	}
	
	public ConsoleLog(String prefix, OutputStream logstream) {
		this.prefix = prefix + " - ";
		this.log = new PrintWriter(logstream);
	}
	
	public ConsoleLog(String prefix, PrintWriter logwriter) {
		this.prefix = prefix + " - ";
		this.log = logwriter;
	}
	
	@Override
	public void setLevel(Level newlevel) {
		level = newlevel;
	}
	
	@Override
	public Level getLevel() {
		return level;
	}
	
	@Override
	public OutputStream setLogStream(OutputStream stream) {
		log = new PrintWriter(stream);
		return stream;
	}
	
	@Override
	public void fatal(String msg) {
		log.write(prefix);
		log.println(msg);
		flush();
	}

	@Override
	public void fatal(String msg, Throwable throwable) {
		fatal(msg);
		throwable.printStackTrace(log);
		flush();
	}

	@Override
	public void error(String msg) {
		if(level.ordinal() > Level.ERROR.ordinal())
			return;
		log.write(prefix);
		log.println(msg);
		flush();
	}

	@Override
	public void error(String msg, Throwable throwable) {
		if(level.ordinal() > Level.ERROR.ordinal())
			return;
		error(msg);
		throwable.printStackTrace(log);
		flush();
	}

	@Override
	public void debug(String msg) {
		if(level.ordinal() > Level.DEBUG.ordinal())
			return;
		log.write(prefix);
		log.println(msg);
		flush();
	}

	@Override
	public void debug(String msg, Throwable throwable) {
		if(level.ordinal() > Level.DEBUG.ordinal())
			return;
		debug(msg);
		throwable.printStackTrace(log);
		flush();
	}

	@Override
	public void warn(String msg) {
		if(level.ordinal() > Level.WARN.ordinal())
			return;
		log.write(prefix);
		log.println(msg);
		flush();
	}

	@Override
	public void warn(String msg, Throwable throwable) {
		if(level.ordinal() > Level.WARN.ordinal())
			return;
		warn(msg);
		throwable.printStackTrace(log);
		flush();
	}

	@Override
	public void info(String msg) {
		if(level.ordinal() > Level.INFO.ordinal())
			return;
		log.write(prefix);
		log.println(msg);
		flush();
	}

	@Override
	public void info(String msg, Throwable throwable) {
		if(level.ordinal() > Level.INFO.ordinal())
			return;
		info(msg);
		throwable.printStackTrace(log);
		flush();
	}
	
	public void flush() {
		log.flush();
	}

}
