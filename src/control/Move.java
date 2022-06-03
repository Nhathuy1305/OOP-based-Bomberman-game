package control;

import Graphics.Sprite;
import Entity.animal;

public class Move {
    public static void checkRun(Animal animal) { //Check if all your mob move or not
        if (animal instanceof Bomber && animal.getCount() > 0) {
            setDirection(animal.getDirection(), animal, 8 * speed);
            animal.setCount(animal.getCount() - 1);
        }
        if ((animal instanceof Ballom || animal instanceof Oneal
                || animal instanceof Doll || animal instanceof Kondoria)
                && animal.getCount() > 0) {
            setDirection(animal.getDirection(), animal, 4);
            animal.setCount(animal.getCount() - 1);
        }
    }

    private static void setDirection(String direction, Animal animal, int is_move) { //Show the direction of all mob
        switch (direction) {
            case "down":
                downStep(animal);
                animal.setY(animal.getY() + is_move);
                break;
            case "up":
                upStep(animal);
                animal.setY(animal.getY() - is_move);
                break;
            case "left":
                leftStep(animal);
                animal.setX(animal.getX() - is_move);
                break;
            case "right":
                rightStep(animal);
                animal.setX(animal.getX() + is_move);
                break;
        }
    }

    public static void down(Animal animal) { //Control all mob to go down
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.blockDown(animal)) {
                animal.setDirection("down");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Ballom || animal instanceof Oneal || animal instanceof Doll)
                    && Blocked.blockDown(animal)) {
                animal.setDirection("down");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void downStep(Animal animal) { //Show the animation of all mob that go down
        if (animal instanceof Bomber && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_down_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_down_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballom_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballom_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballom_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballom_right2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void up(Animal animal) { //Control all mob to go up
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.blockUp(animal)) {
                animal.setDirection("up");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Ballom || animal instanceof Oneal || animal instanceof Doll)
                    && Blocked.blockUp(animal)) {
                animal.setDirection("up");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void upStep(Animal animal) { //Show the animation of all mob that go down
        if (animal instanceof Bomber && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_up_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_up_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballom_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballom_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballom_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballom_left2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void left(Animal animal) { //Control all mob to go left
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.blockLeft(animal)) {
                animal.setDirection("left");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Ballom || animal instanceof Oneal
                    || animal instanceof Doll || animal instanceof Kondoria)
                    && Blocked.blockLeft(animal)) {
                animal.setDirection("left");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void leftStep(Animal animal) { //Show the animation of all mob that go left
        if (animal instanceof Bomber && animal.getX() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_left_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballom_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballom_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballom_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballom_right2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Kondoria && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoria_left2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void right(Animal animal) { //Control all mob to go right
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.blockRight(animal)) {
                animal.setDirection("right");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Ballom || animal instanceof Oneal
                    || animal instanceof Doll || animal instanceof Kondoria)
                    && Blocked.blockRight(animal)) {
                animal.setDirection("right");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    public static void rightStep(Animal animal) { //Show the animation of all mob that go right
        if (animal instanceof Bomber && animal.getX() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_right_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_right_2.getFxImage());
                animal.setSwap(1);
            }
        }

        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballom_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballom_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballom_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballom_left2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Kondoria && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(1);
            }
        }
    }
}
