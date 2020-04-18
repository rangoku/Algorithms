package alghoritms.graphs.search;

import alghoritms.graphs.Graph;
import alghoritms.graphs.Vertex;

import java.util.*;

public class BreadthFirstSearch<T> {

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

    public BreadthFirstSearch(Graph<T> G, Vertex<T> source) {
        this.source = source;
        visited = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        move(G, source.getIndex());
    }

    /**
     * @param to is index of Vertex we would like to move
     */
    public boolean hasPathTo (Vertex<T> to) { return visited[to.getIndex()]; }

    /**
     * Return the shortest path from source to param: to
     *
     * @param to is Vertex we will search path to
     * @return Stack that will represent path in descending order
     */
    public Iterable<Integer> getShortestPath (Vertex<T> to) {
        if (!hasPathTo(to)) return null;
        int v = to.getIndex();
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != source.getIndex(); i = edgeTo[i]) {
            path.push(i);
        }
        path.push(source.getIndex());

        return path;
    }

    /**
     * method will visit each vertex only once
     *
     * @param G is executable Graph
     * @param v_index is index of source vertex
     */
    private void move(Graph<T> G, int v_index) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(v_index);
        visited[v_index] = true;

        while (!deque.isEmpty()) {

            int v = deque.removeFirst();
            for(Vertex<T> vertex : G.getAdj(v)) {
                if (!visited[vertex.getIndex()]) {
                    deque.addLast(vertex.getIndex());
                    visited[vertex.getIndex()] = true;
                    edgeTo[vertex.getIndex()] = v;
                    System.out.println(vertex.getIndex() + " --- " + edgeTo[vertex.getIndex()]);
                }
            }
        }
    }
}
