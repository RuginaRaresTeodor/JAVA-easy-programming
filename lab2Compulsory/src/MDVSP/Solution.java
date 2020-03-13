package MDVSP;

import MDVSP.vehicles.Vehicle;
import java.util.ArrayList;

public class Solution {
  ArrayList<Tour> tours;

  /**
   * Solutia pentru Tururile facute de clienti
   *
   * @param depots
   * @param vehicles
   * @param clients
   */
  public void generateTours(
      ArrayList<Depot> depots, ArrayList<Vehicle> vehicles, ArrayList<Client> clients) {
    tours = new ArrayList<Tour>();
    int numberOfTours = vehicles.size();
    int pas = clients.size() / numberOfTours;
    int start = 0;
    for (Depot i : depots) {
      for (Vehicle j : i.getListOfVehicles()) {
        Tour tour = new Tour();
        tour.setDepot(i);
        tour.setVehicle(j);
        ArrayList<Client> clientsChoose = new ArrayList<>();
        for (int l = start; l <= pas; l++) {
          clientsChoose.add(clients.get(l));
        }
        start = start + pas;
        pas = pas + clientsChoose.size() - 1;
        tour.setClients(clientsChoose);
        tours.add(tour);
      }
    }
  }

  @Override
  public String toString() {
    return "Solution:\n" + tours;
  }
}
