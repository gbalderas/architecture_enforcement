package library.model;

/**
 * Created by gerardo.balderas on 15.03.2016.
 */
public class Constellation{

    private final String name;
    private final String abbreviation;
    private final String family;
    private final String meaning;


    public Constellation(String name,String abbreviation, String family, String meaning) {
        this.name = name;
        this.family = family;
        this.abbreviation = abbreviation;
        this.meaning = meaning;
    }

    public Constellation(String info) throws Exception {
        String[] array = info.split(";");
        if(array.length != 4){
            throw new Exception("Constellation Constructor is false on: "+info);
        }
        this.name = array[0];
        this.abbreviation = array[1];
        this.family = array[2];
        this.meaning = array[3];


    }


    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getMeaning() {
        return meaning;
    }

}
