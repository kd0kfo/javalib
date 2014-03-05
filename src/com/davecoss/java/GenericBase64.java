package com.davecoss.java;

/**
 * Interface to simplify using different libraries, e.g. Android and Apache Commons.
 * 
 * @author David Coss, PhD
 *
 */

import java.io.IOException;
import java.io.OutputStream;


public interface GenericBase64 {

	public String encode(byte[] data) throws Exception;
	public byte[] decode(String string) throws Exception;
	public OutputStream encodeOutputStream (OutputStream baseStream) throws IOException;	
}
