package Levels;

import javafx.scene.image.Image;
import Entity.animal.Animal;
import Entity.animal.Oneal;
import Entity.animal.Ballom;
import Graphics.MapCreation;
import Graphics.Sprite;

import static GameRunner.RunBomberman.*;

import static Control.Menu.bomb_number;
import static Control.Menu.time_number;
import static Entity.animal.Bomber.swap_kill;
import static Entity.block.Bomb.is_bomb;
import static Entity.block.Bomb.power_bomb;
import static Entity.items.SpeedItem.speed;
import static Features.SoundManager.is_sound_died;
import static Features.SoundManager.is_sound_title;

public class Level1 {
    public Level1() {
        // clear all enemy if u play again from level 1
        enemy.clear();
        block.clear();
        swap_kill = 1;
        power_bomb = 0;
        new MapCreation("res/levels/Level1.txt");
        player.setLife(true);
        player.setX(32);
        player.setY(32);
        is_sound_died = false;
        is_sound_title = false;
        time_number = 120;
        bomb_number = 20;
        is_bomb = 0;
        speed = 1;

        // load authorView Scr
        player.setImg(Sprite.control_right_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        author_view.setImage(transparent);

        Animal enemy1 = new Ballom(4, 4, Sprite.ballom_left_1.getFxImage());
        Animal enemy2 = new Ballom(9, 9, Sprite.ballom_left_1.getFxImage());
        Animal enemy3 = new Ballom(22, 6, Sprite.ballom_left_1.getFxImage());
        enemy.add(enemy1);
        enemy.add(enemy2);
        enemy.add(enemy3);

        Animal enemy4 = new Oneal(7, 6, Sprite.oneal_right_1.getFxImage());
        Animal enemy5 = new Oneal(13, 8, Sprite.oneal_right_1.getFxImage());
        enemy.add(enemy4);
        enemy.add(enemy5);

        // set default for enemy
        for (Animal animal : enemy) {
            animal.setLife(true);
        }
    }
}