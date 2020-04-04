package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;




public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity){		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		
			byte[] messageDigest = md.digest(entity.getBytes("UTF-8"));
		
			String hashtext = toHex(messageDigest);

//			BigInteger no = new BigInteger(1, messageDigest);
//		
//			String hashtext = no.toString(16);
//			while(hashtext.length() < 32) {
//				hashtext = "0" + hashtext;
//						}
			
			
			
			hashint = new BigInteger(hashtext, 16);
		
		
		
		
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		BigInteger size = new BigInteger("2");
		
		try {
			int length = MessageDigest.getInstance("MD5").getDigestLength();
		
			int bits = length * 8;
			
			size = size.pow(bits);
		
		
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// get the digest length
		
		// compute the number of bits = digest length * 8
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		return size;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		try {
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
