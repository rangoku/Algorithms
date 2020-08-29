package main;

import alghoritms.graphs.*;
import alghoritms.graphs.search.BreadthFirstSearch;
import alghoritms.graphs.search.DepthFirstSearch;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        double[] w = {10, 20, 30};
        double[] v = {60, 1, 120};

        Graph<Integer> graph = new Graph<>(7);


        Vertex<Integer> v0 = new Vertex<>(0, 1);
        Vertex<Integer> v1 = new Vertex<>(1, 10);
        Vertex<Integer> v2 = new Vertex<>(2, 20);
        Vertex<Integer> v3 = new Vertex<>(3, 30);
        Vertex<Integer> v4 = new Vertex<>(4, 40);
        Vertex<Integer> v5 = new Vertex<>(5, 50);
        Vertex<Integer> v6 = new Vertex<>(6, 60);

        graph.addEdge(v0, v1);
        graph.addEdge(v0, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v2, v4);
        graph.addEdge(v1, v3);
        graph.addEdge(v4, v5);
        graph.addEdge(v0, v5);
        graph.addEdge(v0, v6);
        graph.addEdge(v6, v4);
       // graph.addEdge(v3, v4);

        System.out.println(graph.isBipartite(v0));

    //    graph.print();
  //      System.out.println();
//
  //    DepthFirstSearch<Integer> depthFirstSearch = new DepthFirstSearch<>(graph, v0);
//
//        System.out.println(depthFirstSearch.getPathTo(v2));
//        System.out.println(depthFirstSearch.getPathTo(v2));
//        System.out.println(depthFirstSearch.getPathTo(v2));
//       // System.out.println("61 = " + depthFirstSearch.getSum());
//
//        BreadthFirstSearch<Integer> breadthFirstSearch = new BreadthFirstSearch<>(graph, v0);
//        System.out.println();
//        System.out.println(breadthFirstSearch.getShortestPath(v0, v2));
//        System.out.println(breadthFirstSearch.getShortestPath(v0, v3));
//        System.out.println(breadthFirstSearch.getShortestPath(v1, v0));
    }
}
