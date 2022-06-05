
import javafx.scene.image.Image;
import entities.animal.Animal;
import entities.animal.Ballom;
import entities.animal.Oneal;
import graphics.CreateMap;
import graphics.Sprite;

import static BombermanGame.*;

import static entities.block.Bomb.power_bomb;
import static control.Menu.bomb_number;
import static control.Menu.time_number;
import static entities.animal.Bomber.swap_kill;
import static entities.block.Bomb.is_bomb;
import static entities.item.SpeedItem.speed;
import static utility.SoundManager.is_sound_died;
import static utility.SoundManager.is_sound_title;

public class Level1 {
    public Level1() {
        // clear all enemy if u play again from level 1
        enemy.clear();
        block.clear();
        swap_kill = 1;
        power_bomb = 0;
        new CreateMap("res/levels/Level1.txt");
        player.setLife(true);
        player.setX(32);
        player.setY(32);
        is_sound_died = false;
        is_sound_title = false;
        time_number = 120;
        bomb_number = 20;
        isBomb = 0;
        speed = 1;

        // load authorView Scr
        player.setImg(Sprite.player_right_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        author_view.setImage(transparent);

        // load all enemy coordinate in level 1
        Animal enemy1 = new Ballom(4, 4, Sprite.ballom_left1.getFxImage());
        Animal enemy2 = new Ballom(9, 9, Sprite.ballom_left1.getFxImage());
        Animal enemy3 = new Ballom(22, 6, Sprite.ballom_left1.getFxImage());
        enemy.add(enemy1);
        enemy.add(enemy2);
        enemy.add(enemy3);

        Animal enemy4 = new Oneal(7, 6, Sprite.oneal_right1.getFxImage());
        Animal enemy5 = new Oneal(13, 8, Sprite.oneal_right1.getFxImage());
        enemy.add(enemy4);
        enemy.add(enemy5);

        // set default for enemy
        for (Animal animal : enemy) {
            animal.setLife(true);
        }
    }
}