/*
Done By Andawatta Kankanamge Direndra Kavindu Chathurya
UOW ID -  W1871342
IIT id - 20212062
*/

public class Node {
    private int x;// X COORDINATES
    private int y;// Y COORDINATES
    private Node parent;//PARENT Node
    private boolean isVisited;//Node IS VISITED OR NOT
    private boolean isRock=false;//IF THE Node IS A ROCK
    private boolean isStart=false;// IF THE Node IS THE START Node
    private boolean isEnd=false;// IF THE Node IS THE END Node
    private int gCost,hCost,fCost;// G COST, H COST AND F COST (F=G+H)
    private String direction;//DIRECTION FORM THE PARENT Node

    //CONSTRUCTOR
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.isVisited = false;
        this.parent = null;
    }

    //GETTERS AND SETTERS
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Node getParent() {
        return parent;
    }
    public boolean isVisited() {
        return isVisited;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public void setVisited() {this.isVisited=true;}



    public void setRock(boolean rock) {
        isRock = rock;
    }

    public boolean isRock() {
        return isRock;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public int getgCost() {
        return gCost;
    }

    public void setgCost(int gCost) {
        this.gCost = gCost;
    }

    public int gethCost() {
        return hCost;
    }

    public void sethCost(int hCost) {
        this.hCost = hCost;
    }

    public int getfCost() {
        return fCost;
    }

    public void setfCost(int fCost) {
        this.fCost = fCost;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Node)) {
            return false;
        }
        Node ver = (Node) obj;
        return this.x == ver.getX() && this.y == ver.getY();
    }

    @Override
    public String toString() {
        return "["+x+", "+y+"]";
    }
}