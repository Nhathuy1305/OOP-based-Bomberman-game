package Graphics;

import javafx.scene.image.*;

public class Sprite {
    public static final int ORIGINAL_SIZE = 16;                 // Create original Size
    public static final int SCALED_SIZE = ORIGINAL_SIZE * 2;    // Create scaled size = original size * 2
    private static final int TRANSPARENT_COLOR = -65281;        // Declare transparent color
    public final int SIZE;
    private int x, y;
    public int[] pixels;
    protected int real_width;
    protected int real_height;
    private SpriteSheet sheet;

    // This function is used to load the animation and image in pixels * SIZE in pixels
    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.sprite_pixels[(x + this.x) + (y + this.y) * this.sheet.SIZE];
            }
        }
    }

    // Constructor to create object from Sprite
    public Sprite(int SIZE, int x, int y, int real_width, int real_height, SpriteSheet sheet) {
        this.SIZE = SIZE;
        this.x = x * this.SIZE;
        this.y = y * this.SIZE;
        this.real_width = real_width;
        this.real_height = real_height;
        this.sheet = sheet;
        pixels = new int[this.SIZE * this.SIZE];
        load();
    }


    // This object creates transparent color in the outline of the interface.
    public static Sprite transparent = new Sprite(ORIGINAL_SIZE, 15, 15, 16, 16, SpriteSheet.tiles);

    /* Board: Create object grass, brick, portal, wall in game */
    public static Sprite grass = new Sprite(ORIGINAL_SIZE, 6, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite brick = new Sprite(ORIGINAL_SIZE, 7, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite portal = new Sprite(ORIGINAL_SIZE, 4, 0, 14, 14, SpriteSheet.tiles);
    public static Sprite wall = new Sprite(ORIGINAL_SIZE, 5, 0, 16, 16, SpriteSheet.tiles);

    /* Bomber: to create object control when player move in 4 directions: up, down, right, and left */
    public static Sprite control_up = new Sprite(ORIGINAL_SIZE, 0, 0, 12, 16, SpriteSheet.tiles);
    public static Sprite control_down = new Sprite(ORIGINAL_SIZE, 2, 0, 12, 15, SpriteSheet.tiles);
    public static Sprite control_right = new Sprite(ORIGINAL_SIZE, 1, 0, 10, 16, SpriteSheet.tiles);
    public static Sprite control_left = new Sprite(ORIGINAL_SIZE, 3, 0, 10, 15, SpriteSheet.tiles);

    public static Sprite control_up_1 = new Sprite(ORIGINAL_SIZE, 0, 1, 12, 16, SpriteSheet.tiles);
    public static Sprite control_up_2 = new Sprite(ORIGINAL_SIZE, 0, 2, 12, 15, SpriteSheet.tiles);

    public static Sprite control_down_1 = new Sprite(ORIGINAL_SIZE, 2, 1, 12, 15, SpriteSheet.tiles);
    public static Sprite control_down_2 = new Sprite(ORIGINAL_SIZE, 2, 2, 12, 16, SpriteSheet.tiles);

    public static Sprite control_right_1 = new Sprite(ORIGINAL_SIZE, 1, 1, 11, 16, SpriteSheet.tiles);
    public static Sprite control_right_2 = new Sprite(ORIGINAL_SIZE, 1, 2, 12, 16, SpriteSheet.tiles);

    public static Sprite control_left_1 = new Sprite(ORIGINAL_SIZE, 3, 1, 11, 16, SpriteSheet.tiles);
    public static Sprite control_left_2 = new Sprite(ORIGINAL_SIZE, 3, 2, 12, 16, SpriteSheet.tiles);

    /* Death: Create object when player dead */
    public static Sprite player_dead_1 = new Sprite(ORIGINAL_SIZE, 4, 2, 14, 16, SpriteSheet.tiles);
    public static Sprite player_dead_2 = new Sprite(ORIGINAL_SIZE, 5, 2, 13, 15, SpriteSheet.tiles);
    public static Sprite player_dead_3 = new Sprite(ORIGINAL_SIZE, 6, 2, 16, 16, SpriteSheet.tiles);


    /* Character/Enemy: Create an object for each enemy and follow up on the movement direction */

    // BALLOM
    public static Sprite ballom_right_1 = new Sprite(ORIGINAL_SIZE, 10, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite ballom_right_2 = new Sprite(ORIGINAL_SIZE, 10, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite ballom_right_3 = new Sprite(ORIGINAL_SIZE, 10, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite ballom_left_1 = new Sprite(ORIGINAL_SIZE, 9, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite ballom_left_2 = new Sprite(ORIGINAL_SIZE, 9, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite ballom_left_3 = new Sprite(ORIGINAL_SIZE, 9, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite ballom_dead = new Sprite(ORIGINAL_SIZE, 9, 3, 16, 16, SpriteSheet.tiles);

    // ONEAL
    public static Sprite oneal_right_1 = new Sprite(ORIGINAL_SIZE, 12, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite oneal_right_2 = new Sprite(ORIGINAL_SIZE, 12, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite oneal_right_3 = new Sprite(ORIGINAL_SIZE, 12, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite oneal_left_1 = new Sprite(ORIGINAL_SIZE, 11, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite oneal_left_2 = new Sprite(ORIGINAL_SIZE, 11, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite oneal_left_3 = new Sprite(ORIGINAL_SIZE, 11, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite oneal_dead = new Sprite(ORIGINAL_SIZE, 11, 3, 16, 16, SpriteSheet.tiles);

    // DOLL
    public static Sprite doll_right_1 = new Sprite(ORIGINAL_SIZE, 14, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite doll_right_2 = new Sprite(ORIGINAL_SIZE, 14, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite doll_right_3 = new Sprite(ORIGINAL_SIZE, 14, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite doll_left_1 = new Sprite(ORIGINAL_SIZE, 13, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite doll_left_2 = new Sprite(ORIGINAL_SIZE, 13, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite doll_left_3 = new Sprite(ORIGINAL_SIZE, 13, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite doll_dead = new Sprite(ORIGINAL_SIZE, 13, 3, 16, 16, SpriteSheet.tiles);

    // MINVO
    public static Sprite minvo_right_1 = new Sprite(ORIGINAL_SIZE, 9, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite minvo_right_2 = new Sprite(ORIGINAL_SIZE, 9, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite minvo_right_3 = new Sprite(ORIGINAL_SIZE, 9, 7, 16, 16, SpriteSheet.tiles);

    public static Sprite minvo_left_1 = new Sprite(ORIGINAL_SIZE, 8, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite minvo_left_2 = new Sprite(ORIGINAL_SIZE, 8, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite minvo_left_3 = new Sprite(ORIGINAL_SIZE, 8, 7, 16, 16, SpriteSheet.tiles);

    public static Sprite minvo_dead = new Sprite(ORIGINAL_SIZE, 8, 8, 16, 16, SpriteSheet.tiles);

    // KONDORIA
    public static Sprite kondoria_right_1 = new Sprite(ORIGINAL_SIZE, 11, 5, 16 ,16, SpriteSheet.tiles);
    public static Sprite kondoria_right_2 = new Sprite(ORIGINAL_SIZE, 11, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite kondoria_right_3 = new Sprite(ORIGINAL_SIZE, 11, 7, 16, 16, SpriteSheet.tiles);

    public static Sprite kondoria_left_1 = new Sprite(ORIGINAL_SIZE, 10, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite kondoria_left_2 = new Sprite(ORIGINAL_SIZE, 10, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite kondoria_left_3 = new Sprite(ORIGINAL_SIZE, 10, 7, 16, 16, SpriteSheet.tiles);

    public static Sprite kondoria_dead = new Sprite(ORIGINAL_SIZE, 10, 8, 16, 16, SpriteSheet.tiles);

    // ALL
    public static Sprite mob_dead_1 = new Sprite(ORIGINAL_SIZE, 15, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite mob_dead_2 = new Sprite(ORIGINAL_SIZE, 15, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite mob_dead_3 = new Sprite(ORIGINAL_SIZE, 15, 2, 16, 16, SpriteSheet.tiles);

    /* BOMB SPRITES */
    public static Sprite bomb = new Sprite(ORIGINAL_SIZE, 0, 3, 15, 15, SpriteSheet.tiles);
    public static Sprite bomb_1 = new Sprite(ORIGINAL_SIZE, 1, 3, 13, 15, SpriteSheet.tiles);
    public static Sprite bomb_2 = new Sprite(ORIGINAL_SIZE, 2, 3, 12, 14, SpriteSheet.tiles);

    /* FlameSegment Sprites: Create object bomb flame, default range is 2px to the vertical and horizontal, begin in the center position */
    public static Sprite bomb_exploded = new Sprite(ORIGINAL_SIZE, 0, 4, 16, 16, SpriteSheet.tiles);
    public static Sprite bomb_exploded_1 = new Sprite(ORIGINAL_SIZE, 0, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite bomb_exploded_2 = new Sprite(ORIGINAL_SIZE, 0, 6, 16, 16, SpriteSheet.tiles);

    public static Sprite explosion_vertical = new Sprite(ORIGINAL_SIZE, 1, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_vertical_1 = new Sprite(ORIGINAL_SIZE, 2, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_vertical_2 = new Sprite(ORIGINAL_SIZE, 3, 5, 16, 16, SpriteSheet.tiles);

    public static Sprite explosion_horizontal = new Sprite(ORIGINAL_SIZE, 1, 7, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_1 = new Sprite(ORIGINAL_SIZE, 1, 8, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_2 = new Sprite(ORIGINAL_SIZE, 1, 9, 16, 16, SpriteSheet.tiles);

    public static Sprite explosion_horizontal_left_last = new Sprite(ORIGINAL_SIZE, 0, 7 ,16, 16, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_left_last_1 = new Sprite(ORIGINAL_SIZE, 0, 8, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_left_last_2 = new Sprite(ORIGINAL_SIZE, 0, 9, 16, 16, SpriteSheet.tiles);

    public static Sprite explosion_horizontal_right_last = new Sprite(ORIGINAL_SIZE, 2, 7 ,16, 16, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_right_last_1 = new Sprite(ORIGINAL_SIZE, 2, 8, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_horizontal_right_last_2 = new Sprite(ORIGINAL_SIZE, 2, 9, 16, 16, SpriteSheet.tiles);

    public static Sprite explosion_vertical_top_last = new Sprite(ORIGINAL_SIZE, 1, 4, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_vertical_top_last_1 = new Sprite(ORIGINAL_SIZE, 2, 4, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_vertical_top_last_2 = new Sprite(ORIGINAL_SIZE, 3, 4, 16, 16, SpriteSheet.tiles);

    public static Sprite explosion_vertical_down_last = new Sprite(ORIGINAL_SIZE, 1, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_vertical_down_last_1 = new Sprite(ORIGINAL_SIZE, 2, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_vertical_down_last_2 = new Sprite(ORIGINAL_SIZE, 3, 6, 16, 16, SpriteSheet.tiles);

    /* Powerups: Flame segment when the bomber get the power items */
    public static Sprite powerup_flames = new Sprite(ORIGINAL_SIZE, 1, 10, 16, 16, SpriteSheet.tiles);
    public static Sprite powerup_speed = new Sprite(ORIGINAL_SIZE, 2, 10, 16, 16, SpriteSheet.tiles);

    // Setter color
    private void setColor(int color) {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    // Constructor Sprite(int, int)
    public Sprite(int SIZE, int color) {
        this.SIZE = SIZE;
        pixels = new int[this.SIZE * this.SIZE];
        setColor(color);
    }

    // This function is used to set the game in transparent_color by set Argb color.
    public Image getFxImage() {
        WritableImage wr = new WritableImage(SIZE, SIZE);
        PixelWriter pw = wr.getPixelWriter();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (pixels[x + y * SIZE] == TRANSPARENT_COLOR) {
                    pw.setArgb(x, y, 0);
                } else {
                    pw.setArgb(x, y, pixels[x + y * SIZE]);
                }
            }
        }
        Image input = new ImageView(wr).getImage();
        return resample(input, SCALED_SIZE / ORIGINAL_SIZE);
    }

    // Resample to read the argb color
    private Image resample(Image input, int scaleFactor) {
        final int H = (int) input.getHeight();
        final int W = (int) input.getWidth();
        final int S = scaleFactor;

        WritableImage output = new WritableImage(W * S, H * S);

        PixelReader reader = input.getPixelReader();
        PixelWriter writer = output.getPixelWriter();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                final int argb = reader.getArgb(j, i);
                for (int k = 0; k < S; k++) {
                    for (int l = 0; l < S; l++)
                        writer.setArgb(j * S + l, i * S + k, argb);
                }
            }
        }
        return output;
    }
}
