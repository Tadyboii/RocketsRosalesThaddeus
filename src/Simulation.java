import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Simulation {
    public Simulation() {
    }

    public ArrayList<Item> loadItems(File file) throws FileNotFoundException {
        ArrayList<Item> list = new ArrayList<>();
        Scanner fileScan = new Scanner(file);
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            String[] splitStr = line.split("=", 2);
            String name = splitStr[0];
            int weight = Integer.parseInt(splitStr[1]);
            Item item = new Item(name, weight);
            list.add(item);
        }
        return list;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> rocketList = new ArrayList<>();
        while (!items.isEmpty()) {
            Rocket u1 = new U1();
            for (int i = items.size() - 1; i >= 0; i--) {
                if (u1.canCarry(items.get(i))) {
                    u1.carry(items.get(i));
                    items.remove(i);
                }
            }
            rocketList.add(u1);
        }
        return rocketList;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> rocketList = new ArrayList<>();
        while (!items.isEmpty()) {
            Rocket u2 = new U2();
            for (int i = items.size() - 1; i >= 0; i--) {
                if (u2.canCarry(items.get(i))) {
                    u2.carry(items.get(i));
                    items.remove(i);
                }
            }
            rocketList.add(u2);
        }
        return rocketList;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int budget = 0;
        for (Rocket rocket : rockets) {
            boolean noFailure = false;
            boolean launch = rocket.launch();
            while (!noFailure) {
                budget += rocket.cost;
                if (launch) {
                //successful launch
                    boolean land = rocket.land();
                    if (land) {
                    //successful land
                        noFailure = true;
                    } else {
                    // failure land (re-launch)
                        launch = rocket.launch();
                    }
                } else {
                //failure launch (re-launch)
                    launch = rocket.launch();
                }

            }
        }
        return budget;
    }

    public void displayBudget(ArrayList<Rocket> phase1, ArrayList<Rocket> phase2, String type) {
        for (int i = 0; i < phase1.size(); i++) {
            System.out.println(type + " Rocket(Phase1) " + (i + 1) + ": " + phase1.get(i).carried + " kgs (Cargo Weight)");
        }
        for (int i = 0; i < phase2.size(); i++) {
            System.out.println(type + " Rocket(Phase2) " + (i + 1) + ": " + phase2.get(i).carried + " kgs (Cargo Weight)");
        }
        int p1 = runSimulation(phase1);
        int p2 = runSimulation(phase2);
        System.out.println("Budget(Phase1): $" + p1 + " M (Phase2): $" + p2 + " M");
        System.out.println("Total: $" + (p1 + p2) + " M");
    }

}
