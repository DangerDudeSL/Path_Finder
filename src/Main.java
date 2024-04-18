import java.io.File;
import java.util.Scanner;

public class Main {
    public static final char EMPTY = '.';
    public static final char START = 'S';
    public static final char FINISH = 'F';
    public static final char ROCK = '0';
    public static final char PLAYER = '@';

    public char [][] input = {{}};

    int playerX = 0; // Starting position for player in the x dimension
    int playerY = 0; // Starting position for player in y dimension


    public void readFile(String filename) throws Exception {
        Scanner scanner = new Scanner(new File(filename));
        int rows = 0;
        while (scanner.hasNextLine()) {
            rows++;
            scanner.nextLine();
        }
        scanner.close();

        scanner = new Scanner(new File(filename));
        input = new char[rows][scanner.nextLine().length()];

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                input[i][j] = line.charAt(j);
                if (input[i][j] == START) {
                    playerX = i;
                    playerY = j;
                }
            }
        }
        scanner.close();

        if (playerX == -1 || playerY == -1) {
            throw new Exception("Invalid map: Missing starting position (S)");
        }
    }
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}