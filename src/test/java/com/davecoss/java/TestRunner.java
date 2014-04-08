package com.davecoss.java;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(Test.class);
		for(Failure fail : result.getFailures()) {
			System.err.println(fail.toString());
		}
	}

}
