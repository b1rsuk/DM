package org.example;

class Floyd {
    final static int INF = 99999, V = 4;

    public static void floydWarshall(int[][] dist) {
        System.out.println("Оригiнальна матриця");
        printSolution(dist);
        System.out.println();
        System.out.println("Обрахованi шляхи");

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    private static void printSolution(int[][] dist) {

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

}