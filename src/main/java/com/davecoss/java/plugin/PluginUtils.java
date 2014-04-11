package com.davecoss.java.plugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;

public class PluginUtils {

	@SuppressWarnings("rawtypes")
	public static Object call_method(Plugin plugin, String class_name, String method_name, Class[] argstypes, Object... args) 
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		System.out.println("Calling " + class_name + "." + method_name);
		
		URLClassLoader urlcl = (URLClassLoader)ClassLoader.getSystemClassLoader();
		Class c = urlcl.loadClass(class_name);
		@SuppressWarnings("unchecked")
		Method protocol_name = c.getMethod(method_name,argstypes);
		Object pluginobj = c.newInstance();
		return protocol_name.invoke(pluginobj,args);
	}
	
	public static String get_main_classname(URL u) throws IOException {
		JarURLConnection uc = (JarURLConnection) u
				.openConnection();
		Attributes attr = uc.getMainAttributes();
		return attr.getValue(Attributes.Name.MAIN_CLASS);
	}
	
	public static String get_main_classname(File jarfile) throws IOException {
		return get_main_classname(new URL("jar", "", "file:" + jarfile.getPath() + "!/"));
	}
	
	public static String get_main_classname(Plugin plugin) throws IOException {
		return get_main_classname(plugin.getJarfile());
	}
	
	
}
