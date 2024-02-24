package org.example;

import org.example.struct.Graph;
import org.example.struct.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public final class Search {

    public static void breadthFirstSearch(Graph graph, int src) {
        int[][] matrix = graph.getMatrix();
        ArrayList<Node> nodes = graph.getNodes();

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.add(src);
        visited[src] = true;

        while(!queue.isEmpty()) {

            src = queue.poll();
            System.out.println(nodes.get(src).data + " = visited");

            for(int i = 0; i < matrix[src].length; i++) {
                if(matrix[src][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }


    public static void depthFirstSearch(Graph graph, int first) {
        int[][] matrix = graph.getMatrix();
        ArrayList<Node> nodes = graph.getNodes();
        boolean[] visited = new boolean[matrix.length];

        dfsHelper(first, visited, matrix, nodes);
    }

    private static void dfsHelper(int src, boolean[] visited, int[][] matrix, ArrayList<Node> nodes) {

        if (visited[src]) {
            return;
        }

        visited[src] = true;
        System.out.println(nodes.get(src).data + " = visited");

        for (int i = 0; i < matrix[src].length; i++) {
            if (matrix[src][i] == 1) {
                dfsHelper(i, visited, matrix, nodes);
            }
        }

    }

}
