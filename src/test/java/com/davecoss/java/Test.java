package com.davecoss.java;

public class Test {
	
	public static Logger L = ConsoleLog.getInstance("Unit Test");

	@org.junit.Test
	public void testMe() {
		L.setLevel(LogHandler.Level.INFO);
		L.info("Foo");
	}

	@org.junit.Test
	public void testBuildInfo() {
		BuildInfo bi = new BuildInfo(BuildInfo.class);
		L.info("Obtained build info");
		L.info((String)bi.get_build_properties().get("build_date"));
	}

}
