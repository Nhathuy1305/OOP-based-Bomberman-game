
import javafx.scene.image.Image;

import static BombermanGame._level;
import static BombermanGame.author_view;
import static entities.block.Portal.is_portal;

public class NextLevel {
    public static boolean wait;
    public static long waiting_time;

    public static void waitToLevelUp() {
        if (wait) {
            Image wait_to_next = new Image("images/levelUp.png");
            // add image level up to authorView
            author_view.setImage(wait_to_next);
            // load next Level
            long now = System.currentTimeMillis();
            if (now - waiting_time > 3000) {
                switch (_level) {
                    case 1:
                        is_portal = false;
                        new Level2();
                        break;
                    case 2:
                        new Level3();
                        break;
                    case 3:
                        new Level1();
                }
                wait = false;
            }
        }
    }
}
