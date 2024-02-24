package org.example;

import org.example.struct.Graph;
import org.example.struct.Node;

public class Main {

    public static void main(String[] args) {
        Graph graph = generateGraph();
        graph.print();

        Search.depthFirstSearch(graph, 0);
        Search.breadthFirstSearch(graph, 0);
    }

    private static Graph generateGraph() {
        Graph graph = new Graph(5);

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        return graph;
    }
}
