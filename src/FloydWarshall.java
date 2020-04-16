import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {

    public static int[][] solve(Graph graph) {
        int[][] d = new int[graph.getSummitsNumber()][graph.getSummitsNumber()];
        //remplissage initial
        for(int i = 0; i < graph.getSummitsNumber(); i++) {
            for(int j = 0; j < graph.getSummitsNumber(); j++) {
                if (i == j) d[i][j] = 0;
                else d[i][j] = Integer.MAX_VALUE / 4;
            }
        }
        //remplissage avec valeur des edges
        for(Edge edge : graph.getEdges()) {
            d[edge.getFrom()-1][edge.getTo()-1] = edge.getWeight();
        }
        //début du o(n^3)
        for(int k = 0; k < graph.getSummitsNumber(); k++) {
            for(int u = 0; u < graph.getSummitsNumber(); u++) {
                for(int v = 0; v < graph.getSummitsNumber(); v++) {
                    if(u != v) d[u][v] = Math.min(d[u][v], d[u][k] + d[k][v]);
                }
            }
        }
        return d;
    }
}
