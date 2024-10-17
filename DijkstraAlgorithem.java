package Dsa.java;
import java.util.*;

public class DijkstraAlgorithem {
    //Finds the vertex with the minimum distance that hasn't been proceed yet
    private static int findMainDistance(int[] dist, boolean[]sptSet, int vertices){
        //Initialize min as a infinity
        int min = Integer.MAX_VALUE, minIndex = -1;
        //Loop through each vertex 
        for (int v= 0; v< vertices; v++){
            //If vertex is not processed (in sptSet) and distance is less than current min, update min.
            if(!sptSet[v] && dist[v] <= min){
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    //Main function
    public static void dijkstra(int[][] graph, int source){
        //determin the number of vertex by getting length of 2D array 
        int vertices = graph.length;
        //Creates an array dist to store the shortest distance from the source node to every other node
        int [] dist = new int [vertices];
        //Creates a sptSet array that helps track which nodes have been processed (
        boolean [] sptSet = new boolean [vertices];
        //initially the distance to all vertices is assumed unreachble 
        Arrays.fill(dist, Integer.MAX_VALUE);
        //no verticess are proceded yet
        Arrays.fill(sptSet, false);
        //distance to the source node is 0
        dist[source] =0;
        // in for loop 
        /*
         * Find the unvisited vertex with the minimum distance.
           Mark it as visited.
           For each unvisited neighbor, calculate the new distance.
           If a shorter path is found, update the distance.
           Repeat until all vertices are processed.
         */
        for(int count = 0; count<vertices-1;count++){
            int u = findMainDistance(dist, sptSet, vertices);
            sptSet[u] = true;
            for(int v =0;v<vertices; v++){
                if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v]<dist[v]){
                    dist[v] = dist[u]+graph[u][v];
                } 
            }
        }
        solutionoutput(dist, vertices);
    }
    //Prints out the shortest distance from the source node to each vertex.
    private static void solutionoutput(int [] dist, int vertices){
        System.out.println("Vertex \t Distance from Source");
        for(int i =0; i<vertices;i++){
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
    public static void main(String[] args) {
        int [][] graph = new int[][]{
            {0, 10, 0, 30, 100},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {100, 0, 10, 60, 0},
        };
        DijkstraAlgorithem.dijkstra(graph, 0);
    }
    
}
