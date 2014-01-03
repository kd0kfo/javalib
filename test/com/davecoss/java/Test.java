package com.davecoss.java;

public class Test {
	
	public static LogHandler L = new ConsoleLog("Unit Test");

	@org.junit.Test
	public void testMe() {
		L.setLevel(LogHandler.Level.INFO);
		L.info("Foo");
	}

}
