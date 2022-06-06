package Entity.block;

import javafx.scene.image.Image;
import Entity.Entity;

public class Portal extends Entity {
    public static boolean is_portal = false;         // Variable used to display the portal when the player wins each level

    public Portal(int x, int y, Image img) {         // Create a contructor of the Portal class
        super(x, y, img);
    }

    @Override
    public void update() {

    }
}
