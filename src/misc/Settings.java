package misc;

import fileIO.Config;

/**
 * Created by Brandon194 on 6/2/2015.
 */
public class Settings {

    private boolean debug = false;

    public final Config CONFIG;

    public Settings(String projectName){
        CONFIG = new Config(projectName);
    }

    public void toggleDebug() {
        this.debug = !this.debug;
    }
    public void setDebug(boolean debug) {
        this.debug = debug;
    }
    public boolean getDebug() {
        return debug;
    }


}
