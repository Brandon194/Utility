package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by BRANDON194 on 8/7/2016.
 */
public class Frame extends JFrame{

    private boolean debug = false;

    private Dimension screenSize;
    private Screen c;


    public Frame(Screen c, Dimension d, boolean debug){
        this.c = c;
        this.debug = debug;
        this.screenSize = d;

        if (!debug)this.getScreenSize();

        this.setTitle("DefaultTitle");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(new Dimension(1024, 512));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.requestFocus();

        this.addWindowListener(new WindowAdapter() { // Runs before the game exits.
            public void windowClosing(WindowEvent e) {
                //Audio.shutdown();
                System.exit(0);
            }
        });

        setSize(screenSize);
        setFocusable(true);
        setVisible(true);

        this.add(this.c);
        this.setVisible(true);

        this.c.start();
    }

    private void getScreenSize(){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    public Screen getCanvas(){
        return c;
    }


}
