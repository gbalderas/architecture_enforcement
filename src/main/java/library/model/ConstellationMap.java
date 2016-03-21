package library.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by gerardo.balderas on 15.03.2016.
 */
public class ConstellationMap {

    private static Map<String,Constellation> constellationMap= new TreeMap<>();

//    public void addConstellations(Constellation... constellations){
//        Arrays.stream(constellations).forEach(c -> constellationMap.put(c.getName(), c));
//    }
//
//    public static void addConstellations(Constellation constellation){
//        constellationMap.put(constellation.getName(), constellation);
//    }

    public static void setConstellationMap(Map<String, Constellation> constellationMap) {
        ConstellationMap.constellationMap = constellationMap;
    }

    public static Map<String, Constellation> getConstellationMap() {
        return constellationMap;
    }

    public static Constellation getConstellation(String name){
        return constellationMap.get(name);
    }

}
