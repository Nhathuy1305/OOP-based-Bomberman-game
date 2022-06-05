
import javafx.scene.image.Image;
import entities.Entity;
import graphics.Sprite;

import static BombermanGame.*;

public class SpeedItem extends Items {
    public static int speed = 1;

    public SpeedItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public SpeedItem() {
    }

    public SpeedItem(boolean received) {
        super(received);
    }

    // Enhance the speed of player if a player gets the item
    @Override
    public void update() {
        for (Entity entity : block)
            if (entity instanceof SpeedItem && !this.received)
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerup_speed.getFxImage());

        if (!this.received)
            if (player.getX() == this.x && player.getY() == this.y) {
                this.setImg(Sprite.grass.getFxImage());
                this.received = true;
                speed = 2;
            }
    }
}
