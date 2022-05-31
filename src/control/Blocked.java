package control;

public class Blocked {

    public static boolean block_down(Entity entity) {
        return idObjects[entity.getX() / 32][entity.getY() / 32 + 1] == 0;
    }

    public static boolean block_up(Entity entity) {
        return idObjects[entity.getX() / 32][entity.getY() / 32 - 1] == 0;
    }

    public static boolean block_left(Entity entity) {
        return idObjects[entity.getX() / 32 - 1][entity.getY() / 32] == 0;
    }

    public static boolean block_right(Entity entity) {
        return idObjects[entity.getX() / 32 + 1][entity.getY() / 32] == 0;
    }

    public static boolean block_down_bomb(Entity entity, int power) {
        return idObjects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 0
                || idObjects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 3
                || idObjects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 6
                || idObjects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 7
                || idObjects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 8;
    }

    public static boolean block_up_bomb(Entity entity, int power) {
        return idObjects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 0
                || idObjects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 3
                || idObjects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 6
                || idObjects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 7
                || idObjects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 8;
    }

    public static boolean block_left_bomb(Entity entity, int power) {
        return idObjects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 0
                || idObjects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 3
                || idObjects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 6
                || idObjects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 7
                || idObjects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 8;
    }

    public static boolean block_right_bomb(Entity entity, int power) {
        return idObjects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 0
                || idObjects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 3
                || idObjects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 6
                || idObjects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 7
                || idObjects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 8;
    }
}