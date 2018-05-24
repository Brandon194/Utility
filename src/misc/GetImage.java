package misc;

import javax.swing.*;
import java.awt.*;

/**
 * Created by BRANDON194 on 2/23/2016.
 */
public class GetImage {

    public static Image getImage(String projectName, String entityName, String animationName, int animationNumber){

        return new ImageIcon(System.getenv("APPDATA") + "\\Brandon194\\" + projectName + "resources\\" +  "entities\\" + entityName + "\\" + animationName + "_" + animationNumber + ".png").getImage();

    }
}
