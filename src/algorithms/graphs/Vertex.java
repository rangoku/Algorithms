package algorithms.graphs;

public class Vertex<T> {

    private int index;// index <= UndirectedGraph.V;
    private T value;

    public Vertex(int index, T value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public T getValue() {
        return value;
    }
}
