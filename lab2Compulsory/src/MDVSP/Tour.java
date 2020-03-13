package MDVSP;

import MDVSP.vehicles.Vehicle;
import java.util.ArrayList;

public class Tour {

  Vehicle vehicle;
  Depot depot;
  ArrayList<Client> clients;

  /**
   * @param vehicle
   * @param depot
   * @param clients
   */
  public Tour(Vehicle vehicle, Depot depot, ArrayList<Client> clients) {
    this.vehicle = vehicle;
    this.depot = depot;
    this.clients = clients;
  }

  public Tour() {}

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public void setDepot(Depot depot) {
    this.depot = depot;
  }

  public void setClients(ArrayList<Client> clients) {
    this.clients = clients;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public Depot getDepot() {
    return depot;
  }

  public ArrayList<Client> getClients() {
    return clients;
  }

  @Override
  public String toString() {
    return vehicle + ":" + depot + "->" + clients + "->" + depot + "\n";
  }
}
