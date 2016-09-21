package fileIO;

/**
 * Created by Brandon194 on 5/22/2015.
 */
public class Config {
    /** how to read and write the config file */
    private final FileReadWrite frw;
    /** the configs file as string */
    private String[] configs;

    public Config(String projectName){
        frw = new FileReadWrite(projectName, projectName, "cfg");
        configs = frw.read();
    }
    public Config(String projectName,String fileName){
        frw = new FileReadWrite(projectName, fileName, "cfg");
        configs = frw.read();
    }

    /**
     * writes the new configs to a file
     * @param newConfigs new configs file data
     */
    public void newConfigsFile(String[] newConfigs){
        configs = newConfigs;
        saveChanges();
    }

    /**
     * Find a config, return the full line
     * @param configName name of the config
     * @return name of the config and the value assigned to it.
     */
    public String findConfig(String configName){
        for (String s : configs){
            if (s.startsWith(configName)){
                return s;
            }
        }

        return null;
    }

    /**
     * Find the index of a config in the array
     * @param configName name of the config to look for
     * @return number of the config in the array
     */
    private int findConfigIndex(String configName){
        for (int i=0;i<configs.length;i++){
            if (configs[i].startsWith(configName)){
                return i;
            }
        }
        return -1;
    }

    /**
     * setting the value of an existing config
     * @param configName name of config (for use in findConfigIndex)
     * @param newValue new value as a string
     */
    public void newConfigValue(String configName, String newValue){
        int index = findConfigIndex(configName);
        if (index != -1){
            configs[index] = configName + "=" + newValue;
            saveChanges();
        } else {
            newConfig(configName, newValue);
        }
    }

    /**
     * adds a new config to the array
     * @param configName name of the config
     * @param value value of the config
     */
    public void newConfig(String configName, String value){
        String[] temp = new String[configs.length + 1];

        for (int i=0;i<configs.length;i++){
            temp[i] = configs[i];
        }
        temp[temp.length-1] = configName + "=" + value;

        configs = temp;

        saveChanges();
    }

    /**
     * apply the changes to the file writen on disk
     */
    public void saveChanges(){
        frw.write(configs);
    }

    public boolean doesExist(String configName){
        if (findConfigIndex(configName) != -1) {
            return true;
        }
        return false;
    }

    public String getValue(String configName){
        for (int i=0;i<configs.length;i++){
            if (configs[i].contains(configName)){
                return configs[i].substring(configName.length()+1);
            }
        }
        return null;
    }

    public String toString(){
        String returnable = "";
        for (String s : configs){
            returnable = returnable + "\n" + s;
        }

        return returnable;
    }
}
