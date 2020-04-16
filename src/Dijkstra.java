import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

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
    public static int[] solve(Graph G, int s) {
        int[] d = new int[G.getSummitsNumber()];
        List<Integer> F = new ArrayList<>(G.getSummits());
        for (Integer summit : F) {
            d[summit] = Integer.MAX_VALUE - 1;
        }
        d[s] = 0;
        while (!F.isEmpty()) {
            int u = extractMin(F,d);
            for (int v : G.getNeighbours().get(u)) {
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

    private static int extractMin(List<Integer> F, int[] d) {
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
