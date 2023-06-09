package afafi;

import java.util.HashMap;

public class itemID {
    public HashMap<Integer, String[]> id_list = new HashMap<>();
    public HashMap<Integer, String[]> monster_list = new HashMap<>();
    public HashMap<Integer, Integer> playerEq = new HashMap<>();
    public void readItems(){
        //ITEMS
        //int id; String name[0], type[1], attack[2], defence[3], lifeSteal[4], price[5], source[6]
        id_list.put(1, new String[]{"leatherBoots","feet","1","5","1","1000","/afafi/images/plik.png"});
        id_list.put(2, new String[]{"ironBoots","feet","5","10","1","3000","/afafi/images/plik.png"});
        id_list.put(3, new String[]{"platiniumBoots","feet","10","20","5","5000","/afafi/images/plik.png"});
        id_list.put(4, new String[]{"leatherLeggings","legs","4","4","1","2000","/afafi/images/plik.png"});
        id_list.put(5, new String[]{"ironLeggings","legs","9","9","4","4000","/afafi/images/plik.png"});
        id_list.put(6, new String[]{"platiniumLeggings","legs","15","15","7","7000","/afafi/images/plik.png"});
        id_list.put(7, new String[]{"leatherChestplate","chest","5","7","3","4000","/afafi/images/plik.png"});
        id_list.put(8, new String[]{"ironChestplate","chest","8","16","6","8000","/afafi/images/plik.png"});
        id_list.put(9, new String[]{"platiniumChestplate","chest","19","19","9","13000","/afafi/images/plik.png"});
        id_list.put(10, new String[]{"leatherHelmet","head","5","1","1","1000","/afafi/images/plik.png"});
        id_list.put(11, new String[]{"ironHelmet","head","10","5","3","3000","/afafi/images/plik.png"});
        id_list.put(12, new String[]{"platiniumHelmet","head","20","10","5","5000","/afafi/images/plik.png"});
        id_list.put(13, new String[]{"leatherGloves","gloves","5","3","1","1500","/afafi/images/plik.png"});
        id_list.put(14, new String[]{"ironGloves","gloves","7","5","3","3500","/afafi/images/plik.png"});
        id_list.put(15, new String[]{"platiniumGloves","gloves","10","7","5","5500","/afafi/images/plik.png"});
        id_list.put(16, new String[]{"woodenSword","weapon","15","1","0","3000","/afafi/images/plik.png"});
        id_list.put(17, new String[]{"ironSword","weapon","23","2","0","6000","/afafi/images/plik.png"});
        id_list.put(18, new String[]{"platiniumSword","weapon","39","3","1","10000","/afafi/images/plik.png"});
        id_list.put(19, new String[]{"woodenShield","shield","1","15","5","3000","/afafi/images/plik.png"});
        id_list.put(20, new String[]{"ironShield","shield","2","23","10","6000","/afafi/images/plik.png"});
        id_list.put(21, new String[]{"platiniumShield","shield","3","39","15","10000","/afafi/images/plik.png"});
        id_list.put(22, new String[]{"paperRing","ring","1","1","2","400","/afafi/images/plik.png"});
        id_list.put(24, new String[]{"goldRing","ring","8","8","8","4000","/afafi/images/plik.png"});
        id_list.put(25, new String[]{"diamondRing","ring","20","20","20","15000","/afafi/images/plik.png"});
        id_list.put(26, new String[]{"voodooTalisman","amulet","0","0","50","99999","/afafi/images/plik.png"});
        id_list.put(27, new String[]{"fireTalisman","amulet","50","0","0","99999","/afafi/images/plik.png"});
        id_list.put(28, new String[]{"waterTalisman","amulet","0","50","0","99999","/afafi/images/plik.png"});

        //MONSTERS
        //int id; String name[0], hp[1], damage[2], defense[3], source[4]
        monster_list.put(1, new String[]{"husk 1","200","10","5","/afafi/images/plik.png"});
        monster_list.put(2, new String[]{"husk 2","200","10","5","/afafi/images/plik.png"});
        monster_list.put(3, new String[]{"husk 3","200","10","5","/afafi/images/plik.png"});
        monster_list.put(4, new String[]{"husk 4","200","10","5","/afafi/images/plik.png"});
    }
}
