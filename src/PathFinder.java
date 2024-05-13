/*
Done By Andawatta Kankanamge Direndra Kavindu Chathurya
UOW ID -  W1871342
IIT id - 20212062
*/

import java.util.ArrayList;
import java.util.LinkedList;

public class PathFinder {
    private char[][] grid;
    private Node[][] map;
    private int rows;
    private int cols;
    private Node startNode, endNode;



    public void calculateCosts(Node ver){
        //CALCULATE THE G COST
        int xDistance = Math.abs(ver.getX() - startNode.getX());
        int yDistance = Math.abs(ver.getY() - startNode.getY());
        ver.setgCost(xDistance + yDistance);

        //CALCULATE THE H COST
        xDistance = Math.abs(ver.getX() - endNode.getX());
        yDistance = Math.abs(ver.getY() - endNode.getY());
        ver.setgCost(xDistance + yDistance);

        //CALCULATE THE F COST (TOTAL COST)
        ver.setfCost(ver.getgCost() + ver.gethCost());
    }

    public void findPath(){
        LinkedList<Node> pathList = new LinkedList<>();

        calculateCosts(startNode);

        pathList.add(startNode);

        Node currentNode = pathList.get(0);
        while (!pathList.isEmpty()){
            pathList.remove(currentNode);
            currentNode.setVisited();

            if(currentNode.isEnd()){
                System.out.println("PATH FOUND");
                tracePath(currentNode);
                break;
            }
            ArrayList<Node> neighbours = getNeighbours(currentNode);

            for(Node v : neighbours){

                if(v.isVisited()){

                    continue;
                }
                calculateCosts(v);

                if(v.getParent()== null){
                    v.setParent(currentNode);
                }

                v.setDirection(findDirection(currentNode,v));
                if(!pathList.contains(v)){

                    pathList.add(v);
                }

            }
            int bestFcost = 9999;
            int bestGCost = 9999;
            for(Node v : pathList){
                if(v.getfCost()< bestFcost){
                    bestFcost = v.getfCost();
                    bestGCost = v.getgCost();

                    currentNode = v;
                }
                if(v.getgCost() ==  bestFcost){
                    if(v.getgCost()< bestGCost){
                        bestGCost = v.getgCost();
                        currentNode = v;

                    }
                }
            }


        }



    }

    public PathFinder(char[][] grid){
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.map = new Node[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Node v = new Node(j, i);
                if(grid[i][j] == '0'){
                    v.setRock(true);
                }
                else if(grid[i][j] == 'S'){
                    v.setStart(true);
                    startNode = v;
                }
                else if(grid[i][j] == 'F'){
                    v.setEnd(true);
                    endNode = v;
                }
                map[i][j] = v;
            }
        }

    }

    public ArrayList<Node> getNeighbours(Node v){
        ArrayList<Node> neighbours = new ArrayList<>();
        int x = v.getX();
        int y = v.getY();

        for(int i = -1; i<=1; i++){
            for(int j = -1; j<=1; j++){
                if(Math.abs(i) == Math.abs(j)){
                    continue;
                }
                if(!isOutOfGrid(x+i, y+j)){

                    int newX = x;
                    int newY = y;
                    while(!isOutOfGrid(newX+i, newY+j) && !map[newY+j][newX+i].isRock() ){
                        newX += i;
                        newY += j;
                        if(map[newY][newX].isEnd()){
                            break;
                        }
                    }
                    if(!(newX==x && newY==y)){
                        neighbours.add(map[newY][newX]);
                    }

                }
            }
        }
        return neighbours;
    }

    public boolean isOutOfGrid(int x, int y){
        if(x >= 0 && x <= cols-1 && y >= 0 && y <= rows-1){
            return false;
        }
        return true;
    }

    public String findDirection(Node parent, Node child){
        String direction = "";
        if(parent.getX() == child.getX() && parent.getY() > child.getY()){
            direction = "UP";
        }
        if(parent.getX() == child.getX() && parent.getY() < child.getY()){
            direction = "DOWN";
        }
        if(parent.getY() == child.getY() && parent.getX() > child.getX()){
            direction = "LEFT";
        }
        if(parent.getY() == child.getY() && parent.getX() < child.getX()){
            direction = "RIGHT";
        }
        return direction;
    }

    public void tracePath(Node v){
        LinkedList<Node> path = new LinkedList<>();
        path.add(v);
        while(v.getParent() != null){
            v = v.getParent();
            path.add(v);

        }
        int count = 1;
        int size = path.size();
        while(!path.isEmpty()){
            Node node = path.pollLast();
            if(count ==1){
                System.out.println(count++ +". Start at ("+(node.getX()+1)+","+(node.getY()+1)+")" );
            }
            else{
                System.out.println(count++ +". Move " + node.getDirection() +" to ("+(node.getX()+1)+","+(node.getY()+1)+")" );
            }
        }
        System.out.println(count + ". Done");

    }
// For testing purposes created this print function

//    private static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_RESET = "\u001B[0m";
////    public static final String ANSI_GREEN = "\u001B[32m";
//    public static final String ANSI_BLUE = "\u001B[34m";


//    public void printNodeGrid(){
//        for(int i=0;i<rows;i++){
//            for(int j =0; j<cols; j++){
//                if(map[i][j].isRock()){
//                    System.out.print(ANSI_RED + map[i][j]+ANSI_RESET+" , ");
//                }
//                else if(map[i][j].isStart()){
//                    System.out.print(ANSI_GREEN + map[i][j]+ANSI_RESET+" , ");
//                }
//                else if(map[i][j].isEnd()){
//                    System.out.print(ANSI_BLUE + map[i][j]+ANSI_RESET+" , ");
//                }
//                else {
//                    System.out.print(map[i][j] + " , ");
//                }
//            }
//            System.out.println("");
//        }
//    }



}
