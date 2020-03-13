package MDVSP.vehicles;

import MDVSP.vehicles.AbstractVehicle;

public class Drone extends AbstractVehicle {

  public Drone(String name) {
    super(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
