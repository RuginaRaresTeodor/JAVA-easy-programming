package MDVSP.vehicles;

import MDVSP.vehicles.AbstractVehicle;

public class Truck extends AbstractVehicle {
  /** @param name */
  public Truck(String name) {
    super(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
