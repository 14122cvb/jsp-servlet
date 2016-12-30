package com.tav.toolshop.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import com.tav.toolshop.model.dao.DbConnection;

public class Authentication {
	public boolean checkLogin(String username, String password)
	{
		boolean rt=false;
		try
		{
			String plaintext = password;
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(plaintext.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			String hashtext = bigInt.toString(16);
			DbConnection dbcon=new DbConnection();
			String[] field=new String[1];
			field[0]="username";
			Object[][] ob=dbcon.selectDataWhere("username", "user", field, " username= '"+username+"' and pwd= '"+hashtext+"'");
			if(ob.length!=0)		
			rt=true;
		}
		catch(NoSuchAlgorithmException ex){}
		return rt;
	}
	

	

}
