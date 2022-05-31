package Entity.animal;

import java.util.List;

public class Doll extends Animal{
    private static int swapKill = 1;
    private static int countKill = 0;

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
        if (countKill % 16 == 0) {
            if (swapKill == 1) {
                animal.setImg(Sprite.doll_dead.getFxImage());
                swapKill = 2;
            } else if (swapKill == 2) {
                animal.setImg(Sprite.player_dead3.getFxImage());
                swapKill = 3;
            } else {
                animal.setLife(false);
                enemy.remove(animal);
                swapKill = 1;
            }
        }
    }

    private void moveDoll() {
        if (this.x % 32 == 0 && this.y %32 == 0) {
            Node initialNode = new Node(this.y / 32, this.x / 32);
            Node finalNode = new Node(player.getY() / 32, player.getX() / 32);

            int rows = height;
            int cols = width;

            AStar aStar = new AStar(rows, cols, initialNode, finalNode);

            int[][] blocksInArray = new int[width * height][2];
            int countBlock = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (idObjects[j][i] != 0) {
                        blocksInArray[countBlock][0] = i;
                        blocksInArray[countBlock][1] = j;
                        countBlock++;
                    }
                }
            }
            aStar.setBlocks(blocksInArray, countBlock);
            List<Node> path = aStar.findPath();
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
        countKill++;
        for (Animal animal:enemy) {
            if (animal instanceof Doll && !animal.life)
                killDoll(animal);
        }
        moveDoll();
    }
}
