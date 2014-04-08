package com.davecoss.java;

public class Main {
	public static void main(String[] args) {
		BuildInfo bi = new BuildInfo(Main.class);
		System.out.println("This is a java library. Version: " + bi.get_version());
	}
}
