package alghoritms.graphs;

import java.util.LinkedList;

/**
 * Undirected graph API:
 * @param <T> is type of storage value
 *
 */

public class UndirectedGraph<T> {
    private final int V;
    private LinkedList<Vertex<T>>[] adj;

    public UndirectedGraph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }
    public void addEdge(Vertex<T> v, Vertex<T> w) {
        adj[v.getIndex()].addLast(w);
        adj[w.getIndex()].addLast(v);

    }
    public int V() {
        return V;
    }
    public Vertex<T> getVertexByIndex(int i) {
        int index = adj[i].get(0).getIndex();

        for (Vertex<T> v : adj[index])
            if (v.getIndex() == i)
                return v;
        return null;
    }
    public void print() {
        for (int v = 0; v < V; v++) {
            for (Vertex<T> vertex : adj[v]) {
                System.out.println("( " + this.getVertexByIndex(v).getIndex() +", " + this.getVertexByIndex(v).getValue() + " )" +
                        " --- ( " + vertex.getIndex() +", " + vertex.getValue() + " )");
            }
        }
    }
}
