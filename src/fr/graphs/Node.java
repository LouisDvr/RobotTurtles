package fr.graphs;

public class Node {
    // based on https://stackabuse.com/graphs-in-java-representing-graphs-in-code/

    int n;
    String name;

    public Node(int n, String name) {
        this.n = n;
        this.name = name;
    }

    public int getNumber() { return n; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean equals(Object o) {
        return o instanceof fr.graphs.Node && ((fr.graphs.Node) o).getNumber() == n && ((fr.graphs.Node) o).getName().equals(name);
    }

    public int hashCode() {
        return n;
    }
}
