package Entity;

import Graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Entity {
    protected int x;
    protected int y;
    protected Image img;

    
    public Entity(int x_unit, int y_unit, Image img) {
        this.x = x_unit * Sprite.SCALED_SIZE;
        this.y = y_unit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public Entity() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void render(GraphicsContext gc) {    // Using to render the frame of the game
        gc.drawImage(img, x, y);
    }

    public abstract void update();
}
