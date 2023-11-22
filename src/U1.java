public class U1 extends Rocket {

    public U1() {
        cost = 100;
        weight = 10000;
        maxWeight = 18000;
    }

    @Override
    public boolean launch() {
        double randomValue = Math.random() * 100;
        return !(randomValue < 5 * ((double) carried / (maxWeight-weight)));
    }

    @Override
    public boolean land() {
        double randomValue = Math.random() * 100;
        return !(randomValue < 1 * ((double) carried / (maxWeight-weight)));
    }
}
