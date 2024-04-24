import java.io.File;
import java.util.*;

public class ShortestPathFinder {


    static Node startingNode;
    static  Node endingNode;
    public static void getStartingPosition ( char[][] input){
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 'S') {
                    playerX = j;
                    playerY = i;
                    startingNode = new Node(j, i, true);
                    System.out.println("x = " + j + " y = " + i);

                } else if (input[i][j] == 'F') {
                    endingNode = new Node(j, i, true); // Assuming 'F' is walkable
                }
            }
        }
    }

    public static List<Node> findShortestPath(Graph graph, Node startingNode, Node endingNode) {




        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        startingNode.distance = 0;
        pq.offer(startingNode);

        //A set is created called Visited to avoid visiting the previously visited nodes
        Set<Node> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // Target reached, return the path
            if (current.equals(endingNode)) {
                return reconstructPath(current);
            }

            visited.add(current);
            for (Node neighbor : graph.getNeighbors(current)) {
                if (!visited.contains(neighbor) && neighbor.isWalkable) {
                    int tentativeDistance = current.distance + 1; // Assuming uniform movement cost of 1
                    if (tentativeDistance < neighbor.distance) {
                        neighbor.distance = tentativeDistance;
                        neighbor.parent = current;
                        pq.offer(neighbor);
                    }
                }
            }
        }

        // No path found
        System.out.println("No Path Found");
        return null;
    }
    private static List<Node> reconstructPath(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(0, node);
            node = node.parent;
        }
        return path;
    }
    public static String getDirection(Node current, Node neighbor) {
        int dx = neighbor.x - current.x;
        int dy = neighbor.y - current.y;

        if (dx == -1) {
            return "left";
        } else if (dx == 1) {
            return "right";
        } else if (dy == -1) {
            return "up";
        } else {
            return "down";
        }
    }












    static int playerX = 0; // Starting position for player in the x dimension
   static int playerY = 0; // Starting position for player in y dimension









//    static public void readFile(String filename) throws Exception {
//        Scanner scanner = new Scanner(new File(filename));
//        int rows = 0;
//        while (scanner.hasNextLine()) {
//            rows++;
//            scanner.nextLine();
//        }
//        scanner.close();
//
//        scanner = new Scanner(new File(filename));
//        input = new char[rows][scanner.nextLine().length()];
//
//        for (int i = 0; i < rows; i++) {
//            String line = scanner.nextLine();
//            for (int j = 0; j < line.length(); j++) {
//                input[i][j] = line.charAt(j);
//                if (input[i][j] == START) {
//                    playerX = i;
//                    playerY = j;
//                }
//            }
//        }
//        scanner.close();
//
//        if (playerX == -1 || playerY == -1) {
//            throw new Exception("Invalid map: Missing starting position (S)");
//        }
//    }
    public static void main(String[] args) throws Exception {

         char[][] input = {
                {'.', '.', 'S', '.', '.', '.', '.', '.', '.', '.'}, //start is at[2,0]
                {'.', '0', '.', '.', '0', '.', '.', '.', '.', '.'},
                {'0', '.', '.', '.', '0', '.', '0', '.', '0', '.'},
                {'.', '0', '.', '.', '.', '0', '.', '.', '0', '.'},
                {'.', '.', 'F', '.', '0', '.', '.', '0', '.', '.'},
                {'.', '0', '0', '.', '0', '.', '.', '.', '.', '.'},
                {'.', '.', '0', '.', '0', '.', '.', '.', '0', '.'},
                {'.', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                {'0', '.', '.', '.', '.', '0', '0', '.', '.', '.'}, //finish is at[0,8]
                {'.', '0', '0', '.', '.', '.', '0', '.', '.', '.'},
        };
        Graph graph = new Graph(input);
        getStartingPosition(input);


        List<Node> shortestPath = ShortestPathFinder.findShortestPath(graph, startingNode, endingNode);
        if (shortestPath != null) {
            int step = 1;
            Node previousNode = null;

            for (Node node : shortestPath) {
                String direction = "";
                if (previousNode != null) {
                    direction = ShortestPathFinder.getDirection(previousNode, node);
                }

                System.out.printf("%d.%s at (%d,%d)%s\n", step++,
                        direction.isEmpty() ? "Start" : direction, node.x, node.y,
                        direction.isEmpty() ? "" : " - " + direction);
                previousNode = node;
            }
            System.out.println("Done!");
        } else {
            System.out.println("No path found from S to F!");
        }
//        System.out.println("Enter the file path of the file containing the maze map");
//        String input = scn.nextLine();

//        readFile(input);

    }
}