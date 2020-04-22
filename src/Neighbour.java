public class Neighbour {

    private Integer summit;
    private int weight;

    public Neighbour(Integer summit, int weight) {
        this.summit = summit;
        this.weight = weight;
    }

    public Integer getSummit() {
        return summit;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "<" + summit + ", " + weight + ">";
    }
}
