package br.com.fiap.fiaproupas.utils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeraHash 
{
	public static String gera(String s) 
	{
		try {
		    MessageDigest m = MessageDigest.getInstance("MD5");
		 
		    m.update( s.getBytes(), 0 , s.length() );
		             
		    byte[] digest = m.digest();
		         
		    String hexa = new BigInteger(1,digest).toString(16);
		             
		    return hexa;
		} 
		catch ( NoSuchAlgorithmException e ) 
		{
		    return e.getMessage();
		}
	}

}
