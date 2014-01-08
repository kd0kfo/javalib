package com.davecoss.java.utils;

public class CLIOptionTuple {

	public final String name;
	public final boolean hasArg;
	public final String helpMessage;

	public CLIOptionTuple(String name, boolean hasArg, String helpMessage) {
		this.name = name;
		this.hasArg = hasArg;
		this.helpMessage = helpMessage;
	}

}
