/**
 * class to read files having users and connections
 */
package com.metacube.shoppingCart.Dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileHandling {
	/**
	 * 
	 * @param filepath
	 * @return a string having all values
	 */
	public static String read(String filepath) {
		StringBuffer buf=null;
		try {
			String str = "";
			buf = new StringBuffer();
			FileInputStream  fstream = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			while ((str = br.readLine()) != null) {
				buf.append(str);
		}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return buf.toString();
	}

}
