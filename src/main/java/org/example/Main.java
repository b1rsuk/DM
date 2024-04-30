package org.example;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] dijkstraGraph = {
                {INF, 1, 5, INF, INF, INF, INF},
                {INF, INF, 3, INF, 2, 8, 20},
                {INF, INF, INF, INF, INF, 4, INF},
                {INF, INF, 9, INF, INF, INF, INF},
                {INF, INF, INF, INF, INF, INF, INF},
                {INF, INF, INF, INF, INF, INF, 7},
                {INF, INF, INF, INF, INF, INF, INF}
        };
        System.out.println("Dijkstra");
        Dijkstra.search(dijkstraGraph, 0, dijkstraGraph.length - 1);

        int[][] floydGraph =
                {
                        {0, 1, 6, INF, INF, INF},
                        {INF, 0, 4, INF, -2, INF},
                        {INF, INF, 0, INF, 5, 3},
                        {2, INF, INF, 0, -5, INF},
                        {INF, INF, INF, 8, 0, 4},
                        {INF, INF, INF, INF, INF, 0}
                };


        System.out.println("Floyd");
        Floyd.search(floydGraph, 5, 3);

    }


}