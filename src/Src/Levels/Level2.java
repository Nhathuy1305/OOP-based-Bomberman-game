
import javafx.scene.image.Image;
import entities.animal.Animal;
import entities.animal.Ballom;
import entities.animal.Kondoria;
import entities.animal.Oneal;
import graphics.createMap;
import graphics.Sprite;

import static BombermanGame.*;
import static BombermanGame.enemy;
import static control.Menu.bomb_number;
import static control.Menu.time_number;
import static entities.animal.Bomber.swap_kill;
import static entities.block.Bomb.is_bomb;
import static entities.item.SpeedItem.speed;
import static utility.SoundManager.is_sound_died;
import static utility.SoundManager.is_sound_title;

public class Level2 {
    public Level2() {
        enemy.clear();
        block.clear();
        swap_kill = 1;
        new CreateMap("res/levels/Level2.txt");
        player.setLife(true);
        player.setX(32);
        player.setY(32);
        speed = 1;
        is_sound_died = false;
        is_sound_title = false;
        time_number = 120;
        bomb_number = 30;
        is_bomb = 0;

        player.setImg(Sprite.player_right_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        author_view.setImage(transparent);

        Animal enemy1 = new Ballom(5, 5, Sprite.ballom_left1.getFxImage());
        Animal enemy2 = new Ballom(11, 9, Sprite.ballom_left1.getFxImage());
        enemy.add(enemy1);
        enemy.add(enemy2);

        Animal enemy3 = new Kondoria(1, 3, Sprite.kondoria_right1.getFxImage());
        Animal enemy4 = new Kondoria(1, 7, Sprite.kondoria_right1.getFxImage());
        Animal enemy5 = new Kondoria(1, 11, Sprite.kondoria_right1.getFxImage());
        enemy.add(enemy3);
        enemy.add(enemy4);
        enemy.add(enemy5);

        Animal enemy6 = new Oneal(7, 5, Sprite.oneal_right1.getFxImage());
        Animal enemy7 = new Oneal(19, 7, Sprite.oneal_right1.getFxImage());
        enemy.add(enemy6);
        enemy.add(enemy7);

        for (Animal animal : enemy) {
            animal.setLife(true);
        }
    }
}
