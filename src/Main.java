import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(4, 0.5);
        System.out.println(graph.getNeighbours() + "\n");
        for (Integer summit : graph.getSummits()) {
//            System.out.println(graph.dijkstra(graph, summit));
            System.out.println(Arrays.toString(Dijkstra.solve(graph, summit)));
        }
        System.out.println();
        List<Integer> graph1Summits = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Graph graph1 = new Graph(graph1Summits);
        graph1.addEdge(1, 2, 12);
        graph1.addEdge(1, 4, 4);
        graph1.addEdge(2, 6, 1);
        graph1.addEdge(2, 4, 1);
        graph1.addEdge(2, 3, -10);
        graph1.addEdge(4, 6, 12);
        graph1.addEdge(4, 5, 4);
        graph1.addEdge(4, 3, -7);
        graph1.addEdge(6, 5, -5);
        graph1.addEdge(5, 6, 11);
        graph1.addEdge(5, 1, -4);
        graph1.addEdge(3, 5, 13);
        graph1.addEdge(3, 1, 3);
        int[][] res = FloydWarshall.solve(graph1);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
        System.out.println(graph1.getDensity());
    }
}
