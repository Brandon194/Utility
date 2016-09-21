package fileIO;

/**
 * Created by BRANDON194 on 9/21/2016.
 */
public class README {

    private static String[] s = {
        "This program was created and developed by Brandon194",
        "In this folder, you will find that the different parts of the program",
        "modifying different parts, may cause data to become corrupt, and not",
        "function as intended. That being said, feel free to play with any file",
        "that end in \".cfg\" these are your Configuration files, these are different",
        "variables that your program uses, such as you might fine something named",
        "\"players=20\" this is the player cap for whatever you are using"
    };

    public static void saveReadMe(String projectName){
        if (!FileReadWrite.doesFileExist(projectName, "README", "cfg")) {
            FileReadWrite frw = new FileReadWrite(projectName, "README", "cfg");
            frw.write(s);
            return;
        }
    }
}
