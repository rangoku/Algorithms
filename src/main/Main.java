package main;

import alghoritms.graphs.*;

public class Main {

    public static void main(String[] args) {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>(5);

        /**
         * never do like that -> graph.addEdge(new Vertex<T>(index, value), new Vertex<T>(index, value));
         * you should previously create an object of Vertex and then use it to connect with new Vertexes
         * if you don't mind, wait for data leak
         */
        Vertex<Integer> v0 = new Vertex<>(0, 1000);
        Vertex<Integer> v1 = new Vertex<>(1, 1111);
        Vertex<Integer> v2 = new Vertex<>(2, 2222);
        Vertex<Integer> v3 = new Vertex<>(3, 3333);

        graph.addEdge(v0, v1);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v0);


        graph.print();
    }
}
