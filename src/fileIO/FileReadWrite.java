package fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReadWrite {
	public static final Path ROOT_FOLDER = Paths.get(System.getenv("APPDATA") + "\\Brandon194\\");
	String filePath;
	private String folderName, fileName;

	public FileReadWrite(String folderNameIn, String fileNameIn){
		
		folderName = folderNameIn;
		fileName = fileNameIn;
		
		filePath = ROOT_FOLDER + "\\" + folderName + "\\" + fileName + ".txt";
		
		try{
			Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\"));
			Files.createFile(Paths.get(filePath));
		}catch(Exception e){
			System.out.println("Creation Failed");
		}
	}
	
	public void Writer(String[] InputStringArray){
		
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(filePath, false));
			
			for (int i=0;i<InputStringArray.length;i++)
				out.println(InputStringArray[i]);
			
			out.close();
			
		} catch (IOException e) {
			System.out.println("Write Failed");
		}
	}
	
	public List<String> Reader(){
		
		Path p = (Paths.get(filePath));
		List<String> l = new ArrayList<String>();
		try{
			l = Files.readAllLines(p, StandardCharsets.UTF_8);
		}catch(Exception e){
			System.out.println("Read Fail");
		}			
		
		return l;
	}
}
