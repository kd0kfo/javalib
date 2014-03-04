package com.davecoss.java;

/**
 * Interface to simplify using different libraries, e.g. Android and Apache Commons.
 * 
 * @author David Coss, PhD
 *
 */

public interface GenericBase64 {

	public String encode(byte[] data) throws Exception;
	public byte[] decode(String string) throws Exception;
	
}
