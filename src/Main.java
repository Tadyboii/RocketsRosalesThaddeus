import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation sim = new Simulation();
        File filePhase1 = new File("src\\phase1.txt");
        File filePhase2 = new File("src\\phase2.txt");

        //phase 1 and phase 2 for U1
        ArrayList<Rocket> u1RocketsPhase1 = sim.loadU1(sim.loadItems(filePhase1));
        ArrayList<Rocket> u1RocketsPhase2 = sim.loadU1(sim.loadItems(filePhase2));

        sim.displayBudget(u1RocketsPhase1, u1RocketsPhase2, "U1");

        //phase 1 and phase 2 for U2
        ArrayList<Rocket> u2RocketsPhase1 = sim.loadU2(sim.loadItems(filePhase1));
        ArrayList<Rocket> u2RocketsPhase2 = sim.loadU2(sim.loadItems(filePhase2));

        sim.displayBudget(u2RocketsPhase1, u2RocketsPhase2, "U2");
    }
}