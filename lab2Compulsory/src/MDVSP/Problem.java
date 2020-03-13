package MDVSP;

import MDVSP.vehicles.Vehicle;
import java.util.ArrayList;

public class Problem {
  ArrayList<Depot> depots;
  ArrayList<Vehicle> vehicles;
  ArrayList<Client> clients;

  /**
   * A client can't be accepted 2 times in the same interval of time
   *
   * @param clients
   */
  public void setClients(Client... clients) {
    this.clients = new ArrayList<Client>();
    for (Client i : clients) {
      int j;
      boolean isNotEqual = true;
      for (j = 0; j < this.clients.size() && isNotEqual; j++) {
        if (i.equals(this.clients.get(j))) {
          isNotEqual = false;
        }
      }
      if (isNotEqual == true && j == this.clients.size()) {
        this.clients.add(i);
      }
    }
  }

  /**
   * Not more than 2 clients on a single depot
   *
   * @param depots
   */
  public void setDepot(Depot... depots) {
    this.depots = new ArrayList<Depot>();
    for (Depot i : depots) {
      int j;
      boolean isNotEqual = true;
      for (j = 0; j < this.depots.size() && isNotEqual; j++) {
        if (i.equals(this.depots.get(j))) {
          isNotEqual = false;
        }
      }
      if (isNotEqual == true && j == this.depots.size()) {
        this.depots.add(i);
      }
    }
  }

  public ArrayList<Vehicle> getVehicles() {
    this.vehicles = new ArrayList<Vehicle>();
    for (Depot i : this.depots) {
      for (Vehicle j : i.getListOfVehicles()) {
        vehicles.add(j);
      }
    }
    return vehicles;
  }

  public ArrayList<Depot> getDepots() {
    return depots;
  }

  public ArrayList<Client> getClients() {
    return clients;
  }

  @Override
  public String toString() {
    return "Problem:\n"
        + "depots="
        + depots
        + ",\nclients="
        + clients
        + "\nvehicles="
        + getVehicles()
        + '}';
  }
}
