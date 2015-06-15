package fileIO;

import sun.plugin.JavaRunTime;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Brandon194 on 6/3/2015.
 */
public class HookingJar {

    public static final Path ROOT_FOLDER = Paths.get(System.getenv("APPDATA") + "\\Brandon194\\");

    private String folderName, fileName, fileType, filePath;

    private boolean debug = false;

    public HookingJar(String folderNameIn, String fileNameIn){

        folderName = folderNameIn;
        fileName = fileNameIn;

        if (debug) {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\Testing\\" + fileName + ".jar";
        } else {
            filePath = ROOT_FOLDER + "\\" + folderName + "\\" + fileName + ".jar";
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

    public void exe(){

    }
}
