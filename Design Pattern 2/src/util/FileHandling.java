package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {
	private static FileHandling fileHandling;

	public static FileHandling getInstance() {
		if (fileHandling == null) {
			synchronized (FileHandling.class) {
				if (fileHandling == null) {
					fileHandling = new FileHandling();
				}
			}
		}
		return fileHandling;
	}

	/**
	 * Read file
	 * 
	 * @param filePath
	 *            - has the location of file from which we have to read data
	 * @return the List of strings which contains the content of the file
	 * 
	 */
	public List<String> read(String filePath) {
		List<String> l = new ArrayList<String>();
		try {
			l = Files.readAllLines(Paths.get(filePath));
		} catch (IOException e) {
		}
		return l;

	}

	/**
	 * Write File on its location
	 * 
	 * @param billDetails
	 *            - is the bill that need to be printed in file
	 * @param filePath
	 *            - is the location of file which we need to add content
	 * 
	 */
	public void write(String billDetails,String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					filePath+"'s bill.txt")));
			bw.write(billDetails);
			bw.close();
		} catch (Exception e) {
		}
	}

}
