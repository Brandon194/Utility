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

    private boolean debug = false;

	public FileReadWrite(String folderNameIn, String fileNameIn){
		
		folderName = folderNameIn;
		fileName = fileNameIn;

        if (debug){
            filePath = ROOT_FOLDER + "\\TESTING\\" + folderName + "\\" + fileName + ".txt";
        } else {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\" + fileName + ".txt";
        }
		
		try{
            if (debug){
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\TESTING\\" + folderName + "\\"));
            } else {
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\"));
            }
			Files.createFile(Paths.get(filePath));
		}catch(Exception e){
			if (!Files.exists(Paths.get(filePath)))
                System.out.println("Path does not exist, creation failed.");
		}
	}
	
	public void writer(String[] InputStringArray){
		
		PrintWriter out;
		try {
            Files.deleteIfExists(Paths.get(filePath));

			out = new PrintWriter(new FileWriter(filePath, false));
			
			for (int i=0;i<InputStringArray.length;i++)
				out.println(InputStringArray[i]);
			
			out.close();
			
		} catch (IOException e) {
			System.out.println("Write Failed");
		}
	}
	
	public String[] reader(){
		
		Path p = (Paths.get(filePath));
		List<String> l = new ArrayList<String>();
		try{
			l = Files.readAllLines(p, StandardCharsets.UTF_8);
		}catch(Exception e){
			System.out.println("Read Fail");
		}

        String[] returnable = new String[l.size()];
        for (int i=0;i<l.size();i++)
            returnable[i] = l.get(i);
		
		return returnable;
	}
}
