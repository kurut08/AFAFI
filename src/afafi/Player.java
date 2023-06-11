package afafi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Player
{
    HashMap<String, Integer> currentEXP = new HashMap<>();
    HashMap<String, Integer> currentLEVEL = new HashMap<>();

    Player(){
        //new character
        currentEXP.put("attack", 0);
        currentEXP.put("strength", 0);
        currentEXP.put("defense", 0);
        currentEXP.put("hitpoints", 0);
        currentEXP.put("ranged", 0);
        currentEXP.put("magic", 0);
        currentEXP.put("woodcutting", 0);
        currentEXP.put("crafting", 0);
        currentEXP.put("mining", 0);
        currentEXP.put("smithing", 0);
        currentEXP.put("fishing", 0);
        currentEXP.put("farming", 0);
        currentEXP.put("cooking", 0);

        currentLEVEL.put("attack", 1);
        currentLEVEL.put("strength", 1);
        currentLEVEL.put("defense", 1);
        currentLEVEL.put("hitpoints", 1);
        currentLEVEL.put("ranged", 1);
        currentLEVEL.put("magic", 1);
        currentLEVEL.put("woodcutting", 1);
        currentLEVEL.put("crafting", 1);
        currentLEVEL.put("mining", 1);
        currentLEVEL.put("smithing", 1);
        currentLEVEL.put("fishing", 1);
        currentLEVEL.put("farming", 1);
        currentLEVEL.put("cooking", 1);
        currentLEVEL.put("money", 1000);
    }
    Player(String characterName) throws IOException {
        Properties level = new Properties();
        Properties exp = new Properties();
        level.load(new FileInputStream("data/accounts/admin/"+characterName+"/level.properties"));
        exp.load(new FileInputStream("data/accounts/admin/"+characterName+"/exp.properties"));
        for (String key : level.stringPropertyNames()) {
            currentLEVEL.put(key, Integer.parseInt(level.get(key).toString()));
        }
        for (String key : exp.stringPropertyNames()) {
            currentEXP.put(key, Integer.parseInt(exp.get(key).toString()));
        }
    }

    public void setLEVEL(String name, int value){
        currentLEVEL.put(name, value);
    }
    public void setEXP(String name, int value){
        currentEXP.put(name, value);
    }
    public int getLEVEL(String name){
        return currentLEVEL.get(name);
    }
    public int getEXP(String name){
        return currentEXP.get(name);
    }
}