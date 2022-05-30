package Entity.animal;

import javafx.scene.image.Image;
import Entity.animal.Animal;

public class Bomber extends Animal {
    public static int swap_kill = 1;
    private static int count_kill = 0;

    public Bomber(int is_move, int swap, String direction, int count, int count_to_run) {
        super(8, 1, "down", 0, 0);
    }

    public Bomber() {
        
    }

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    private void killBomber(Animal animal) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                animal.setImg(Sprite.player_dead1.getFxImage());
                swap_kill = 2;
            } else if (swap_kill == 2) {
                animal.setImg(Sprite.player_dead2.getFxImage());
                swap_kill = 3;
            } else if (swap_kill == 3) {
                animal.setImg(Sprite.player_dead3.getFxImage());
                swap_kill = 4;
            } else {
                animal.setImg(Sprite.transparent.getFxImage());
                running = false;
                Image gameOver = new Image("images/gameOver.png");
                authorView.setImage(gameOver);
            }
        }
    }

    private void checkBombs() {
        if (listKill[player.getX() / 32][player.getY() / 32] == 4)
            player.setLife(false);
    }

    private void checkEnemy1() {
        int ax = player.getX() / 32;
        int ay = player.getY() / 32;
        for (Animal animal : enemy) {
            int bx = animal.getX() / 32;
            int by = animal.getY() / 32;
            if (
                ax == bx && ay == by
                || ax == bx && ay == by + 1
                || ax == bx && ay == by - 1
                || ay == by && ax == bx + 1
                || ay == by && ax == bx - 1
            ) 
            {
                player.life = false;
                break;
            }
        }
    }

    private void checkEnemy2() {    //easy level
        int ax = player.getX();
        int ay = player.getY();
        for (Animal animal : enemy)
            if (
                ax == animal.getX() && ay == animal.getY()
                || ax == animal.getX() && ay == animal.getY() - 32
                || ax == animal.getX() && ay == animal.getY() + 32
                || ay == animal.getY() && ax == animal.getX() - 32
                || ay == animal.getY() && ax == animal.getX() + 32
            )
            {
                player.life = false;
                break;
            }
    }

    private void checkEnemy3() {
        int ax = player.getX();
        int ay = player.getY();
        for (Animal animal : enemy) {
            int bx = animal.getX();
            int by = animal.getY();
            if (
                ax == bx && by - 32 <= ay && by + 32 >= ay
                || ay == by && bx - 32 <= ax && bx + 32 >= ax
            ) 
            {
                player.life = false;
                break;
            }
        }
    }

    @Override
    public void update() {
        checkBombs();
        checkEnemy3();
        count_kill++;
        if (!player.life)
            killBomber(player);
    }
}
