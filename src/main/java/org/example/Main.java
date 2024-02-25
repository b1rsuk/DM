package org.example;

import static org.example.Floyd.INF;

public class Main {

    public static void main(String[] args)
    {
        int[][] graph = {
                { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
        };
        Floyd floyd = new Floyd();
        floyd.floydWarshall(graph);
    }
}
