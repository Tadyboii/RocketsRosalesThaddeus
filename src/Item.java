public class Item {
    String name;
    int weight;

    public Item(String s, int w) {
        this.name = s;
        this.weight = w;
    }


    @Override
    public String toString() {
        return "Name: " + name + " Weight: " + weight;
    }
}
