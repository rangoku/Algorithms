package alghoritms.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Undirected graph API:
 *
 * never do like that -> graph.addEdge(new Vertex<T>(index, value), new Vertex<T>(index, value));
 * you should previously create an object of Vertex and then use it to connect with new Vertexes
 * if you don't mind, wait for data leak
 *
 * @param <T> is type of storage value
 *
 */

public class Graph<T> {

    /**
     * number of vertexes
     */
    private final int V;

    /**
     * adjacency list
     */
    private LinkedList<Vertex<T>>[] adj;

    /**
     * m and dual will be used for bipartite test
     */
    private int[] m;
    private int dual = -1;

    /**
     * represent Vertex is visited or not (by index)
     */
    private boolean[] visited;

    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    /**
     * Create edge between v and w
     * @param v Vertex #1
     * @param w Vertex #2
     */
    public void addEdge(Vertex<T> v, Vertex<T> w) {
        adj[v.getIndex()].addLast(w);
        adj[w.getIndex()].addLast(v);

    }

    /**
     *
     * @param i is index if Vertex
     * @return all adjacent Vertexes for vertex with index - i
     */
    public LinkedList<Vertex<T>> getAdj(int i) {
        return adj[i];
    }

    /**
     * @return number of Vertexes
     */
    public int V() {
        return V;
    }

    /**
     *
     * @param i is index of some Vertex
     * @return Vertex with index - i
     */
    public Vertex<T> getVertexByIndex(int i) {
        int index = adj[i].get(0).getIndex();

        for (Vertex<T> v : adj[index])
            if (v.getIndex() == i)
                return v;
        return null;
    }

    /**
     * Not working now(
     * @param source start point for dfs
     * @return true if Graph is bipartite
     */
    public boolean isBipartite(Vertex<T> source) {
        visited = new boolean[this.V];

        m = new int[this.V];

        dfs(this, source.getIndex());

        for(int i = 0; i < m.length; i++) {
            System.out.println(m[i] + " --- " + this.getVertexByIndex(i).getIndex());
        }

        for (int i = 0; i < m.length; i++) {
            for (Vertex<T> vertex : this.adj[i]) {
                if (m[vertex.getIndex()] == m[i])
                    return false;
            }
        }

        return true;
    }

    /**
     * Used for divide Graph into 2 sets
     * @see alghoritms.graphs.search.DepthFirstSearch
     */
    private void dfs(Graph<T> G, int v_index) {
        visited[v_index] = true;
        m[0] = -1;
        for (Vertex<T> vertex : G.getAdj(v_index)) {
            if (!visited[vertex.getIndex()]) {
                dual *= -1;
                m[vertex.getIndex()] = dual;
                System.out.println(vertex.getIndex());
                dfs(G, vertex.getIndex());
            }
        }
    }

    /**
     *  print a Graph
     */
    public void print() {
        for (int v = 0; v < V; v++) {
            for (Vertex<T> vertex : adj[v]) {
                System.out.println("( " + this.getVertexByIndex(v).getIndex() +", " + this.getVertexByIndex(v).getValue() + " )" +
                        " --- ( " + vertex.getIndex() +", " + vertex.getValue() + " )");
            }
        }
    }
}
