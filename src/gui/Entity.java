package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by BRANDON194 on 8/10/2016.
 */
public class Entity {

    private String name;
    private Image sprite;
    private int x, y;
    private int sizeX, sizeY;

    public Entity(String name, Image sprite, int x, int y, int sizeX, int sizeY){
        this.name = name;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void drawHitBox(Graphics g){
        g.drawRect(x,y,sizeX,sizeY);
    }
    public int[] getHitBox(){
        int[] i = {x,y,x+sizeX,y+sizeY};
        return i;
    }

    public int getSizeY() {
        return sizeY;
    }
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Image getSprite() {
        return sprite;
    }
    public void setSprite(Image i) {
        sprite = i;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getSizeX() {
        return sizeX;
    }
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }
    public static Image getImage(String location){
        return new ImageIcon(location).getImage();
    }
}
