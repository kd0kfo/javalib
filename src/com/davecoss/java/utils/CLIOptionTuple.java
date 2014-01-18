package com.davecoss.java.utils;

import java.io.PrintStream;
import java.io.PrintWriter;

public class CLIOptionTuple {

	public final String name;
	public final boolean hasArg;
	public final String helpMessage;

	public CLIOptionTuple(String name, boolean hasArg, String helpMessage) {
		this.name = name;
		this.hasArg = hasArg;
		this.helpMessage = helpMessage;
	}

	public static void printOptions(PrintStream out, CLIOptionTuple[] clioptions) {
		if(clioptions == null)
			return;
		
		int maxSize = 0;
		int curr = 0;
		for(CLIOptionTuple option : clioptions)
		{
			curr = option.name.length();
			if(curr > maxSize)
				maxSize = curr;
		}
		
		final String fmt = "-%s%s%s\n";
		for(CLIOptionTuple option : clioptions)
		{
			String padding = "";
			curr = maxSize + 4 - option.name.length();
			while(curr > 0) {
				padding += " ";
				curr--;
			}
			out.format(fmt, option.name, padding, option.helpMessage);
		}
	}

}
