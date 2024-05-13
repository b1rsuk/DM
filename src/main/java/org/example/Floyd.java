package org.example;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


public class Floyd {

    private static  AsciiTable asciiTable = new AsciiTable();
    private static final int INF = Integer.MAX_VALUE;

    public static void search(int[][] graph, int startVertex, int endVertex) {
        int matrixSize = graph.length;
        int[][] route = generateRoute(matrixSize);

        System.out.println("P(0)");
        printMatrix(route);
        System.out.println("D(0)");
        printMatrix(graph);

        for (int k = 0; k < matrixSize; k++) {
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF && graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        route[i][j] = route[k][j];
                    }
                }

            }

            String iterationInfo = "%s(%s)";
            System.out.println(String.format(iterationInfo, "D", k + 1));
            printMatrix(graph);

            System.out.println(String.format(iterationInfo, "P", k + 1));
            printMatrix(route);
        }

        printPath(route, 5, 3);

    }

    public static void printPath(int[][] routeMatrix, int startVertex, int endVertex) {
        Stack<Integer> pathStack = new Stack<>();
        pathStack.push(endVertex);

        while (!pathStack.empty()) {
            int prevVertex = routeMatrix[startVertex - 1][pathStack.peek() - 1];
            pathStack.push(prevVertex);
            if (prevVertex == startVertex) {
                break;
            }
        }
        Collections.reverse(pathStack);

        String pathToString = pathStack.stream()
                .map(vertex -> "V" + vertex)
                .collect(Collectors.joining(" > "));
        System.out.println(pathToString);
    }

    private static int[][] generateRoute(int matrixSize) {
        int[][] route = new int[matrixSize][matrixSize];

            for (int vertex = 0; vertex < matrixSize; vertex++) {
                for (int edge = 0; edge < matrixSize; edge++) {
                    if (vertex != edge) {
                        route[vertex][edge] = vertex + 1;
                    }
                }
            }

        return route;
    }

    public static void printMatrix(int[][] matrix) {
        List<String> headers = new ArrayList<>();
        for (int i = 1; i < matrix.length + 1; i++) {
            headers.add("V" + i);
        }
        asciiTable.addRule();
        addRow(headers);


        for (int[] row : matrix) {
            List<String> list = Arrays.stream(row)
                    .mapToObj(n -> n == INF? "INF" : String.valueOf(n))
                    .toList();
            addRow(list);
        }
        System.out.println(asciiTable.render());
        asciiTable = new AsciiTable();
    }

    private static void addRow(List<String> list) {
        asciiTable.addRow(list)
                .setTextAlignment(TextAlignment.CENTER);
        asciiTable.addRule();
    }

    /*
    private static void printPath(int[][] path, int v, int u)
    {
        if (path[v][u] == v)
            return;

        printPath(path, v, path[v][u]);
        System.out.print(path[v][u] + " ");
    }

    // Function to print the shortest cost with path
    // information between all pairs of vertices
    private static void printSolution(int[][] cost, int[][] path, int N)
    {       printPath(path, 3, 5);

    }


    // Function to run Floyd-Warshell algorithm
    public static void FloydWarshell(int[][] adjMatrix, int N)
    {
        // cost[] and parent[] stores shortest-path
        // (shortest-cost/shortest route) information
        int[][] cost = new int[N][N];
        int[][] path = new int[N][N];

        // initialize cost[] and parent[]
        for (int v = 0; v < N; v++)
        {
            for (int u = 0; u < N; u++)
            {
                // initally cost would be same as weight
                // of the edge
                cost[v][u] = adjMatrix[v][u];

                if (v == u)
                    path[v][u] = 0;
                else if (cost[v][u] != Integer.MAX_VALUE)
                    path[v][u] = v;
                else
                    path[v][u] = -1;
            }
        }

        // run Floyd-Warshell
        for (int k = 0; k < N; k++)
        {
            for (int v = 0; v < N; v++)
            {
                for (int u = 0; u < N; u++)
                {
                    // If vertex k is on the shortest path from v to u,
                    // then update the value of cost[v][u], path[v][u]

                    if (cost[v][k] != Integer.MAX_VALUE
                            && cost[k][u] != Integer.MAX_VALUE
                            && (cost[v][k] + cost[k][u] < cost[v][u]))
                    {
                        cost[v][u] = cost[v][k] + cost[k][u];
                        path[v][u] = path[k][u];
                    }
                }

                // if diagonal elements become negative, the
                // graph contains a negative weight cycle
                if (cost[v][v] < 0)
                {
                    System.out.println("Negative Weight Cycle Found!!");
                    return;
                }
            }
        }

        // Print the shortest path between all pairs of vertices
        printSolution(cost, path, N);
    }

    public static void main(String[] args)
    {
        // Number of vertices in the adjMatrix
        final int N = 4;
        int INF = Integer.MAX_VALUE;

        // given adjacency representation of matrix
        int[][] floydGraph =
                {
                        {0, 1, 6, INF, INF, INF},
                        {INF, 0, 4, INF, -2, INF},
                        {INF, INF, 0, INF, 5, 3},
                        {2, INF, INF, 0, -5, INF},
                        {INF, INF, INF, 8, 0, 4},
                        {INF, INF, INF, INF, INF, 0}
                };

        // Run Floyd Warshell algorithm
        FloydWarshell(floydGraph, floydGraph.length);
    }

     */
}


