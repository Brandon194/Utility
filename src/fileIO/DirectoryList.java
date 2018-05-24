package fileIO;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import java.util.List;

/**
 * Created by Brandon194 on 6/3/2015.
 */
public class DirectoryList {

    /** Root Folder appdata\Brandon194 */
    private static final Path ROOT_FOLDER = Paths.get(System.getenv("APPDATA") + "\\Brandon194\\");

    public static void getDirectories(String folderNameIn) {
        //File folder = new File(ROOT_FOLDER + folderNameIn);
        File folder = new File("C:\\Users\\Brandon194\\AppData\\Roaming\\Brandon194\\WorkCalculator");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles){
            if (file.getName().endsWith(".jar")){
                //JarFile.
            }else {
                System.out.println(file.toString());
            }
        }
    }

    public static void addLibrary(File file) throws IOException {
        URL fileURL=file.toURI().toURL();
        List<String> string = new ArrayList<String>();

        JarFile jarFile=new JarFile(file);
        Enumeration<JarEntry> entries=jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry=entries.nextElement();
            String name=entry.getName();
            if (name.endsWith(".class")) {
                name=name.substring(0,name.length() - 6);
                name=name.replace('/','.');
                string.add(name);
            }
        }
        jarFile.close();

        Iterator i = string.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }

    public static void jar(String folderName, String fileName,String[] args) {
        String filePath = ROOT_FOLDER + "\\" + folderName + "\\" + fileName + ".jar";


        try {

            URL[] url = new URL[]{new File(filePath).toURI().toURL()};
            ClassLoader loader = new URLClassLoader(url);
            Class mainClass = loader.loadClass("core.WorkCalculator");
            Method mainMethod = mainClass.getMethod("main", String[].class);
            System.out.println(mainMethod.toString());
            mainMethod.invoke(null , args);
        } catch (Exception e) {
            System.out.println("\nSomething Dun Goofed");
            e.printStackTrace();
        }
    }

}
