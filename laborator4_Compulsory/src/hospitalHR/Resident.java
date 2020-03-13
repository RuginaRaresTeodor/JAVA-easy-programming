package hospitalHR;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Resident implements Comparable<Resident>  {
    String name;
    List<Hospital> preferences=new ArrayList<>();

    public void setPreferences(List<Hospital> preferences) {
        this.preferences = preferences;
    }
    public Resident(String name) {
        this.name = name;
    }
    public List<Hospital> getPreferences() {
        return preferences;
    }
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.name);
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
        final Resident other = (Resident) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name ;
    }


    @Override
    public int compareTo(Resident r) {
        return Comparators.NAME.compare(this, r);
    }
    public static class Comparators {

        public static Comparator<Resident> NAME = new Comparator<Resident>() {
            @Override
            public int compare(Resident r1, Resident r2) {
                return r1.name.compareTo(r2.name);
            }
        };

    }
}


