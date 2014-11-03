package gameUtil;

import javax.swing.*;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class tile {

    private String name;
    private int ID;
    private float hardness = 0.1F;
    private ImageIcon texture = new ImageIcon("noTexture.png");

    public tile(String name,int ID){
        this.name = name;
        this.ID = ID;
    }

    public void setTexture(String textureName){
        try{
            texture = new ImageIcon(textureName);
        }catch(Exception e){

        }
    }
}
