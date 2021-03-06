package com.davecoss.java;

/**
 * Interface to simplify using different libraries, e.g. Android and Apache Commons.
 * 
 * @author David Coss, PhD
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public interface GenericBaseN {

	public String encode(byte[] data) throws Exception;
	public byte[] decode(String string) throws Exception;
	public OutputStream encodeOutputStream (OutputStream baseStream) throws IOException;
	public InputStream decodeInputStream (InputStream baseStream) throws IOException;
}
