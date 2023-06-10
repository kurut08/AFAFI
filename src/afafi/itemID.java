package afafi;

import java.util.HashMap;

public class itemID {
    public HashMap<Integer, String[]> id_list = new HashMap<>();
    public HashMap<Integer, String[]> monster_list = new HashMap<>();
    public HashMap<Integer, Integer> playerEq = new HashMap<>();
    public void readItems(){
        //ITEMS
        //int id; String name[0], type[1], attack[2], defence[3], lifeSteal[4], price[5], source[6]
        id_list.put(1, new String[]{"Leather Boots","feet","1","5","1","1000","/afafi/images/icons/Armour/boots_leather.png"});
        id_list.put(2, new String[]{"Iron Boots","feet","5","10","1","3000","/afafi/images/icons/Armour/boots64x64.png"});
        id_list.put(3, new String[]{"Magic Boots","feet","10","20","5","5000","/afafi/images/icons/Armour/magic_boots.png"});
        id_list.put(4, new String[]{"Leather Leggings","legs","4","4","1","2000","/afafi/images/icons/Armour/legs_leather.png"});
        id_list.put(5, new String[]{"Iron Leggings","legs","9","9","4","4000","/afafi/images/icons/Armour/legs64x64.png"});
        id_list.put(6, new String[]{"Magic Leggings","legs","15","15","7","7000","/afafi/images/icons/Armour/magic_legs.png"});
        id_list.put(7, new String[]{"Leather Chestplate","chest","5","7","3","4000","/afafi/images/icons/Armour/chestplate_leather.png"});
        id_list.put(8, new String[]{"Iron Chestplate","chest","8","16","6","8000","/afafi/images/icons/Armour/chestplate64x64.png"});
        id_list.put(9, new String[]{"Magic Robe","chest","19","19","9","13000","/afafi/images/icons/Armour/magic_robe.png"});
        id_list.put(10, new String[]{"Leather Helmet","head","5","1","1","1000","/afafi/images/icons/Armour/helmet_leather.png"});
        id_list.put(11, new String[]{"Iron Helmet","head","10","5","3","3000","/afafi/images/icons/Armour/helmet64x64.png"});
        id_list.put(12, new String[]{"Magic Hat","head","20","10","5","5000","/afafi/images/icons/Armour/magic_hat.png"});
        id_list.put(13, new String[]{"Leather Gloves","gloves","5","3","1","1500","/afafi/images/icons/Armour/gauntlet_leather.png"});
        id_list.put(14, new String[]{"Iron Gloves","gloves","7","5","3","3500","/afafi/images/icons/Armour/gauntlet64x64.png"});
        id_list.put(15, new String[]{"Magic Gloves","gloves","10","7","5","5500","/afafi/images/icons/Armour/magic_gloves.png"});
        id_list.put(16, new String[]{"Wooden Sword","weapon","15","1","0","3000","/afafi/images/icons/Weapon/beginner_sword.png"});
        id_list.put(17, new String[]{"Iron Sword","weapon","23","2","0","6000","/afafi/images/icons/Weapon/Iron_sword.png"});
        id_list.put(18, new String[]{"King Sword","weapon","39","3","1","10000","/afafi/images/icons/Weapon/King_sword.png"});
        id_list.put(19, new String[]{"Wooden Shield","shield","1","15","5","3000","/afafi/images/plik.png"});
        id_list.put(20, new String[]{"Iron Shield","shield","2","23","10","6000","/afafi/images/plik.png"});
        id_list.put(21, new String[]{"Platinium Shield","shield","3","39","15","10000","/afafi/images/plik.png"});
        id_list.put(22, new String[]{"Paper Ring","ring","1","1","2","400","/afafi/images/icons/Armour/ring.png"});
        id_list.put(24, new String[]{"Gold Ring","ring","8","8","8","4000","/afafi/images/icons/Armour/ring.png"});
        id_list.put(25, new String[]{"Diamond Ring","ring","20","20","20","15000","/afafi/images/icons/Armour/ring.png"});
        id_list.put(26, new String[]{"Voodoo Talisman","amulet","0","0","50","99999","/afafi/images/icons/Armour/amulet.png"});
        id_list.put(27, new String[]{"Fire Talisman","amulet","50","0","0","99999","/afafi/images/icons/Armour/amulet.png"});
        id_list.put(28, new String[]{"Water Talisman","amulet","0","50","0","99999","/afafi/images/icons/Armour/amulet.png"});
        id_list.put(29, new String[]{"Amateur Bow","weapon","15","3","1","5000","/afafi/images/icons/Weapon/Amateur_bow.png"});
        id_list.put(30, new String[]{"Advanced Bow","weapon","30","6","2","10000","/afafi/images/icons/Weapon/Advanced_bow.png"});
        id_list.put(31, new String[]{"Legolas Bow","weapon","50","8","5","15000","/afafi/images/icons/Weapon/Legolas_bow.png"});
        id_list.put(32, new String[]{"Rookie Wand","weapon","7","5","10","4000","/afafi/images/icons/Weapon/rookie_wand.png"});
        id_list.put(33, new String[]{"Advanced Wand","weapon","15","10","20","8000","/afafi/images/icons/Weapon/Advanced_wand.png"});
        id_list.put(34, new String[]{"Emperor Wand","weapon","35","15","40","15000","/afafi/images/icons/Weapon/Emperor_wand.png"});
        //MONSTERS
        //int id; String name[0], hp[1], damage[2], defense[3], source[4]
        monster_list.put(1, new String[]{"husk 1","200","10","5","/afafi/images/plik.png"});
        monster_list.put(2, new String[]{"husk 2","200","10","5","/afafi/images/plik.png"});
        monster_list.put(3, new String[]{"husk 3","200","10","5","/afafi/images/plik.png"});
        monster_list.put(4, new String[]{"husk 4","200","10","5","/afafi/images/plik.png"});

        monster_list.put(5,new String[]{"CJ", "400", "20", "10", "/afafi/images/monsters/Los_Zielonas_Goras/CJ.png"});
        monster_list.put(6,new String[]{"Claude", "500", "22", "12", "/afafi/images/monsters/Los_Zielonas_Goras/Claude.png"});
        monster_list.put(7,new String[]{"Tommy Vercetti", "800", "30", "18", "/afafi/images/monsters/Los_Zielonas_Goras/Tommy_Vercetti.png"});

        monster_list.put(100,new String[]{"SkidwayProGaming","1000","100","50", "/afafi/images/monsters/dev_room/SkidwayProGaming.png"});
        monster_list.put(101,new String[]{"Mangekyou","1000","100","50", "/afafi/images/monsters/dev_room/Mangekyou.png"});
        monster_list.put(102,new String[]{"Kurut08","1000","100","50", "/afafi/images/monsters/dev_room/Kurut08.png"});
        monster_list.put(103,new String[]{"???????","1000","100","50", "/afafi/images/monsters/dev_room/EasterEGG.png"});
    }
}
