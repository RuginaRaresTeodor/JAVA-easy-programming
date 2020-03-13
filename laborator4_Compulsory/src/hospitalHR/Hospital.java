package hospitalHR;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hospital implements Comparable<Hospital> {
    String name;
    int capacity;
    List<Resident> residentsList=new ArrayList<>();

    public List<Resident> getResidentsList() {
        return residentsList;
    }

    public void setResidentsList(List<Resident> residentsList) {
        this.residentsList = residentsList;
    }

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int compareTo(Hospital h){
        if(capacity==h.capacity && name==h.name)
            return 0;
        else if(capacity<h.capacity)
            return 1;
        else
            return -1;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Hospital other = (Hospital) obj;
        if (this.capacity != other.capacity) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return name ;
    }


}
