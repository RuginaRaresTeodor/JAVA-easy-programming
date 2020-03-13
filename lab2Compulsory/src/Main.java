import MDVSP.Client;
import MDVSP.Depot;
import MDVSP.Problem;
import MDVSP.Solution;
import MDVSP.vehicles.AbstractVehicle;
import MDVSP.vehicles.Vehicle;
import MDVSP.vehicles.Vehicle.VehicleType;

/** I'm the boss author: Rares */
public class Main {
  public static void main(String[] args) {
    Depot d1 = new Depot("D1");
    Depot d2 = new Depot("D2");

    Vehicle v1 = new Vehicle("V1", VehicleType.AUTO);
    Vehicle v2 = new Vehicle("V2", VehicleType.TRUCK);
    Vehicle v3 = new Vehicle("V3", VehicleType.DRONE);

    Client c1 = new Client("C1", 1);
    Client c2 = new Client("C2", 1);
    Client c6 = new Client("C2", 1);
    Client c3 = new Client("C3", 2);
    Client c4 = new Client("C4", 2);
    Client c5 = new Client("C5", 3);

    d1.setListOfVehicles(v1, v2);
    d2.setListOfVehicles(v3);
    Problem p1 = new Problem();
    p1.setClients(c1, c2, c3, c4, c5, c6);
    p1.setDepot(d1, d2);

    Solution s = new Solution();
    System.out.println("Clients:" + p1.getClients());
    System.out.println("Depots:" + p1.getDepots());
    System.out.println("Vehicles:" + p1.getVehicles());
    s.generateTours(p1.getDepots(), p1.getVehicles(), p1.getClients());
    System.out.println(s);
  }
}
