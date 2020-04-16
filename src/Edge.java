public class Edge {

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
}
