import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(4, 0.5);
        System.out.println(graph.getNeighbours());
        System.out.println(graph.getEdges()+ "\n");
        for (Integer summit : graph.getSummits()) {
//            System.out.println(graph.dijkstra(graph, summit));
//            System.out.println("dij");
            System.out.println(Arrays.toString(Dijkstra.solve(graph, summit)));
//            System.out.println();
//            System.out.println("prio");
            System.out.println(Arrays.toString(PriorityQ.solve(graph, summit)));
//            System.out.println();
        }
        System.out.println();
        int[][] res = FloydWarshall.solve(graph);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
        System.out.println(graph.getDensity());
        /*System.out.println();
        List<Integer> graph1Summits = new ArrayList<>(Arrays.asList(0,1,2,3,4,5));
        Graph graph1 = new Graph(graph1Summits);
        graph1.addEdge(0, 1, 12);
        graph1.addEdge(0, 3, 4);
        graph1.addEdge(1, 5, 1);
        graph1.addEdge(1, 3, 1);
        graph1.addEdge(1, 2, -10);
        graph1.addEdge(3, 5, 12);
        graph1.addEdge(3, 4, 4);
        graph1.addEdge(3, 2, -7);
        graph1.addEdge(5, 4, -5);
        graph1.addEdge(4, 5, 11);
        graph1.addEdge(4, 0, -4);
        graph1.addEdge(2, 4, 13);
        graph1.addEdge(2, 0, 3);

        System.out.println();
        res = FloydWarshall.solve(graph1);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
        System.out.println(graph1.getDensity());*/
    }
}
