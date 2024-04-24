import java.io.File;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPathFinder {

    public static List<Node> findShortestPath(Graph graph, Node start, Node end) {
        // Priority queue for efficient exploration (ordered by distance)
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);











        public static final char EMPTY = '.';
    public static final char START = 'S';
    public static final char FINISH = 'F';
    public static final char ROCK = '0';
    public static final char PLAYER = '@';


    static int playerX = 0; // Starting position for player in the x dimension
   static int playerY = 0; // Starting position for player in y dimension
    static public char [][] input =  {
            {'.' , '.' , 'S' , '.', '.' , '.', '.' , '.' , '.' , '.'}, //start is at[2,0]
            {'.', '0', '.' , '.', '0', '.', '.', '.', '.' , '.'},
            {'0', '.', '.', '.', '0', '.', '0', '.', '0', '.'},
            {'.', '0', '.', '.', '.', '0', '.', '.', '0', '.'},
            {'.', '.', '.', '.', '0', '.', '.', 'F', '.', '.'},
            {'.', '0', '0', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '0', '.', '0', '.', '.', '.', '0', '.'},
            {'.', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
            {'0', '.', '.', '.', '.', '0', 'F', '.', '.', '.'}, //finish is at[0,8]
            {'.', '0', '0', '.', '.', '.', '0', '.', '.' , '.'},
    };

static public void getStartingPosition(char [][] input){
    for (int i =0; i< input.length ;i++){
        for (int j=0; j< input[i].length; j++){
            if (input[i][j] == 'S'){
                playerX = j;
                playerY=i;
                System.out.println("x = "+j + " y = " +i );
                break;
            }
        }
    }
}






    static public void readFile(String filename) throws Exception {
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
    public static void main(String[] args) throws Exception {


Scanner scn = new Scanner(System.in);
        System.out.println("Hello world!");
        getStartingPosition(input);
//        System.out.println("Enter the file path of the file containing the maze map");
//        String input = scn.nextLine();

//        readFile(input);

    }
}