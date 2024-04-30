package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Dijkstra {
    private static final int INF = Integer.MAX_VALUE;

    public static void search(int[][] graph, int startVertex, int endVertex) {

        int[] distance = new int[graph.length];
        Arrays.fill(distance, INF);
        distance[startVertex] = 0;
        boolean[] visited = new boolean[graph.length];
        int[] previous = new int[graph.length];
        Arrays.fill(previous, -1);
        List<Integer> path = new ArrayList<>();

        while (true) {
            int minDistVertex = findMinDistVertex(distance, visited);
            if (minDistVertex == -1) {
                break;
            }

            visited[minDistVertex] = true;

            if (minDistVertex == endVertex) {
                while (endVertex != -1) {
                    path.add(endVertex);
                    endVertex = previous[endVertex];
                }

                Collections.reverse(path);
                break;
            }

            for (int j = 0; j < graph.length; j++) {
                if (graph[minDistVertex][j] != INF && !visited[j] && distance[minDistVertex] != INF) {
                    int newDist = distance[minDistVertex] + graph[minDistVertex][j];
                    if (newDist < distance[j]) {
                        distance[j] = newDist;
                        previous[j] = minDistVertex;
                    }
                }
            }
        }

        String pathToString = path.stream()
                .map(vertex -> "V" + vertex)
                .collect(Collectors.joining(" > "));
        System.out.println(pathToString);

        String distanceToString = Arrays.toString(Arrays.stream(distance)
                .mapToObj(dist -> dist == INF ? "INF" : String.valueOf(dist))
                .toArray());
        System.out.println(distanceToString);
    }

    private static int findMinDistVertex(int[] distance, boolean [] visited) {

        int minVertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }

        }
        return minVertex;
    }

}
