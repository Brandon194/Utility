package gui;

import handler.ButtonHandler;
import handler.EntityHandler;
import handler.LevelHandler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.*;

/**
 * Created by BRANDON194 on 8/14/2016.
 */

public class Screen extends Canvas implements Runnable, MouseListener {
    protected static final long serialVersionUID = 4532836895892068039L;

    protected Thread gameThread;
    protected boolean isGameRunning = true;

    protected BufferStrategy BS = getBufferStrategy();

    protected Dimension screenSize = new Dimension(1024, 548);

    protected Graphics g;

    protected EntityHandler entityHandler;
    protected ButtonHandler buttonHandler;

    protected int selected = 0;

    public Screen(Dimension d, LevelHandler levelHandler) {
        screenSize = d;
        this.addMouseListener(this);
    }

    public void run() {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        double delta = 0;

        // Keep looping until the game ends.
        while(isGameRunning) {
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            delta += updateLength / ((double)OPTIMAL_TIME); // Work out how long its been since the last update. This will be used to calculate how far the entities should move this loop.

            //Update the game's logic and then render the screen.
            while(delta >= 1) {
                updateLogic(delta);
                delta--;
            }

            render();
            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try {
                long tempLong = (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000;
                if(tempLong <= 0) { continue; } // Skips the sleep()
                Thread.sleep(tempLong);
            } catch (InterruptedException e) {
                continue;
            }
        }

        stop();
    }

    public synchronized void start() {
        setBackground(Color.WHITE);
        isGameRunning = true;
        gameThread = new Thread(this, "Display");
        gameThread.start();
    }

    public synchronized void stop() {
        try {
            gameThread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    // When called this updates all of the game's logic.
    public void updateLogic(double delta) {

    }

    // When called this updates the screen.
    public void render() {
        // Forces the canvas to use triple buffering.
        BS = getBufferStrategy();
        if (BS == null) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createBufferStrategy(3);
                }
            });
            return;
        }

        // Creates the graphics object and then clears the screen.
        g = BS.getDrawGraphics();

        g.setColor(Color.white);
        g.fillRect(0, 0, screenSize.width, screenSize.height);

        entityHandler.draw(g);

        g.dispose();
        BS.show();
    }

    protected void screenSelect(){
    }

    public Graphics getGraphics(){
        return g;
    }

    public void setEntityHandler(EntityHandler entityHandler){
        this.entityHandler = entityHandler;
    }
    public void setButtonHandler(ButtonHandler buttonHandler){
        this.buttonHandler = buttonHandler;
    }

    public Dimension getScreenSize(){ return screenSize; }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) { buttonHandler.onClick(e.getX(),e.getY(),e.getButton()); }

    @Override
    public void mouseReleased(MouseEvent e) { buttonHandler.onRelease(e.getX(), e.getY(), e.getButton());}

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
