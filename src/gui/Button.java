package gui;

import handler.ButtonHandler;
import handler.EntityHandler;
import handler.LevelHandler;

import java.awt.*;

/**
 * Created by BRANDON194 on 8/14/2016.
 */
public class Button {
    protected Entity e;

    protected boolean click = false;
    protected LevelHandler lh;

    public Button(Entity e, LevelHandler lh){
        this.e = e;
        this.lh = lh;
    }

    public void drawHitBox(Graphics g){
        g.drawRect(e.getX(),e.getY(),e.getSizeX(),e.getSizeY());
    }

    public int[] getRect(){
        int[] i = {e.getX(), e.getY(), e.getSizeX()+ e.getX(), e.getSizeY()+ e.getY()
        };
        return i;
    }

    public void addToHandlers(EntityHandler eh, ButtonHandler bh){
        eh.addEntity(e);
        bh.addButton(this);
    }

    public Entity getEntity(){
        return e;
    }

    public void onClick(){
        click = true;
    }

    public void onRelease(){
        click = false;
    }
}
