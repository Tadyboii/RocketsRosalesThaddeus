public class U2 extends Rocket {

    public U2() {
        cost = 120;
        weight = 18000;
        maxWeight = 29000;
    }

    @Override
    public boolean launch() {
        double randomValue = Math.random() * 100;
        return !(randomValue < 4 * ((double) carried / maxWeight));
    }

    @Override
    public boolean land() {
        double randomValue = Math.random() * 100;
        return !(randomValue < 8 * ((double) carried / maxWeight));
    }
}
