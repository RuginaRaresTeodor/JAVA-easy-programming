package MDVSP;

import MDVSP.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Objects;

/** */
public class Depot {

  String name;
  ArrayList<Vehicle> listOfVehicles;

  public Depot(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Vehicle> getListOfVehicles() {
    return listOfVehicles;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.name);
    hash = 97 * hash + Objects.hashCode(this.listOfVehicles);
    return hash;
  }

  /**
   * Sets a list of Vehicles
   *
   * @param listOfVehicles
   */
  public void setListOfVehicles(Vehicle... listOfVehicles) {
    this.listOfVehicles = new ArrayList<Vehicle>();
    for (Vehicle i : listOfVehicles) {
      boolean isNotEqual = true;
      int d;
      for (d = 0; this.listOfVehicles.size() > d && isNotEqual; d++)
        if (i.equals(this.listOfVehicles.get(d))) {
          isNotEqual = false;
        }
      if (isNotEqual == true && d == this.listOfVehicles.size()) {
        this.listOfVehicles.add(i);
      }
    }
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Depot other = (Depot) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.listOfVehicles, other.listOfVehicles)) {
      return false;
    }
    return true;
  }
}
