package handler;

import gui.*;
import gui.Button;

import java.awt.*;

/**
 * Created by BRANDON194 on 8/10/2016.
 */
public class EntityHandler {

    private Entity eHandler[];
    private LevelHandler lHandler;

    private boolean debug = false;

    public EntityHandler(int size, boolean debug){
        eHandler = new Entity[size];
        this.debug = debug;
    }
    public EntityHandler(int size){
        eHandler = new Entity[size];
    }

    public Entity getEntity(String name){
        for (Entity e : eHandler){
            if (e.getName().equals(name)) return e;
        }
        return null;
    }
    public Entity getEntity(int index){
        return eHandler[index];
    }

    public int getEntityIndex(String name){
        for (int i=0;i<eHandler.length;i++){
            if (eHandler[i] != null)
            if (!eHandler[i].getName().equals(name)){ return i; }
        }
        return -1;
    }

    public void addEntity(Entity e){
        for (int i=0;i<eHandler.length-1;i++){
            if (eHandler[i] == null){
                eHandler[i] = e;
                return;
            }
        }
    }

    public void addEntity(Entity e, int index){
        if (index >0 && index <eHandler.length)
        eHandler[index] = e;
    }

    public void removeEntity(String name){
        for (int i=0;i<eHandler.length-1;i++){
            if (eHandler[i].getName().equals(name)){
                eHandler[i] = null;
            }
        }
    }

    public int getSize(){
        return eHandler.length;
    }

    public void setSize(int size){
        eHandler = new Entity[size];
    }

    public void addLevelHandler(LevelHandler lHandler){
        this.lHandler = lHandler;
    }

    public void draw(Graphics g){
        for (int i=0;i<eHandler.length;i++) {

            Entity e = eHandler[i];
            if (e != null) {
                g.drawImage(e.getSprite(), e.getX(), e.getY(), null);
                if (debug) {
                    g.setColor(Color.green);
                    e.drawHitBox(g);
                }
            }
        }
    }

    @Override
    public String toString(){
        String s = "List of Entities\n";
        for (int i=0;i<eHandler.length;i++){
            if (eHandler[i] != null)
            s += eHandler[i].getName() + "\n";
        }
        s += "END OF LIST\n-----------------\n\n";

        return s;
    }
}
