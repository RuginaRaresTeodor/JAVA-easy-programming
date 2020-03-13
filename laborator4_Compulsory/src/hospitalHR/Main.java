package hospitalHR;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        Resident r0=new Resident("R0");
        Resident r1=new Resident("R1");
        Resident r2=new Resident("R2");
        Resident r3=new Resident("R3");
        Resident r4=new Resident("R4");
        Hospital h0=new Hospital("H0",1);
        Hospital h1=new Hospital("H1",2);
        Hospital h2=new Hospital("H2",2);
        Hospital h3=new Hospital("H3",3);
        List<Resident> residentList=new ArrayList<>();
        residentList.add(r0);
        residentList.add(r1);
        residentList.add(r2);
        residentList.add(r3);
        Collections.sort(residentList, Resident.Comparators.NAME);
        Set hospitalSet= new TreeSet<>();
        hospitalSet.add(h0);
        hospitalSet.add(h1);
        hospitalSet.add(h2);
        List<Hospital> preferences1=new ArrayList<>();
        preferences1.add(h0);
        preferences1.add(h1);
        preferences1.add(h2);
        List<Hospital> preferences2=new ArrayList<>();
        preferences2.add(h0);
        preferences2.add(h1);
        List<Hospital> preferences3=new ArrayList<>();
        preferences3.add(h0);
        preferences3.add(h2);
        r0.setPreferences(preferences1);
        r1.setPreferences(preferences1);
        r2.setPreferences(preferences2);
        r3.setPreferences(preferences3);
        Map<Resident,List<Hospital>> map=new LinkedHashMap<>();
        map.put(r0,r0.getPreferences());
        map.put(r1,r1.getPreferences());
        map.put(r2,r2.getPreferences());
        map.put(r3,r3.getPreferences());
        System.out.print("Residents preferences:\n");
        Set< Map.Entry<Resident,List<Hospital>>> st= map.entrySet();
        for(Map.Entry<Resident,List<Hospital>> me:st)
        {
            System.out.print(me.getKey()+":");
            System.out.println(me.getValue());
        }
        List<Resident> list1=new ArrayList<>();
        list1.add(r3);
        list1.add(r0);
        list1.add(r1);
        list1.add(r2);
        h0.setResidentsList(list1);
        List<Resident> list2=new ArrayList<>();
        list2.add(r0);
        list2.add(r2);
        list2.add(r1);
        h1.setResidentsList(list2);
        List<Resident> list3=new ArrayList<>();
        list3.add(r0);
        list3.add(r1);
        list3.add(r3);
        h2.setResidentsList(list3);
        Map<Hospital,List<Resident>> map2=new HashMap<>();
        map2.put(h0,h0.getResidentsList());
        map2.put(h1,h1.getResidentsList());
        map2.put(h2,h2.getResidentsList());
        System.out.print("\nHotels preferences:\n");
        Set< Map.Entry<Hospital,List<Resident>>>st1= map2.entrySet();
        for(Map.Entry<Hospital,List<Resident>> me:st1)
        {
            System.out.print(me.getKey()+":");
            System.out.println(me.getValue());
        }

        List<Resident> rFilteredList=residentList.stream()
                .filter(emp->emp.getPreferences().contains(h1))
                .filter(emp->emp.getPreferences().contains(h0))
                .collect(Collectors.toList());

        System.out.println("\nResidents who find acceptable H0 and H1:");
        System.out.println(rFilteredList);

        List<Hospital> hFilteredList=preferences1.stream()
                .filter(emp->emp.getResidentsList().get(2).equals(r3))
                .collect(Collectors.toList());
        System.out.println("\nHospitals that have R1 as their last preference:");
        System.out.println(hFilteredList);

    }

}
