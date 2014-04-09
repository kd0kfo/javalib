package com.davecoss.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BuildInfo {
	private Properties info_data = null;

	public BuildInfo(@SuppressWarnings("rawtypes") Class c) {
		Package pack = c.getPackage();
		if(pack == null) {
			info_data = null;
			return;
		}
		String packageName = pack.getName();
		info_data = new Properties();
		InputStream info_file = get_info_file("/" + packageName + ".build_info.properties", c);
		if (info_file == null) {
			info_data = null;
		} else {
			try {
				info_data.load(info_file);
			} catch (IOException e) {
				info_data = null;
			}
		}
	}

	public Properties get_build_properties() {
		return info_data;
	}

	public String get_version() {
		return info_data.getProperty("version");
	}
	
	public InputStream get_info_file(String filename) {
		 return get_info_file(filename, this.getClass());
	}
	
	public InputStream get_info_file(String filename, @SuppressWarnings("rawtypes") Class c) {
		return c.getResourceAsStream(filename);
	}
}
