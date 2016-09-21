package handler;

import gui.Button;

/**
 * Created by BRANDON194 on 8/15/2016.
 */
public class ButtonHandler {
    Button bHandler[];
    LevelHandler lHandler;

    private boolean debug = false;

    public ButtonHandler(int size, boolean debug){
        bHandler = new Button[size];
        this.debug = debug;
    }
    public ButtonHandler(int size){
        bHandler = new Button[size];
    }

    public void addButton(Button b){
        for (int i=0;i<bHandler.length;i++){
            if (bHandler[i] == null){
                bHandler[i] = b;
                return;
            }
        }
    }

    public Button getButton(int index){
        return bHandler[index];
    }

    public int getSize(){
        return bHandler.length;
    }

    public void addLevelHandler(LevelHandler lHandler){
        this.lHandler = lHandler;
    }

    public void setSize(int size){
        bHandler = new Button[size];
    }

    public void onClick(int x, int y, int button){
        for (int i=0;i<bHandler.length;i++){
            Button b = bHandler[i];
            if (b != null && x > b.getEntity().getHitBox()[0] && y > b.getEntity().getHitBox()[1] && x < b.getEntity().getHitBox()[2] && y < b.getEntity().getHitBox()[3] && button == 1){
                b.onClick();
            }
        }
    }

    public void onRelease(int x, int y, int button){
        for (int i=0;i<bHandler.length;i++){
            Button b = bHandler[i];
            if (b != null && x > b.getEntity().getHitBox()[0] && y > b.getEntity().getHitBox()[1] && x < b.getEntity().getHitBox()[2] && y < b.getEntity().getHitBox()[3] && button == 1){
                b.onRelease();
            }
        }
    }

    @Override
    public String toString(){
        String s = "List of Buttons\n";
        for (int i=0;i<bHandler.length;i++){
            if (bHandler[i] != null)
            s += bHandler[i].getEntity().getName() + "\n";
        }
        s += "END OF LIST\n-----------------\n\n";

        return s;
    }
}
