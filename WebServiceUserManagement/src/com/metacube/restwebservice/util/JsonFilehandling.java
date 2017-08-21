package com.metacube.restwebservice.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Method to handle the file read and write
 * 
 * @author Udit Saxena
 *
 */
public class JsonFilehandling {
	private static FileWriter file;
	private static BufferedReader bufferedReader;

	public static List<JSONObject> read(String filePath) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		String string;
		List<JSONObject> list = new ArrayList<JSONObject>();
		try {
			File readfromFile = new File(filePath);
			FileInputStream fileReader = new FileInputStream(readfromFile);
			bufferedReader = new BufferedReader(new InputStreamReader(
					fileReader));
			while ((string = bufferedReader.readLine()) != null) {
				jsonObj = (JSONObject) parser.parse(string);
				list.add((JSONObject) jsonObj);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Method to write to file
	 * 
	 * @param details
	 */
	public static void write(Object details, String filePath) {
		JSONObject jsonObj = (JSONObject) details;
		// check if object value is empty
		if (!jsonObj.isEmpty()) {
			try {
				file = new FileWriter(filePath, true);
				file.write(jsonObj.toJSONString());
				file.write("\n");
				file.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.print(jsonObj);
	}

	/**
	 * Method to clear the file
	 */
	public static void clearFile(String filePath) {
		try {
			file = new FileWriter(filePath);
			file.write("");
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}