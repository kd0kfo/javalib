package com.davecoss.java;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

public class GUIUtils {

	
	public static File select_file(Component parent) {
		return select_file(parent, false, null);
	}
	
	public static File select_file(Component parent, boolean show_save) {
		return select_file(parent, show_save, null); 
	}
	
	public static File select_file(Component parent, boolean show_save, File starting_dir) {
		JFileChooser file_box = new JFileChooser();
		if(starting_dir != null && starting_dir.isDirectory()) {
			file_box.setCurrentDirectory(starting_dir);
		}
		
		int choice;
		if(show_save)
			choice = file_box.showSaveDialog(parent);
		else
			choice = file_box.showOpenDialog(parent);
	    if (choice == JFileChooser.APPROVE_OPTION) {
            return file_box.getSelectedFile();
        }
	    
	    return null;
	}
}
