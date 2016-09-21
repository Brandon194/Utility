package misc;

import javax.swing.*;
import java.awt.*;

/**
 * Created by BRANDON194 on 1/28/2016.
 */
public class Renderable {

    private Image i;
    private String path;
    private double x, y;

    public Renderable(String projectName,String entityName,String animationName,int animationNumber, double x, double y){
        i = GetImage.getImage(projectName,entityName, animationName, animationNumber);
        this.x = x;
        this.y = y;
    }

    public Image getImage(){
        return i;
    }
    public String getPath() {
        return path;
    }
    public int getX(){
        return (int) x;
    }
    public int getY(){
        return (int) y;
    }


}
