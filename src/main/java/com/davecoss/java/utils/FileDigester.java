package com.davecoss.java.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileDigester {

    public static String md5File(String filename) throws IOException,NoSuchAlgorithmException {
	return md5File(new File(filename));
    }
    
    public static String md5File(File file) throws IOException,NoSuchAlgorithmException {
	return md5File(file, new byte[4096]);
    }

    public static String md5File(File file, byte[] buffer) throws IOException,NoSuchAlgorithmException {
	return hashFile(file, buffer, "MD5");
    }

    public static String hashFile(File file, byte[] buffer, String algorithm) throws IOException,NoSuchAlgorithmException {
	return hashStream(new FileInputStream(file), buffer, algorithm);
    }

    public static String hashStream(InputStream input, byte[] buffer, String algorithm) throws IOException,NoSuchAlgorithmException {
	DigestInputStream hasher = new DigestInputStream(input, MessageDigest.getInstance(algorithm));
	 while(hasher.read(buffer) != -1)
	     continue;
	 MessageDigest hash = hasher.getMessageDigest();
	 
	 String retval = "";
	 for(byte tohex : hash.digest())
	     retval += String.format("%02x", tohex);

	 return retval;
    }

    public static void main(String[] args) throws IOException,NoSuchAlgorithmException {
	byte[] buffer = new byte[4096];
	for(String filename : args) {
	    System.out.println(md5File(filename) + " " + filename);
	    
	}
    }

}