package control;


public class Blocked {

    public static boolean blockDown(Entity entity) {
        return idObjects[entity.get_X() / 32][entity.get_Y() / 32 + 1] == 0;
    }

    public static boolean blockUp(Entity entity) {
        return idObjects[entity.get_X() / 32][entity.get_Y() / 32 - 1] == 0;
    }

    public static boolean blockLeft(Entity entity) {
        return idObjects[entity.get_X() / 32 - 1][entity.get_Y() / 32] == 0;
    }

    public static boolean blockRight(Entity entity) {
        return idObjects[entity.get_X() / 32 + 1][entity.get_Y() / 32] == 0;
    }

    public static boolean blockDownBomb(Entity entity, int power) {
        return idObjects[entity.get_X() / 32][entity.get_Y() / 32 + 1 + power] == 0
                || idObjects[entity.get_X() / 32][entity.get_Y() / 32 + 1 + power] == 3
                || idObjects[entity.get_X() / 32][entity.get_Y() / 32 + 1 + power] == 6
                || idObjects[entity.get_X() / 32][entity.get_Y() / 32 + 1 + power] == 7
                || idObjects[entity.get_X() / 32][entity.get_Y() / 32 + 1 + power] == 8;
    }

    public static boolean blockUpBomb(Entity entity, int power) {
        return idObjects[entity.get_X() / 32][entity.get_Y() / 32 - 1 - power] == 0
                || idObjects[entity.get_X() / 32][entity.get_Y() / 32 - 1 - power] == 3
                || idObjects[entity.get_X() / 32][entity.get_Y() / 32 - 1 - power] == 6
                || idObjects[entity.get_X() / 32][entity.get_Y() / 32 - 1 - power] == 7
                || idObjects[entity.get_X() / 32][entity.get_Y() / 32 - 1 - power] == 8;
    }

    public static boolean blockLeftBomb(Entity entity, int power) {
        return idObjects[entity.get_X() / 32 - 1 - power][entity.get_Y() / 32] == 0
                || idObjects[entity.get_X() / 32 - 1 - power][entity.get_Y() / 32] == 3
                || idObjects[entity.get_X() / 32 - 1 - power][entity.get_Y() / 32] == 6
                || idObjects[entity.get_X() / 32 - 1 - power][entity.get_Y() / 32] == 7
                || idObjects[entity.get_X() / 32 - 1 - power][entity.get_Y() / 32] == 8;
    }

    public static boolean blockRightBomb(Entity entity, int power) {
        return idObjects[entity.get_X() / 32 + 1 + power][entity.get_Y() / 32] == 0
                || idObjects[entity.get_X() / 32 + 1 + power][entity.get_Y() / 32] == 3
                || idObjects[entity.get_X() / 32 + 1 + power][entity.get_Y() / 32] == 6
                || idObjects[entity.get_X() / 32 + 1 + power][entity.get_Y() / 32] == 7
                || idObjects[entity.get_X() / 32 + 1 + power][entity.get_Y() / 32] == 8;
    }
}