package com.davecoss.java.utils;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class JDialogCredentialPair extends CredentialPair {

	public JDialogCredentialPair(String username, char[] passphrase) {
		super(username, passphrase);
	}

	public static CredentialPair showInputDialog(Component parent) {
		JTextField unameField = new JTextField(10);
		JLabel uLabel = new JLabel("Username:");
		JPasswordField jPassphrase = new JPasswordField(10);
		JLabel label = new JLabel("Passphrase: ");
		label.setLabelFor(jPassphrase);
		JPanel textPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		textPane.add(uLabel);
		textPane.add(unameField);
        textPane.add(label);
        textPane.add(jPassphrase);
		JOptionPane.showMessageDialog(parent, textPane);
		
		char[] password = jPassphrase.getPassword();
		String username = unameField.getText();
		
		return new JDialogCredentialPair(username, password);
	}
}
