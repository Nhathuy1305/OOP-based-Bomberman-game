package Control;

import Entity.animal.*;
import Graphics.Sprite;

import static Entity.items.SpeedItem.speed;

public class Move {
    public static void checkRun(Animal animal) {    //Check if all your mob move or not
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

    private static void setDirection(String direction, Animal animal, int isMove) {     //Show the direction of all mob
        switch (direction) {
            case "down":
                down_step(animal);
                animal.setY(animal.getY() + isMove);
                break;
            case "up":
                up_step(animal);
                animal.setY(animal.getY() - isMove);
                break;
            case "left":
                left_step(animal);
                animal.setX(animal.getX() - isMove);
                break;
            case "right":
                right_step(animal);
                animal.setX(animal.getX() + isMove);
                break;
        }
    }

    public static void down(Animal animal) {        //Control all mob to go down
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_down(animal)) {
                animal.setDirection("down");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Ballom || animal instanceof Oneal || animal instanceof Doll)
                    && Blocked.block_down(animal)) {
                animal.setDirection("down");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void down_step(Animal animal) {      //Show the animation of all mob that go down
        if (animal instanceof Bomber && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.control_down.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.control_down_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.control_down.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.control_down_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballom_right_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballom_right_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballom_right_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballom_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_right_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_right_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_right_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_left_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_left_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_left_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void up(Animal animal) {      //Control all mob to go up
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_up(animal)) {
                animal.setDirection("up");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Ballom || animal instanceof Oneal || animal instanceof Doll)
                    && Blocked.block_up(animal)) {
                animal.setDirection("up");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void up_step(Animal animal) {        //Show the animation of all mob that go down
        if (animal instanceof Bomber && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.control_up.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.control_up_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.control_up.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.control_up_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballom_left_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballom_left_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballom_left_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballom_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_left_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_left_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_left_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_right_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_right_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_right_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void left(Animal animal) {        //Control all mob to go left
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_left(animal)) {
                animal.setDirection("left");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Ballom || animal instanceof Oneal
                    || animal instanceof Doll || animal instanceof Kondoria)
                    && Blocked.block_left(animal)) {
                animal.setDirection("left");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void left_step(Animal animal) {      //Show the animation of all mob that go left
        if (animal instanceof Bomber && animal.getX() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.control_left.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.control_left_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.control_left.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.control_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballom_right_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballom_right_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballom_right_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballom_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_right_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_right_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_right_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_left_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_left_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_left_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Kondoria && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_left_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_left_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_left_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoria_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void right(Animal animal) {       //Control all mob to go right
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_right(animal)) {
                animal.setDirection("right");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Ballom || animal instanceof Oneal
                    || animal instanceof Doll || animal instanceof Kondoria)
                    && Blocked.block_right(animal)) {
                animal.setDirection("right");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    public static void right_step(Animal animal) {      //Show the animation of all mob that go right
        if (animal instanceof Bomber && animal.getX() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.control_right.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.control_right_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.control_right.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.control_right_2.getFxImage());
                animal.setSwap(1);
            }
        }

        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballom_left_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballom_left_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballom_left_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballom_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_left_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_left_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_left_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_right_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_right_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_right_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Kondoria && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_right_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_right_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_right_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoria_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }
}
