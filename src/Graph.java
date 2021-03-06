import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {

    private int summitsNumber;
    private int edgeNumber;
    private double density; // nb arrete existants / nb arretes possible n(n-1)
    private List<Integer> summits;
    private List<List<Neighbour>> neighbours;
    private List<Edge> edges;
    private Random random = new Random();

    public Graph(int summitsNumber, double density) {
        this.summitsNumber = summitsNumber;
        this.edgeNumber = 0;
        this.density = density;
        this.summits = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.neighbours = new ArrayList<>();
        fillSummits();
        fillNeighbours();
        createEdges();
    }

    public Graph(List<Integer> summits) {
        this.summitsNumber = summits.size();
        this.edgeNumber = 0;
        this.summits = summits;
        this.edges = new ArrayList<>();
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

    public void addEdge(Integer from, Integer to, int weight) {
        edges.add(new Edge(from, to, weight));
    }

    private void addNeighbour() {
        int summitA;
        int summitB;
        do {
            summitA = random.nextInt(summitsNumber);
            summitB = random.nextInt(summitsNumber);
        }
        while (summitA == summitB);
        if (!edgeExists(summitA, summitB)) {
            Random random1 = new Random();
            int weight = random1.nextInt(10);
            neighbours.get(summitA).add(new Neighbour(summitB, weight));
            addEdge(summitA, summitB, weight);
            edgeNumber++;
        }
    }

    public boolean edgeExists(int summitA, int summitB) {
        for (Neighbour neighbour : neighbours.get(summitA)) {
            if (neighbour.getSummit().equals(summitB)) {
                return true;
            }
        }
        return false;
    }

    public List<List<Neighbour>> getNeighbours() {
        return neighbours;
    }

    public int getSummitsNumber() {
        return summitsNumber;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public double getDensity() {
        return density;
    }

    public List<Integer> getSummits() {
        return summits;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
