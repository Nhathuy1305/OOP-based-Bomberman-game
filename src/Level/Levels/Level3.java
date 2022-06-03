
import javafx.scene.image.Image;
import entities.animal.Animal;
import entities.animal.Ballom;
import entities.animal.Doll;
import graphics.CreateMap;
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

public class Level3 {
    public Level3() {
        enemy.clear();
        block.clear();
        swap_kill = 1;
        new CreateMap("res/levels/Level3.txt");
        player.setLife(true);
        player.setX(32);
        player.setY(32);
        speed = 1;
        is_sound_died = false;
        is_sound_title = false;
        time_number = 120;
        bomb_number = 40;
        is_bomb = 0;

        player.setImg(Sprite.player_right_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        author_view.setImage(transparent);

        Animal enemy1 = new Ballom(5, 5, Sprite.ballom_left1.getFxImage());
        Animal enemy2 = new Ballom(11, 9, Sprite.ballom_left1.getFxImage());
        enemy.add(enemy1);
        enemy.add(enemy2);

        Animal enemy3 = new Doll(7, 5, Sprite.doll_left1.getFxImage());
        enemy.add(enemy3);

        for (Animal animal : enemy) {
            animal.setLife(true);
        }
    }
}
