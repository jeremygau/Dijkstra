import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQ {

    public static int[] solve(Graph G, int s) {
        int[] d = new int[G.getSummitsNumber()];
        List<Integer> S = new ArrayList<>(G.getSummits());
        PriorityQueue<Edge> F = new PriorityQueue<>();
        for (Integer summit : S) {
            d[summit] = Integer.MAX_VALUE - 1;
        }
        d[s] = 0;
        fillQueue(F, G, s);
        while (!F.isEmpty()) {
            Edge edge = F.poll();
            int v = edge.getTo();
            int u = edge.getFrom();
            int w = edge.getWeight();
            if (d[v] > d[u] + w) {
                d[v] = d[u] + w;
                fillQueue(F, G, v);
            }
        }
        return d;
    }

    private static void fillQueue(PriorityQueue<Edge> F, Graph G, Integer from) {
        for (Edge edge : G.getEdges()) {
            if (edge.getFrom().equals(from)) {
                F.add(edge);
            }
        }
    }

}
