package control;

import Entity.Entity;

public class Blocked {

    public static boolean blockDown(Entity entity) { //Create a blocked that prevent all mob go down through the object
        return id_objects[entity.getX() / 32][entity.getY() / 32 + 1] == 0;
    }

    public static boolean blockUp(Entity entity) { //Create a blocked that prevent all mob go up through the object
        return id_objects[entity.getX() / 32][entity.getY() / 32 - 1] == 0;
    }

    public static boolean blockLeft(Entity entity) { //Create a blocked that prevent all mob go left through the object
        return id_objects[entity.getX() / 32 - 1][entity.getY() / 32] == 0;
    }

    public static boolean blockRight(Entity entity) { //Create a blocked that prevent all mob go right through the object
        return id_objects[entity.getX() / 32 + 1][entity.getY() / 32] == 0;
    }

    public static boolean blockDownBomb(Entity entity, int power) { //Limit the scope and animation of the explosion downward
        return id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 0
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 3
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 6
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 7
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 8;
    }

    public static boolean blockUpBomb(Entity entity, int power) { //Limit the scope and animation of the explosion upward
        return id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 0
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 3
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 6
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 7
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 8;
    }

    public static boolean blockLeftBomb(Entity entity, int power) { //Limit the scope and animation of the explosion to the left
        return id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 0
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 3
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 6
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 7
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 8;
    }

    public static boolean blockRightBomb(Entity entity, int power) { //Limit the scope and animation of the explosion to the right
        return id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 0
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 3
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 6
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 7
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 8;
    }
}