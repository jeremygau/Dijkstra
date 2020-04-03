import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {

    int summitsNumber;
    int edgeNumber;
    double density; // nb arrete existants / nb arretes possible n(n-1)
    List<Integer> summits;
    List<List<Integer>> neighbours;

    public Graph(int summitsNumber, double density) {
        this.summitsNumber = summitsNumber;
        this.edgeNumber = 0;
        this.density = density;
        this.summits = new ArrayList<>();

        this.neighbours = new ArrayList<>();
        fillNeighbours();
        createEdges();
    }

    private void fillSummits() {
        for (int i = 0; i < summitsNumber; i++) {
            summits.add(i);
        }
    }

    private void fillNeighbours() {
        for (int i = 0; i < summitsNumber; i++) {
            neighbours.add(new ArrayList<>());
        }
    }

    private void createEdges() {
        while (density > (double)edgeNumber /(summitsNumber*(summitsNumber-1))) {
            addNeighbour();
        }
    }

    private void addNeighbour() {
        Random random = new Random();
        int summitA;
        int summitB;
        do {
            summitA = random.nextInt(summitsNumber);
            summitB = random.nextInt(summitsNumber);
        }
        while (summitA == summitB);
        if (!edgeExists(summitA, summitB)) {
            neighbours.get(summitA).add(summitB);
            edgeNumber++;
        }
    }

    public boolean edgeExists(int summitA, int summitB) {
        return neighbours.get(summitA).contains(summitB);
    }

    public List<List<Integer>> getNeighbours() {
        return neighbours;
    }

    public int[] dijkstra(Graph G, int s) {
        int[] d = new int[summitsNumber];
        List<Integer> F = new ArrayList<>(summits);
        for (Integer summit : F) {
            d[summit] = Integer.MAX_VALUE;
        }
        d[s] = 0;


        return d;
    }
}
