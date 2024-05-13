/*
Done By Andawatta Kankanamge Direndra Kavindu Chathurya
UOW ID -  W1871342
IIT id - 20212062
*/


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //The map got in the file is saved to a list

        ArrayList<String> map = new ArrayList<>();

        //Read file ine by line and adding it to the map array list
       // printVertexGrid();
        try{
            System.out.println("************************************");
            System.out.println("**** Welcome to Slide maze path finder! ****");
            System.out.println("************************************");




            File puzzle = new File("benchmark_series/benchmark_series/puzzle_10.txt");
            Scanner reader = new Scanner(puzzle);
            while(reader.hasNext()){
                String line = reader.nextLine();
                map.add(line);
            }
            reader.close();
        }catch(Exception e){
            System.out.println("File not found");
            e.printStackTrace();
        }

        //Creating a Char 2D array to store the given map
        char[][] graph  = new char[map.size()][];
        for(int i = 0; i < map.size(); i++){
            graph[i] = map.get(i).toCharArray();
        }

        //Creates a PathFinder object to perform A* algorithm and find the shortest path
        System.out.println("graph height : " + graph.length);
        System.out.println("");
        System.out.println("graph width : " + graph[0].length);
        System.out.println("");

        PathFinder PF = new PathFinder(graph);

//       algo.printVertexGrid();
        long startTime = System.nanoTime();
        PF.findPath();
        long endTime = System.nanoTime();

        System.out.println("Time taken: " + (endTime - startTime) / 1000000 + "ms");




    }
}