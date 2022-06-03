package Control;

import Entity.Entity;

import static GameRunner.RunBomberman.*;

public class Blocked {

    public static boolean block_down(Entity entity) {   //Create a blocked that prevent all mob go down through the object
        return id_objects[entity.getX() / 32][entity.getY() / 32 + 1] == 0;
    }

    public static boolean block_up(Entity entity) {     //Create a blocked that prevent all mob go up through the object
        return id_objects[entity.getX() / 32][entity.getY() / 32 - 1] == 0;
    }

    public static boolean block_left(Entity entity) {   //Create a blocked that prevent all mob go left through the object
        return id_objects[entity.getX() / 32 - 1][entity.getY() / 32] == 0;
    }

    public static boolean block_right(Entity entity) {   //Create a blocked that prevent all mob go right through the object
        return id_objects[entity.getX() / 32 + 1][entity.getY() / 32] == 0;
    }

    public static boolean block_down_bomb(Entity entity, int power) {   //Limit the scope and animation of the explosion downward
        return id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 0
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 3
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 6
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 7
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 8;
    }

    public static boolean block_up_bomb(Entity entity, int power) {     //Limit the scope and animation of the explosion upward
        return id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 0
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 3
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 6
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 7
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 8;
    }

    public static boolean block_left_bomb(Entity entity, int power) {   //Limit the scope and animation of the explosion to the left
        return id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 0
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 3
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 6
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 7
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 8;
    }

    public static boolean block_right_bomb(Entity entity, int power) {      //Limit the scope and animation of the explosion to the right
        return id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 0
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 3
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 6
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 7
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 8;
    }
}