public class Edge implements Comparable {

    private Integer from;
    private Integer to;
    private int weight;

    public Edge(Integer from, Integer to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        return this.weight - e.getWeight();
    }

    @Override
    public String toString() {
        return "{" +
                from +
                " -> " + to +
                ", " + weight +
                '}';
    }
}
