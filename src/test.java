import java.nio.file.Path;

/**
 * Created by Brandon194 on 6/3/2015.
 */
public class test {

    public test(){
        try {
            Runtime.getRuntime().exec("shutdown.exe -s -t 60");
            Thread.sleep(5000);
            Runtime.getRuntime().exec("shutdown.exe -a");
        }catch (Exception e){

        }

    }

    public static void main(String[] args){
       new test();
    }
}
