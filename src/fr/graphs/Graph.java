package fr.graphs;

import fr.graphs.Node;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    // based on https://stackabuse.com/graphs-in-java-representing-graphs-in-code/

    // Each node maps to a list of all his neighbors
    // LinkedList is better than ArrayList for add and remove; it is also lighter in memory
    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }


    public void addNode(Node node) {
        if (!adjacencyMap.containsKey(node)) {
            adjacencyMap.put(node, null);
        }
    }


    public void removeNode(Node node) { adjacencyMap.remove(node); }


    public Node get(int n) {
        for (Node node : adjacencyMap.keySet()) {
            if (node.getNumber() == n) {
                return node;
            }
        }
        return null;
    }


    public Node[] getNodes() {
        return adjacencyMap.keySet().toArray(new Node[0]);
    }


    public LinkedList<Node> getNeighbours(Node node) {

        if (!adjacencyMap.containsKey(node)) { adjacencyMap.put(node, null); }

        return adjacencyMap.get(node);
    }


    public void addEdge(Node source, Node destination) {

        // We make sure the asked Nodes are in the graph
        if (!adjacencyMap.containsKey(source)) { adjacencyMap.put(source, null); }

        if (!adjacencyMap.containsKey(destination)) { adjacencyMap.put(destination, null); }

        addEdgeHelper(source, destination);

        // If the graph is undirected, we add an edge from the destination too
        if (!directed) {
            addEdgeHelper(destination, source);
        }
    }

    private void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> tmp = adjacencyMap.get(a);

        // If the edge already exists (duplicate edge) we firstly remove it
        if (tmp != null) { tmp.remove(b); }

        else { tmp = new LinkedList<>(); }

        tmp.add(b);
        adjacencyMap.put(a, tmp);
    }


    public void removeEdge(Node a, Node b) {

        // We make sure the asked Nodes are in the graph
        if (!adjacencyMap.containsKey(a)) { adjacencyMap.put(a, null); }

        if (!adjacencyMap.containsKey(b)) { adjacencyMap.put(b, null); }

        // If there is an edge between a and b, we remove it
        if (adjacencyMap.get(a) != null) { adjacencyMap.get(a).remove(b); }

        if (adjacencyMap.get(b) != null) { adjacencyMap.get(b).remove(a); }
    }


    public void printEdges() {
        for (Node node : adjacencyMap.keySet()) {
            System.out.print(node.n + ", " + node.name + " has an edge towards: ");
            for (Node neighbour : adjacencyMap.get(node)) {
                System.out.print(neighbour.n + ", " + neighbour.name + " ");
            }
            System.out.println();
        }
    }


    public boolean hasEdge(Node source, Node destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).contains(destination);
    }


    public LinkedList<Node> breadthFirstSearch(Node source) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        HashSet<Node> discovered = new HashSet<>();
        LinkedList<Node> path = new LinkedList<>();

        queue.addLast(source);
        Node node;
        LinkedList<Node> neighbours;
        while (!queue.isEmpty()) {
            node = queue.pollFirst();
            if (!discovered.contains(node)) {
                discovered.add(node);
                path.add(node);
                if (adjacencyMap.containsKey(node) && adjacencyMap.get(node) != null) {
                    neighbours = adjacencyMap.get(node);
                    for (Node neighbour : neighbours) {
                        if (!discovered.contains(neighbour)) {
                            queue.addLast(neighbour);
                        }
                    }
                }
            }
        }
        return path;
    }


    public LinkedList<Node> depthFirstSearch(Node source) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        HashSet<Node> discovered = new HashSet<>();
        LinkedList<Node> path = new LinkedList<>();

        stack.addFirst(source);
        Node node;
        LinkedList<Node> neighbours;
        while (!stack.isEmpty()) {
            node = stack.pollFirst();
            if(!discovered.contains(node)) {
                discovered.add(node);
                path.add(node);
                if (adjacencyMap.containsKey(node) && adjacencyMap.get(node) != null) {
                    neighbours = adjacencyMap.get(node);
                    for (Node neighbour : neighbours) {
                        if (!discovered.contains(neighbour)) {
                            stack.addFirst(neighbour);
                        }
                    }
                }
            }
        }
        return path;
    }

}
