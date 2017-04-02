package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Tanner on 3/11/2017.
 * Class for currency types. Currency can be gold, stone, wood, special resources, or gear
 */

public class Currency implements Serializable {

    String id;
    int wood; //Integer containing the number of a resource within the currency object
    int gold;
    int stone;
    int misc1;
    int misc2;
    int misc3;
    int misc4;
    int misc5;

    public Currency() {
        this.id = UUID.randomUUID().toString();
        this.wood = 0;
        this.gold = 0;
        this.stone = 0;
        this.misc1 = 0;
        this.misc2 = 0;
        this.misc3 = 0;
        this.misc4 = 0;
        this.misc5 = 0;
    }

    public boolean updateResource(boolean add, int wood, int gold, int stone, int misc1, int misc2, int misc3, int misc4, int misc5){
        if(add) {
            this.wood = this.wood + wood;
            this.gold = this.gold + gold;
            this.stone = this.stone + stone;
            this.misc1 = this.misc1 + misc1;
            this.misc2 = this.misc2 + misc2;
            this.misc3 = this.misc3 + misc3;
            this.misc4 = this.misc4 + misc4;
            this.misc5 = this.misc5 + misc5;
        }
        else {
            this.wood = this.wood - wood;
            this.gold = this.gold - gold;
            this.stone = this.stone - stone;
            //we dont want to actually remove any special resources
            /*this.misc1 = this.misc1 - misc1;
            this.misc2 = this.misc2 - misc2;
            this.misc3 = this.misc3 - misc3;
            this.misc4 = this.misc4 - misc4;
            this.misc5 = this.misc5 - misc5;*/
        }
        return true;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public int getMisc1() {
        return misc1;
    }

    public void setMisc1(int misc1) {
        this.misc1 = misc1;
    }

    public int getMisc2() {
        return misc2;
    }

    public void setMisc2(int misc2) {
        this.misc2 = misc2;
    }

    public int getMisc3() {
        return misc3;
    }

    public void setMisc3(int misc3) {
        this.misc3 = misc3;
    }

    public int getMisc4() {
        return misc4;
    }

    public void setMisc4(int misc4) {
        this.misc4 = misc4;
    }

    public int getMisc5() {
        return misc5;
    }

    public void setMisc5(int misc5) {
        this.misc5 = misc5;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
