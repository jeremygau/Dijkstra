import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(4, 0.5);
        System.out.println(graph.getNeighbours() + "\n");
        for (Integer summit : graph.summits) {
//            System.out.println(graph.dijkstra(graph, summit));
            System.out.println(Arrays.toString(graph.dijkstra(graph, summit)));
            System.out.println();
        }
    }
}
