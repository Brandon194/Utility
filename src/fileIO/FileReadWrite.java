package fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadWrite {
    /** Root Folder appdata\Brandon194 */
    public static final Path ROOT_FOLDER = Paths.get(System.getenv("APPDATA") + "\\Brandon194\\");
    /** Full file path */
    private final String filePath;
    /** Fold and File name on disk */
    private String folderName, fileName;

    private boolean debug = false;

    public FileReadWrite(String folderNameIn, String fileNameIn){

        folderName = folderNameIn;
        fileName = fileNameIn;

        if (debug) {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\Testing\\" + fileName + ".txt";
        } else {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\" + fileName + ".txt";
        }
        try{
            if (debug) {
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\Testing\\"));
            } else {
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\"));
            }
            Files.createFile(Paths.get(filePath));
        }catch(Exception e){
            if (!Files.exists(Paths.get(filePath)))
                System.out.println("Path does not exist, creation failed.");
        }
    }
    public FileReadWrite(String folderNameIn, String fileNameIn, String fileType){

        folderName = folderNameIn;
        fileName = fileNameIn;

        if (debug) {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\Testing\\" + fileName  + "." + fileType;
        } else {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\" + fileName + "." + fileType;
        }
        try{
            if (debug) {
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\Testing\\"));
            } else {
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\"));
            }
            Files.createFile(Paths.get(filePath));
        }catch(Exception e){
            if (!Files.exists(Paths.get(filePath)))
                System.out.println("Path does not exist, creation failed.");
        }
    }
    public FileReadWrite(String folderNameIn, String fileNameIn, boolean debug){

        folderName = folderNameIn;
        fileName = fileNameIn;
        this.debug = debug;

        if (debug) {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\Testing\\" + fileName + ".txt";
        } else {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\" + fileName + ".txt";
        }
        try{
            if (debug) {
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\Testing\\"));
            } else {
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\"));
            }
            Files.createFile(Paths.get(filePath));
        }catch(Exception e){
            if (!Files.exists(Paths.get(filePath)))
                System.out.println("Path does not exist, creation failed.");
        }
    }
    public FileReadWrite(String folderNameIn, String fileNameIn, String fileType, boolean debug){

        folderName = folderNameIn;
        fileName = fileNameIn;
        this.debug = debug;

        if (debug) {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\Testing\\" + fileName  + "." + fileType;
        } else {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\" + fileName + "." + fileType;
        }
        try{
            if (debug) {
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\Testing\\"));
            } else {
                Files.createDirectories(Paths.get(ROOT_FOLDER + "\\" + folderName + "\\"));
            }
            Files.createFile(Paths.get(filePath));
        }catch(Exception e){
            if (!Files.exists(Paths.get(filePath)))
                System.out.println("Path does not exist, creation failed.");
        }
    }

    /**
     * Writes an array of Strings to disk. Each element is a line
     * @param InputStringArray String Array
     */
    public void write(String[] InputStringArray){

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

    /**
     * Reads the file from disk, each line is a new element of the array
     * @return String Array
     */
    public String[] read(){

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

    /**
     * deletes this file
     */
    public void delete(){
        try{
            Files.deleteIfExists(Paths.get(filePath));
        }catch(Exception e){
            System.out.println("Failed to Delete");
        }
    }

    public static String[] makeCSV(String[][] s){


        String[] ss = new String[s.length];
        for (int i=0;i<s.length;i++){
            String returnable = "";

            for (int ii=0;ii<s[i].length;ii++){
                returnable = returnable + s[i][ii];
                if (ii != s[i].length-1){
                    returnable = returnable + ",";
                }
            }
            ss[i] = returnable;
        }

        return ss;
    }

    public static String[][] readCSV(String[] s){

        int comma = 0;


        for (int i=0;i<s[0].length();i++){
            if (s[0].charAt(i) == ','){
                comma++;
            }
        }
        String[][] ss = new String[s.length][comma+1];

        for (int i=0;i<s.length;i++){
            int index = 0;

            char[] c = s[i].toCharArray();

            for (int ii=0;ii<c.length;ii++){
                String ohai = "";

                if (c[ii]==','){
                    for (int o=index;o<ii;o++){
                        ohai = ohai + c[o];
                    }
                    index = ii+1;

                    for (int o=0;o<comma+1;o++){
                        if (ss[i][o] == null){
                            ss[i][o] = ohai;
                            break;
                        }
                    }
                }

                if (ii==c.length-1){
                    for (int o=index;o<c.length;o++){
                        ohai = ohai + c[o];
                    }
                    for (int o=0;o<comma+1;o++){
                        if (ss[i][o] == null){
                            ss[i][o] = ohai;
                            break;
                        }
                    }
                }
            }

        }

        return ss;
    }

    public static boolean doesFileExist(String folder, String file, String extention){

        try{
            String s = "" + ROOT_FOLDER + "\\" + folder + "\\" + file + "." + extention;
            return Files.exists(Paths.get(s));
        }catch (Exception e){
            System.out.println("Something Didn't go so well");
            return false;
        }
    }
    public static boolean doesFileExist(String folder, String file){

        try{
            String s = "" + ROOT_FOLDER + "\\" + folder + "\\" + file + "." + "txt";
            return Files.exists(Paths.get(s));
        }catch (Exception e){
            System.out.println("Something Didn't go so well");
            return false;
        }
    }

    public String toString(){
        return filePath;
    }

    /** Set's debug from the set parameter
     * @param debug
     */
    public void setDebug(boolean debug){
        this.debug = debug;
    }
}