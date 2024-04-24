import java.util.ArrayList;
import java.util.List;

public class Graph {
    private char[][] map;
    private int width;
    private int height;
public Graph(char [][] input) {
    this.map = input;
    int mapHeight = input.length;
    int mapWidth = input[0].length;
}

    public Node getNode(int x, int y) {
        if (isValidCoordinate(x, y)) {
            return new Node(x, y, map[y][x] != '0'); // '0' represents rock (not walkable)
        }
        return null;
    }

    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();
        int rows = map.length;
        int cols = map[0].length;

        // Check all four directions (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = node.x + dx[i];
            int newY = node.y + dy[i];

            // Check if new coordinates are within map boundaries
            if (newX >= 0 && newX < cols && newY >= 0 && newY < rows) {

                // Check if neighbor is walkable and diagonally reachable
                if (map[newY][newX] != '0' && isDiagonallyReachable(node, newX, newY)) {
                    neighbors.add(new Node(newX, newY, true));
                }
            }
        }

        return neighbors;
    }

    private boolean isDiagonallyReachable(Node node, int newX, int newY) {
        int dx = newX - node.x;
        int dy = newY - node.y;

        // Check if the move is diagonal
        if (Math.abs(dx) == 1 && Math.abs(dy) == 1) {
            // Check if the node in between is not a rock
            int midX = node.x + dx / 2;
            int midY = node.y + dy / 2;
            return map[midY][midX] != '0';
        }

        return true; // Not a diagonal move, so it's reachable
    }
    }

