public class Rocket implements SpaceShip {
    public int carried = 0;
    public int cost;
    public int weight;
    public int maxWeight;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (item.weight + (weight + carried)) <= maxWeight;
    }

    @Override
    public void carry(Item item) {
        carried += item.weight;
    }
}
