package com.davecoss.java.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CredentialPair {

	private String username = null;
	private char[] passphrase = null;
	
	public CredentialPair(String username, char[] passphrase) {
		this.username = username;
		this.passphrase = passphrase;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char[] getPassphrase() {
		return passphrase;
	}
	public void setPassphrase(char[] passphrase) {
		this.passphrase = passphrase;
	}
	
	public void destroyCreds() {
		username = null;
		
		if(passphrase != null) {
			int size = passphrase.length;
			for(int i = 0;i<size;i++)
				passphrase[i] = 0;
		}
	}
	
	public static CredentialPair fromInputStream(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String username = reader.readLine();
		char[] passphrase = reader.readLine().trim().toCharArray();
		
		return new CredentialPair(username, passphrase);
	}
	
}
