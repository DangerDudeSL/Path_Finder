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
        int x = node.x;
        int y = node.y;

        // Check all four directions (up, down, left, right)
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                // Skip checking the current node and avoid going out of bounds
                if (dx == 0 && dy == 0 || !isValidCoordinate(x + dx, y + dy)) {
                    continue;
                }
                neighbors.add(getNode(x + dx, y + dy));
            }
        }
        return neighbors;
    }
}
