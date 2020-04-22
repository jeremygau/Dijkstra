import java.util.ArrayList;
import java.util.Arrays;
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
        //remplir la PQ
        for (int from = 0; from < G.getSummitsNumber(); from++) {
//        int from = s;
            for (int to = 0; to < G.getNeighbours().get(from).size(); to++) {
                F.add(new Edge(from, G.getNeighbours().get(from).get(to), 1));
            }
        }
        while (!F.isEmpty()) {
            Edge edge = F.poll();
            int v = edge.getTo();
            int u = edge.getFrom();
//            int u = s;
//            System.out.println(Arrays.toString(d));
            if (d[v] > d[u] + 1 && d[u] < Integer.MAX_VALUE - 1) {
                d[v] = d[u] + 1;
            }
            else {
                F.add(edge);
            }

//            int u = s;
//            for (Integer v : G.getNeighbours().get(u)) {
//                if (d[v] > d[u] + 1) {
//                    d[v] = d[u] + 1;
//                }
//            }
        }
        return d;
    }

}
