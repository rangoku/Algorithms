package alghoritms.graphs.search;

import alghoritms.graphs.Graph;
import alghoritms.graphs.Vertex;

public class ConnectedComponents<T> {

    private boolean[] visited;

    /**
     * stores id of cc
     */
    private int[] id;

    /**
     * count of cc and their id
     */
    private int count = 0;

    public ConnectedComponents(Graph<T> G) {
        visited = new boolean[G.V()];
        id = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    /**
     * @return count of cc
     */
    public int count() { return count; }

    /**
     *
     * @param v is vertex for test
     * @return cc id
     */
    public int component_id(Vertex<T> v) { return id[v.getIndex()]; }

    /**
     *
     * @param v1 1st Vertex
     * @param v2 2nd Vertex
     * @return true if v1 and v2 are connected
     */
    public boolean isConnected (Vertex<T> v1, Vertex<T> v2) {
        return id[v1.getIndex()] == id[v2.getIndex()];
    }

    /**
     * Depth-First search
     * @param G executable Graph
     * @param v_index start Vertex index
     */
    private void dfs(Graph<T> G, int v_index) {
        visited[v_index] = true;
        id[v_index] = count;

        for (Vertex<T> vertex : G.getAdj(v_index)) {
            if (!visited[vertex.getIndex()]) {
                dfs(G, vertex.getIndex());
            }
        }
    }
}
