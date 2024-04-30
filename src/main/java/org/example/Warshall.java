package org.example;


public class Warshall {
    static int n = 5; //n=rows[W]
    static int I = 999999999; //representa el INFINITO

    static void FloydWarshall(int W[][]) {
        int[][] dist = new int[n][n];// representar� el peso de la ruta m�s corta desde el v�rtice i al v�rtice j
        int i, j, k;
        dist=W;
        //Algoritmo de Floyd-Warshall O (n ^ 3)
        for (k = 0; k < n; k++)
            for (j = 0; j < n; j++)
                for (i = 0; i < n; i++)
                    // Si el v�rtice k est� en el camino m�s corto desde
                    // i to j, luego actualice el valor de dist [i] [j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }

        printMatrix(dist);
    }

    public static void main(String[] args) {
        // Asume una representaci�n de matriz de adyacencia
        // Supongamos que los v�rtices est�n numerados 1,2, ..., n
        // La entrada es una matriz n x n (ver README.md)
        int graph2[][] = {
                { 0, 3, 8, I, -4 },
                { I, 0, I, 1, 7 },
                { I, 4, 0, I, I },
                { 2, I, -5, 0, I },
                { I, I, I, 6, 0 }
        };
        FloydWarshall(graph2);
    }

    static void printMatrix(int dist[][]) {
        System.out.println("New Matrix: ");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] == I)
                    System.out.print("I   \t");
                else
                    System.out.print(dist[i][j] + "   \t");
            }
            System.out.println();
        }
    }
}
/*
SALIDA
Matriz:
0   	1   	-3   	2   	-4
3   	0   	-4   	1   	-1
7   	4   	0   	5   	3
2   	-1   	-5   	0   	-2
8   	5   	1   	6   	0
*/
