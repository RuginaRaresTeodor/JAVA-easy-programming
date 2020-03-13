package MDVSP.vehicles;

import MDVSP.vehicles.AbstractVehicle;

public class Car extends AbstractVehicle {
  /** @param name */
  public Car(String name) {
    super(name);
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
