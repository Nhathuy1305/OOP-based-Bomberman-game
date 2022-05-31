package graphics;


import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MapCreation {
    public CreateMap (String level) {
        System.out.println(System.getProperty(key:"user.dir"));
        final File fileName = new File(level);
        try (FileReader inputFile = new FileReader(fileName)) {
            Scanner ip = new Scanner(inputFile);
            String line = ip.nextLine();

            StringTokenizer tokens = new StringTokenizer(line);
            level = Integer.parseInt(tokens.nextToken());
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());

            while (ip.hasNextLine()) {
                idObjects = new int[width][height];
                listKill = new int[width][height];
                for (int i = 0; i < height; ++i) {
                    String lineTile = ip.nextLine();
                    StringTokenizer tokenTile = new StringTokenizer(lineTile);

                    for (int j = 0; j < width; j++) {
                        int token = Integer.parseInt(tokenTile.nextToken());
                        Entity entity;

                        switch (token) {
                            case 1:
                                entity = new Portal(j, i, Sprite.grass.getFxImage());
                                token = 0;
                                break;
                            case 2:
                                entity = new Wall(j, i, Sprite.wall.getFxImage());
                                break;
                            case 3:
                                entity = new Brick(j, i, Sprite.brick.getFxImage());
                                break;
                            case 6:
                                entity = new SpeedItem(j, i, Sprite.brick.getFxImage());
                                break;
                            case 7:
                                entity = new FlameItem(j, i, Sprite.brick.getFxImage());
                                break;
                            default:
                                entity = new Grass(j, i, Sprite.grass.getFxImage());
                        }
                        idObjects[j][i] = token;
                        block.add(entity);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
