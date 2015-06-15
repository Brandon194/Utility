import fileIO.DirectoryList;

import java.io.File;
import java.util.jar.JarFile;

/**
 * Created by Brandon194 on 6/3/2015.
 */
public class test {

    public static void main(String[] args){
        try {
            DirectoryList.addLibrary(new File("C:\\Users\\Brandon194\\AppData\\Roaming\\Brandon194\\WorkCalculator\\WorkCalculator_B2.6_P1.jar"));
            DirectoryList.jar("WorkCalculator", "WorkCalculator_B2.6_P1", args);
        }catch(Exception e){

    }
    }
}
