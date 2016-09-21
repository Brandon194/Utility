import fileIO.DirectoryList;
import fileIO.FileReadWrite;

import java.io.File;
import java.util.jar.JarFile;

/**
 * Created by Brandon194 on 6/3/2015.
 */
public class test {

    public static void main(String[] args){
        FileReadWrite frw1 = new FileReadWrite("Test","test1");
        FileReadWrite frw2 = new FileReadWrite("Test","test2");

        String[][] s = FileReadWrite.readCSV(frw1.read());
        String[] ss = FileReadWrite.makeCSV(s);

        frw2.write(ss);

        System.out.println("Done");
    }
}
