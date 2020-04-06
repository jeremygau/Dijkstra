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
        fillSummits();
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

  /*  public List<Integer> dijkstra(Graph G, int s) {
        List<Integer> d = new ArrayList<>();
        List<Integer> F = new ArrayList<>(summits);
        for (Integer summit : F) {
            d.add(Integer.MAX_VALUE - 1);
        }
        d.set(s, 0);
        while (!F.isEmpty()) {
            int u = extractMin(F,d);
            for (int v : neighbours.get(u)) {
                if (d.get(v) > d.get(u) + 1) {
                    d.set(v, d.get(u) + 1);
                }
            }
        }
        return d;
    }
*/
    public int[] dijkstra(Graph G, int s) {
        int[] d = new int[summitsNumber];
        List<Integer> F = new ArrayList<>(summits);
        for (Integer summit : F) {
            d[summit] = Integer.MAX_VALUE - 1;
        }
        d[s] = 0;
        while (!F.isEmpty()) {
            int u = extractMin(F,d);
            for (int v : neighbours.get(u)) {
                if (d[v] > d[u] + 1) {
                    d[v] = d[u] + 1;
                }
            }
        }
        return d;
    }

/*    public int extractMin(List<Integer> F, List<Integer> d) {
        Integer vMin = F.get(0);
        for(Integer summit : F) {
            if(!summit.equals(vMin) && d.get(vMin) > d.get(summit)) vMin = summit;
        }
        F.remove(vMin);
        return vMin;
    }*/

    public int extractMin(List<Integer> F, int[] d) {
        Integer vMin = F.get(0);
        for(Integer summit : F) {
            if(!summit.equals(vMin) && d[vMin] > d[summit]) vMin = summit;
        }
        F.set(F.indexOf(vMin), F.get(F.size()-1));
        F.set(F.size()-1, vMin);
        F.remove(F.size()-1);
        return vMin;
    }
}
