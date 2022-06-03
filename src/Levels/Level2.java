package Levels;

import javafx.scene.image.Image;
import Entity.animal.Animal;
import Entity.animal.Oneal;
import Entity.animal.Ballom;
import Entity.animal.Kondoria;
import Graphics.MapCreation;
import Graphics.Sprite;

import static GameRunner.RunBomberman.*;

import static GameRunner.RunBomberman.enemy;
import static Control.Menu.bomb_number;
import static Control.Menu.time_number;
import static Entity.animal.Bomber.swap_kill;
import static Entity.block.Bomb.is_bomb;
import static Entity.items.SpeedItem.speed;
import static Features.SoundManager.is_sound_died;
import static Features.SoundManager.is_sound_title;

public class Level2 {
    public Level2() {
        enemy.clear();
        block.clear();
        swap_kill = 1;
        new MapCreation("res/levels/Levels.Level2.txt");
        player.setLife(true);
        player.setX(32);
        player.setY(32);
        speed = 1;
        is_sound_died = false;
        is_sound_title = false;
        time_number = 120;
        bomb_number = 30;
        is_bomb = 0;

        player.setImg(Sprite.control_right_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        author_view.setImage(transparent);

        Animal enemy1 = new Ballom(5, 5, Sprite.ballom_left_1.getFxImage());
        Animal enemy2 = new Ballom(11, 9, Sprite.ballom_left_1.getFxImage());
        enemy.add(enemy1);
        enemy.add(enemy2);

        Animal enemy3 = new Kondoria(1, 3, Sprite.kondoria_right_1.getFxImage());
        Animal enemy4 = new Kondoria(1, 7, Sprite.kondoria_right_1.getFxImage());
        Animal enemy5 = new Kondoria(1, 11, Sprite.kondoria_right_1.getFxImage());
        enemy.add(enemy3);
        enemy.add(enemy4);
        enemy.add(enemy5);

        Animal enemy6 = new Oneal(7, 5, Sprite.oneal_right_1.getFxImage());
        Animal enemy7 = new Oneal(19, 7, Sprite.oneal_right_1.getFxImage());
        enemy.add(enemy6);
        enemy.add(enemy7);

        for (Animal animal : enemy) {
            animal.setLife(true);
        }
    }
}
