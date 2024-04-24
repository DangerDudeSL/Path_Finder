import java.util.List;

public class Node {
    public int x;
    public int y;
    public boolean isWalkable;
    public int distance = Integer.MAX_VALUE; // Optional for Dijkstra's algorithm
    public Node parent; // Optional for Dijkstra's algorithm


    public Node(int x, int y, boolean isWalkable) {
        this.x = x;
        this.y = y;
        this.isWalkable = isWalkable;

    }

}
