import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        test();

    }

    public static void test() {
        Graph graph = new Graph(4, 0.5);
        System.out.println(graph.getNeighbours());
        System.out.println(graph.getEdges()+ "\n");
        for (Integer summit : graph.getSummits()) {
            System.out.println("distance pour sommet " + summit);
            System.out.println("sequentielle\t" + Arrays.toString(Dijkstra.solve(graph, summit)));
            System.out.println("Priority : \t\t" +Arrays.toString(PriorityQ.solve(graph, summit)));
            System.out.println();

        }
    }

    public static void compare() {
        int nb = 1;
        long antes = System.currentTimeMillis();
        int moyenneSeq = 0;
        int moyenneprio = 0;
        for (int i = 0; i < nb; i++) {
            Graph graph = new Graph(100, 0.1);
            System.out.println(graph.getNeighbours());
            System.out.println(graph.getEdges()+ "\n");
            long before = System.currentTimeMillis();
            for (Integer summit : graph.getSummits()) {
                Dijkstra.solve(graph, summit);
            }
            moyenneSeq += System.currentTimeMillis() - before;
            before = System.currentTimeMillis();
            for (Integer summit : graph.getSummits()) {
                PriorityQ.solve(graph, summit);
            }
            moyenneprio += System.currentTimeMillis() - before;
        }
        System.out.println(System.currentTimeMillis() - antes);
        System.out.println("moyenne sequentielle : " + moyenneSeq / nb);
        System.out.println("moyenne Priority : " + moyenneprio / nb);
    }

    public static void floyd() {
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
        int[][] res = FloydWarshall.solve(graph1);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
        System.out.println(graph1.getDensity());
    }
}
