package Entity.items;

import javafx.scene.image.Image;
import Entity.Entity;

public abstract class Items extends Entity {

    protected boolean received = false;

    public Items(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Items() {
    }

    public Items(boolean received) {
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    @Override
    public void update() {

    }
}
