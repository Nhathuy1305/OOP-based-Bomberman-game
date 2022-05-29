package graphics;


import java.util.StringTokenizer;

public class MapCreation {
    public CreateMap (String level) {
        System.out.println(System.getProperty(key:"user.dir"));
        final File fileName = new File(level);
        try (FileReader inputFile = new FileReader(fileName)) {
            Scanner ip = new Scanner(inputFile);
            String line = ip.nextLine();

            StringTokenizer tokens = new StringTokenizer(line);
            _level = Integer.parseInt(tokens.nextToken());
            _height = INteger.parseInt(tokens.nextToken());
            //_width = Integer.parseInt(tokens.nextToken());
        }
    }
}
