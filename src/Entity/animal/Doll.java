package Entity.animal;

import java.util.List;

import Control.Move;
import Entity.animal.intelligent.AStar;
import Entity.animal.intelligent.Node;
import Graphics.Sprite;
import javafx.scene.image.Image;

import static GameRunner.RunBomberman.*;

public class Doll extends Animal{
    private static int swap_kill = 1;
    private static int count_kill = 0;

    public Doll(int x_unit, int y_unit, Image img) {
        super(x_unit, y_unit, img);
    }

    public Doll(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public Doll(boolean life) {
        super(life);
    }

    public Doll() {

    }

    private void killDoll(Animal animal) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                animal.setImg(Sprite.doll_dead.getFxImage());
                swap_kill = 2;
            } else if (swap_kill == 2) {
                animal.setImg(Sprite.player_dead3.getFxImage());
                swap_kill = 3;
            } else {
                animal.setLife(false);
                enemy.remove(animal);
                swap_kill = 1;
            }
        }
    }

    private void moveDoll() {
        if (this.x % 32 == 0 && this.y %32 == 0) {
            Node initial_node = new Node(this.y / 32, this.x / 32);
            Node final_node = new Node(player.getY() / 32, player.getX() / 32);

            int rows = height;
            int cols = width;

            AStar a_star = new AStar(rows, cols, initial_node, final_node);

            int[][] blocks_in_array = new int[width * height][2];
            int count_block = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (id_ojects[j][i] != 0) {
                        blocks_in_array[count_block][0] = i;
                        blocks_in_array[count_block][1] = j;
                        count_block++;
                    }
                }
            }
            a_star.setBlocks(blocks_in_array, count_block);
            List<Node> path = a_star.findPath();
            if (path.size() != 0) {
                int nextX = path.get(1).getCol();
                int nextY = path.get(1).getRow();

                if (this.y / 32 > nextY)
                    Move.up(this);
                if (this.y / 32 < nextY)
                    Move.down(this);
                if (this.x / 32 > nextX)
                    Move.left(this);
                if (this.x / 32 < nextX)
                    Move.right(this);
            }
        }
    }

    @Override
    public void update() {
        count_kill++;
        for (Animal animal:enemy) {
            if (animal instanceof Doll && !animal.life)
                killDoll(animal);
        }
        moveDoll();
    }
}
