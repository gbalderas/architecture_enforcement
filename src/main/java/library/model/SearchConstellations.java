package library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gerardo.balderas on 15.03.2016.
 */
public class SearchConstellations {

    public static ObservableList<String> getConstellations(String query){
        List<String> list = ConstellationMap.getConstellationMap().entrySet().stream()
                .filter(item -> containsQuery(item.getValue(), query.toLowerCase()))
                .map(item -> item.getValue().getName())
                .collect(Collectors.toList());

        return FXCollections.observableArrayList(list);
    }

    public static Boolean containsQuery(Constellation constellation, String query){
        return (constellation.getName().toLowerCase().contains(query)
                        || constellation.getAbbreviation().toLowerCase().contains(query)
                        || constellation.getFamily().toLowerCase().contains(query));
    }
}
