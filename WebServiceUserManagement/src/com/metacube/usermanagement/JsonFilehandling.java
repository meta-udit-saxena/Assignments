package com.metacube.usermanagement;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFilehandling {

	public static List<JSONObject> read() {

		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		List<JSONObject> list = new ArrayList<JSONObject>();
		try {

			List<String> l = new ArrayList<String>();
			l = Files.readAllLines(Paths
					.get("C:/Users/goku/eclipse-workspace/new/WebServiceUserManagement/test.json"));
			for (String s : l) {
				obj = (JSONObject) parser.parse(s);
				list.add((JSONObject) obj);

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

	public static void write(Object details) {
		JSONObject obj = (JSONObject) details;

		try {
			FileWriter file = new FileWriter(
					"C:/Users/User27/workspace/UserManagement/test.json", true);
			file.write(obj.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);

	}
	/*
	 * public static void main(String[] args) { List<JSONObject> list = read();
	 * for(JSONObject obj:list){ System.out.println(obj); } }
	 */

}