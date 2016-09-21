package handler;

/**
 * Created by BRANDON194 on 8/16/2016.
 */
public class LevelHandler {

    protected EntityHandler entityHandler;
    protected ButtonHandler buttonHandler;

    protected int index = 0;
    protected boolean debug = false;

    public LevelHandler(EntityHandler eh, ButtonHandler bh, boolean debug){
        this.entityHandler = eh;
        this.buttonHandler = bh;
        bh.addLevelHandler(this);
        eh.addLevelHandler(this);
        this.debug = debug;
    }
    public LevelHandler(EntityHandler eh, ButtonHandler bh){
        this.entityHandler = eh;
        this.buttonHandler = bh;

        bh.addLevelHandler(this);
        eh.addLevelHandler(this);
    }

    public void setEntityHandler(EntityHandler eh){
        entityHandler = eh;
    }
    public EntityHandler getEntityHandler(){
        return entityHandler;
    }
    public void setButtonHandler(ButtonHandler bh){
        buttonHandler = bh;
    }
    public ButtonHandler getButtonHandler(){
        return buttonHandler;
    }

    public int getScreenSelected(){
        return index;
    }

    public void screenSelect(int index){

    }
}
