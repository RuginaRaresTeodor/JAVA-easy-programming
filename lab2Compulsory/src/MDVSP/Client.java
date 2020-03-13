package MDVSP;

import java.util.Objects;

/** */
public class Client {
  private String name;
  private int order;

  /**
   * Client cu parametrii:
   *
   * @param name
   * @param order
   */
  public Client(String name, int order) {
    this.name = name;
    this.order = order;
  }

  public String getName() {
    return name;
  }

  public int getOrder() {
    return order;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  @Override
  public String toString() {
    return name + "(" + order + ")";
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 97 * hash + Objects.hashCode(this.name);
    hash = 97 * hash + this.order;
    return hash;
  }

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
    final Client other = (Client) obj;
    if (this.order != other.order) {
      return false;
    }
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    return true;
  }
}
