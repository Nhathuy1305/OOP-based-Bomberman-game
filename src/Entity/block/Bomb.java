package Entity.block;

import Entity.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.scene.image.Image;
import BombermanGame;
import control.Blocked;
import control.Menu;
import entities.Entity;
import graphics.Sprite;
import utility.SoundManager;

public class Bomb extends Entity {
    private static long time_bomb;     // Exploding time bomb 
    private static long time_tmp;       // Time between 2 bombings
    private static Entity bomb;        
    private static int swap_active = 1;     // Change the operational state of the bomb
    private static int swap_explosion = 1;      // Change bomb's explosive state
    private static final List<Entity> list_bomb_middle_width = new ArrayList();
    private static final List<Entity> list_bomb_middle_height = new ArrayList();
    public static int power_bomb = 0;       // Bomb's destructive power
    private static int power_bomb_down = 0;     // Bomb's destructive power from top to bottom
    private static int power_bomb_up = 0;       // The bomb's destructive power is from the bottom up
    private static int power_bomb_left = 0;     // Bomb's destructive power is from right to left
    private static int power_bomb_right = 0;    // The explosive power of the bomb is from left to right
    private static Entity edge_down = null;     // The bottom edge of the block blocks the character from going through
    private static Entity edge_up = null;       // The up edge of the block blocks the character from going through
    private static Entity edge_left = null;     // The left edge of the block blocks the character from going through
    private static Entity edge_right = null;    // The right edge of the block blocks the character from going through
    private static boolean is_edge = false;     // Check if that edge exists
    private static boolean is_middle = false;   // Check if the bomb explodes in the center (plus sign, not T )
    public static int is_bomb = 0;      // Check to see if there's a bomb there: //0 no bomb  //1 had bomb  //2 explosion

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    public static void putBomb() {      // The function used for the bomber to place the bomb
        if (is_bomb == 0 && Menu.bomb_number > 0) {
            --Menu.bomb_number;
            is_bomb = 1;
            time_bomb = System.currentTimeMillis();
            time_tmp = time_bomb;
            int x = BombermanGame.player.getX() / 32;
            int y = BombermanGame.player.getY() / 32;
            x = Math.round((float)x);
            y = Math.round((float)y);
            bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            BombermanGame.block.add(bomb);
            BombermanGame.idObjects[BombermanGame.player.getX() / 32][BombermanGame.player.getY() / 32] = 4;
        }

    }

    public static void activeBomb() {       // Show the animation from the time the bomb is placed to the time it explodes
        if (swap_active == 1) {
            bomb.setImg(Sprite.bomb.getFxImage());
            swap_active = 2;
        } 
        else if (swap_active == 2) {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swap_active = 3;
        } 
        else if (swap_active == 3) {
            bomb.setImg(Sprite.bomb_2.getFxImage());
            swap_active = 4;
        } 
        else {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swap_active = 1;
        }

    }

    public static void createEdge() {       // Create an egde to prevent the character's movement as well as the explosion range of the bomb
        int i;
        if (Blocked.blockDownBomb(bomb, 0)) {
            edge_down = new Bomb(bomb.getX() / 32, bomb.getY() / 32 + 1, Sprite.bomb_exploded.getFxImage());
            if (power_bomb > 0) {
                for(i = 1; i <= power_bomb && Blocked.blockDownBomb(bomb, i); ++i) {
                    edge_down.setY(bomb.getY() + 32 + i * 32);
                    ++power_bomb_down;
                }
            }

            BombermanGame.block.add(edge_down);
        }

        if (Blocked.blockUpBomb(bomb, 0)) {
            edge_up = new Bomb(bomb.getX() / 32, bomb.getY() / 32 - 1, Sprite.bomb_exploded.getFxImage());
            if (power_bomb > 0) {
                for(i = 1; i <= power_bomb && Blocked.blockUpBomb(bomb, i); ++i) {
                    edge_up.setY(bomb.getY() - 32 - i * 32);
                    ++power_bomb_up;
                }
            }

            BombermanGame.block.add(edge_up);
        }

        if (Blocked.blockLeftBomb(bomb, 0)) {
            edge_left = new Bomb(bomb.getX() / 32 - 1, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            if (power_bomb > 0) {
                for(i = 1; i <= power_bomb && Blocked.blockLeftBomb(bomb, i); ++i) {
                    edge_left.setX(bomb.getX() - 32 - i * 32);
                    ++power_bomb_left;
                }
            }

            BombermanGame.block.add(edge_left);
        }

        if (Blocked.blockRightBomb(bomb, 0)) {
            edge_right = new Bomb(bomb.getX() / 32 + 1, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            if (power_bomb > 0) {
                for(i = 1; i <= power_bomb && Blocked.blockRightBomb(bomb, i); ++i) {
                    edge_right.setX(bomb.getX() + 32 + i * 32);
                    ++power_bomb_right;
                }
            }

            BombermanGame.block.add(edge_right);
        }

    }

    public static void createMiddle() {     // Adjust the bomb to explode at the center position
        Bomb middle;
        int i;
        for(i = 1; i <= power_bomb_down; ++i) {
            middle = new Bomb(bomb.getX() / 32, bomb.getY() / 32 + i, Sprite.bomb_exploded.getFxImage());
            list_bomb_middle_height.add(middle);
        }

        for(i = 1; i <= power_bomb_up; ++i) {
            middle = new Bomb(bomb.getX() / 32, bomb.getY() / 32 - i, Sprite.bomb_exploded.getFxImage());
            list_bomb_middle_height.add(middle);
        }

        for(i = 1; i <= power_bomb_left; ++i) {
            middle = new Bomb(bomb.getX() / 32 - i, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            list_bomb_middle_width.add(middle);
        }

        for(i = 1; i <= power_bomb_right; ++i) {
            middle = new Bomb(bomb.getX() / 32 + i, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            list_bomb_middle_width.add(middle);
        }

        BombermanGame.block.addAll(list_bomb_middle_width);
        BombermanGame.block.addAll(list_bomb_middle_height);
    }

    public static void explosionCenter() {         // Determine the explosion center of the bomb 
        Entity e;
        Iterator var1;
        if (swap_explosion == 1) {
            bomb.setImg(Sprite.bomb_exploded.getFxImage());
            BombermanGame.listKill[bomb.getX() / 32][bomb.getY() / 32] = 4;
            if (Blocked.blockDownBomb(bomb, power_bomb_down)) {
                edge_down.setImg(Sprite.explosion_vertical_down_last.getFxImage());
                BombermanGame.listKill[edge_down.getX() / 32][edge_down.getY() / 32] = 4;
            }

            if (Blocked.blockUpBomb(bomb, power_bomb_up)) {
                edge_up.setImg(Sprite.explosion_vertical_top_last.getFxImage());
                BombermanGame.listKill[edge_up.getX() / 32][edge_up.getY() / 32] = 4;
            }

            if (Blocked.blockLeftBomb(bomb, power_bomb_left)) {
                edge_left.setImg(Sprite.explosion_horizontal_left_last.getFxImage());
                BombermanGame.listKill[edge_left.getX() / 32][edge_left.getY() / 32] = 4;
            }

            if (Blocked.blockRightBomb(bomb, power_bomb_right)) {
                edge_right.setImg(Sprite.explosion_horizontal_right_last.getFxImage());
                BombermanGame.listKill[edge_right.getX() / 32][edge_right.getY() / 32] = 4;
            }

            if (list_bomb_middle_height.size() > 0) {
                for(var1 = list_bomb_middle_height.iterator(); var1.hasNext(); BombermanGame.listKill[e.getX() / 32][e.getY() / 32] = 4) {
                    e = (Entity)var1.next();
                    e.setImg(Sprite.explosion_vertical.getFxImage());
                }
            }

            if (list_bomb_middle_width.size() > 0) {
                for(var1 = list_bomb_middle_width.iterator(); var1.hasNext(); BombermanGame.listKill[e.getX() / 32][e.getY() / 32] = 4) {
                    e = (Entity)var1.next();
                    e.setImg(Sprite.explosion_horizontal.getFxImage());
                }
            }

            swap_explosion = 2;
        } 
        else if (swap_explosion == 2) {
            bomb.setImg(Sprite.bomb_exploded1.getFxImage());
            if (Blocked.blockDownBomb(bomb, power_bomb_down)) {
                edge_down.setImg(Sprite.explosion_vertical_down_last1.getFxImage());
            }

            if (Blocked.blockUpBomb(bomb, power_bomb_up)) {
                edge_up.setImg(Sprite.explosion_vertical_top_last1.getFxImage());
            }

            if (Blocked.blockLeftBomb(bomb, power_bomb_left)) {
                edge_left.setImg(Sprite.explosion_horizontal_left_last1.getFxImage());
            }

            if (Blocked.blockRightBomb(bomb, power_bomb_right)) {
                edge_right.setImg(Sprite.explosion_horizontal_right_last1.getFxImage());
            }

            if (is_middle) {
                var1 = list_bomb_middle_height.iterator();

                while(var1.hasNext()) {
                    e = (Entity)var1.next();
                    e.setImg(Sprite.explosion_vertical1.getFxImage());
                }

                var1 = list_bomb_middle_width.iterator();

                while(var1.hasNext()) {
                    e = (Entity)var1.next();
                    e.setImg(Sprite.explosion_horizontal1.getFxImage());
                }
            }

            swap_explosion = 3;
        } 
        else if (swap_explosion == 3) {
            bomb.setImg(Sprite.bomb_exploded2.getFxImage());
            if (Blocked.blockDownBomb(bomb, power_bomb_down)) {
                edge_down.setImg(Sprite.explosion_vertical_down_last2.getFxImage());
            }

            if (Blocked.blockUpBomb(bomb, power_bomb_up)) {
                edge_up.setImg(Sprite.explosion_vertical_top_last2.getFxImage());
            }

            if (Blocked.blockLeftBomb(bomb, power_bomb_left)) {
                edge_left.setImg(Sprite.explosion_horizontal_left_last2.getFxImage());
            }

            if (Blocked.blockRightBomb(bomb, power_bomb_right)) {
                edge_right.setImg(Sprite.explosion_horizontal_right_last2.getFxImage());
            }

            if (is_middle) {
                var1 = list_bomb_middle_height.iterator();

                while(var1.hasNext()) {
                    e = (Entity)var1.next();
                    e.setImg(Sprite.explosion_vertical2.getFxImage());
                }

                var1 = list_bomb_middle_width.iterator();

                while(var1.hasNext()) {
                    e = (Entity)var1.next();
                    e.setImg(Sprite.explosion_horizontal2.getFxImage());
                }
            }

            swap_explosion = 1;
        }

    }

    private static void checkActive() {     // Check what stages the bomb has gone through before detonating
        if (is_bomb == 1) {
            if (System.currentTimeMillis() - time_bomb < 2000L) {
                if (System.currentTimeMillis() - time_tmp > 100L) {
                    activeBomb();
                    time_tmp += 100L;
                }
            } 
            else {
                is_bomb = 2;
                time_bomb = System.currentTimeMillis();
                time_tmp = time_bomb;
            }
        }

    }

    private static void checkExplosion() {      // Check the bomb's detonation time after the bomb is activated
        if (is_bomb == 2) {
            if (System.currentTimeMillis() - time_bomb < 1000L) {
                if (System.currentTimeMillis() - time_tmp > 100L) {
                    if (!is_edge) {
                        createEdge();
                        is_edge = true;
                    }

                    if (power_bomb > 0 && !is_middle) {
                        createMiddle();
                        is_middle = true;
                    }

                    new SoundManager("sound/bomb_explosion.wav", "explosion");
                    explosionCenter();
                    time_tmp += 100L;
                }
            } 
            else {
                is_bomb = 0;
                BombermanGame.idObjects[bomb.getX() / 32][bomb.getY() / 32] = 0;
                BombermanGame.listKill[bomb.getX() / 32][bomb.getY() / 32] = 0;
                bomb.setImg(Sprite.transparent.getFxImage());
                if (Blocked.blockDownBomb(bomb, power_bomb_down)) {
                    edge_down.setImg(Sprite.transparent.getFxImage());
                    BombermanGame.idObjects[edge_down.getX() / 32][edge_down.getY() / 32] = 0;
                    BombermanGame.listKill[edge_down.getX() / 32][edge_down.getY() / 32] = 0;
                }

                if (Blocked.blockUpBomb(bomb, power_bomb_up)) {
                    edge_up.setImg(Sprite.transparent.getFxImage());
                    BombermanGame.idObjects[edge_up.getX() / 32][edge_up.getY() / 32] = 0;
                    BombermanGame.listKill[edge_up.getX() / 32][edge_up.getY() / 32] = 0;
                }

                if (Blocked.blockLeftBomb(bomb, power_bomb_left)) {
                    edge_left.setImg(Sprite.transparent.getFxImage());
                    BombermanGame.idObjects[edge_left.getX() / 32][edge_left.getY() / 32] = 0;
                    BombermanGame.listKill[edge_left.getX() / 32][edge_left.getY() / 32] = 0;
                }

                if (Blocked.blockRightBomb(bomb, power_bomb_right)) {
                    edge_right.setImg(Sprite.transparent.getFxImage());
                    BombermanGame.idObjects[edge_right.getX() / 32][edge_right.getY() / 32] = 0;
                    BombermanGame.listKill[edge_right.getX() / 32][edge_right.getY() / 32] = 0;
                }

                if (is_middle) {
                    Entity e;
                    Iterator var1;
                    for(var1 = list_bomb_middle_width.iterator(); var1.hasNext(); BombermanGame.idObjects[e.getX() / 32][e.getY() / 32] = 0) {
                        e = (Entity)var1.next();
                        BombermanGame.listKill[e.getX() / 32][e.getY() / 32] = 0;
                    }

                    for(var1 = list_bomb_middle_height.iterator(); var1.hasNext(); BombermanGame.idObjects[e.getX() / 32][e.getY() / 32] = 0) {
                        e = (Entity)var1.next();
                        BombermanGame.listKill[e.getX() / 32][e.getY() / 32] = 0;
                    }
                }

                BombermanGame.block.removeAll(list_bomb_middle_height);
                BombermanGame.block.removeAll(list_bomb_middle_width);
                list_bomb_middle_height.clear();
                list_bomb_middle_width.clear();
                is_edge = false;
                is_middle = false;
                power_bomb_down = 0;
                power_bomb_up = 0;
                power_bomb_left = 0;
                power_bomb_right = 0;
            }
        }

    }

    public void update() {
        checkActive();
        checkExplosion();
    }
}