package Entity.animal;

import Entity.animal.Animal;

public class Oneal extends Animal {
    private static int swap_kill = 1;
    private static int count_kill = 0;

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    public Oneal(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public Oneal(boolean life) {
        super(life);
    }

    public Oneal() {
    }

    private void killOneal(Animal animal) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                animal.setImg(Sprite.oneal_dead.getFxImage());
                swap_kill = 2;
            } 
            else if (swap_kill == 2) {
                animal.setImg(Sprite.player_dead3.getFxImage());
                swap_kill = 3;
            } 
            else {
                animal.setLife(false);
                enemy.remove(animal);
                swap_kill = 1;
            }
        }
    }

    @Override
    public void update() {
        count_kill++;
        for (Animal animal : enemy) {
            if (animal instanceof Oneal && !animal.life)
                killOneal(animal);
        }

        if (this.y % 16 == 0 && this.x % 16 == 0) {
            if (player.getX() < this.x) {
                Move.left(this);
            }
            if (player.getX() > this.x) {
                Move.right(this);
            }
            if (player.getY() > this.y) {
                Move.down(this);
            }
            if (player.getY() < this.y) {
                Move.up(this);
            }
        }
    }
}
