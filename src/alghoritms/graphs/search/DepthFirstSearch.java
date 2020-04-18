package alghoritms.graphs.search;

import alghoritms.graphs.Graph;
import alghoritms.graphs.Vertex;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Depth-First search API
 * @param <T> is searched element type
 *
 */

public class DepthFirstSearch<T> {

    /**
     * point from which we will start move
     */
    private Vertex<T> source;

    /**
     *  array which represents vertex is visited or not
     */
    private boolean[] visited;

    /**
     * array which stores return addresses (indexes of Vertexes)
     */
    private int[] edgeTo;

    /**
     *
     * @param G is executable graph
     * @param source is vertex to search from (any)
     */
    public DepthFirstSearch(Graph<T> G, Vertex<T> source) {
        visited = new boolean[G.V()];
        edgeTo = new int[G.V()-1];
        this.source = source;
        move(G, source.getIndex());
    }

    /**
     * @param to is index of Vertex we would like to move
     */

    public boolean hasPathTo(int to) {
        return visited[to];
    }
    /**
     * @param v is Vertex we will search path to
     * @return path from v to source
     */
    public Iterable<Integer> getPathTo(Vertex<T> v) {
        int to = v.getIndex();
        if (!hasPathTo(to)) return null;
        Stack<Integer> path = new Stack<>();
        for (int i = to; i != source.getIndex(); i = edgeTo[i])
            path.push(i);
        path.push(source.getIndex());

        return path;
    }

    /**
     * @param v_index is index of vertex from which we will move further
     */
    private void move(Graph<T> G, int v_index) {
        visited[v_index] = true;

        for (Vertex<T> vertex : G.getAdj(v_index)) {
            if (!visited[vertex.getIndex()]) {
                edgeTo[vertex.getIndex()] = v_index;
                move(G, vertex.getIndex());
            }
        }
    }
}
