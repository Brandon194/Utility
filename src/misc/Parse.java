package misc;

import java.text.ParseException;

/**
 * Created by Brandon194 on 5/22/2015.
 */
public class Parse {
    public static int parseInt(String s){
        try{
        return Integer.parseInt(s);
    }catch(Exception e){
        return 0;
    }
    }
    public static boolean parseBoolean(String s){
     try{
        return Boolean.parseBoolean(s);

        }catch(Exception e){
            return false;
        }
    }
    public static double parseDouble(String s){
        try {
            return Double.parseDouble(s);
        }catch(Exception e){
            return 0;
        }
    }
    public static long parseLong(String s){
        try{
            return Long.parseLong(s);
        }catch(Exception e){
            return 0;
        }
    }
    public static float parseFloat(String s){
       try{
           return Float.parseFloat(s);
    }catch(Exception e){
        return 0;
    }
    }
    public static byte parseByte(String s){
        try{
        return Byte.parseByte(s);
        }catch(Exception e){
            return 0;
        }
    }
}
