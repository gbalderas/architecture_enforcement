package library.model;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by gerardo.balderas on 15.03.2016.
 */
public class ConstellationMapMock {

    private Map<String,Constellation> constellationMap = new TreeMap<>();

    public ConstellationMapMock() {

        try {
            addConstellations(
                    new Constellation("Andromeda", "Andr", "Perseus", "Andromeda"),
                    new Constellation("Antila", "Antl", "La Caille", "airpump"),
                    new Constellation("Apus;Apus;Bayer;Bird of Paradise"),
                    new Constellation("Aquarius;Aqar;Zodiac;water-bearer"),
                    new Constellation("Aquila", "Aqil", "Hercules", "eagle"),
                    new Constellation("Ara;Arae;Hercules;altar"),
                    new Constellation("Aries", "Arie", "Zodiac", "ram"),
                    new Constellation("Auriga;Auri;Perseus;charioteer"),
                    new Constellation("Boötes;Boot;Ursa Major;herdsman"),
                    new Constellation("Caelum;Cael;La Caille;chisel or graving tool"),
                    new Constellation("Camelopardalis;Caml;Ursa Major;giraffe"),
                    new Constellation("Cancer", "Canc", "Zodiac", "crab"),
                    new Constellation("Canes Venatici;CVen;Ursa Major;hunting dogs"),
                    new Constellation("Canis Major;CMaj;Orion;greater dog"),
                    new Constellation("Canis Minor;CMin;Orion;lesser dog"),
                    new Constellation("Capricornus", "Cpr", "Zodiac", "sea goat"),
                    new Constellation("Carina;Cari;Heavenly Waters;keel"),
                    new Constellation("Cassiopeia;Cass;Perseus; Cassiopeia"),
                    new Constellation("Centaurus;Cent;Hercules;centaur"),
                    new Constellation("Cepheus;Ceph;Perseus;Cepheus"),
                    new Constellation("Cetus;Ceti;Perseus;sea monster"),
                    new Constellation("Chamaelon;Cham;Bayer;chameleon"),
                    new Constellation("Circinus;Circ;La Caille;compass"),
                    new Constellation("Columba;Colm;Heavenly Waters;dove"),
                    new Constellation("Coma Berenices;Coma;Ursa Major;Bernice's hair"),
                    new Constellation("Corona Australis;CorA;Hercules;southern crown"),
                    new Constellation("Corona Borealis;CorB;Ursa Major;northern crown"),
                    new Constellation("Corvus;Corv;Hercules;crow"),
                    new Constellation("Crater;Crat;Hercules;cup"),
                    new Constellation("Crux;Cruc;Hercules;southern cross"),
                    new Constellation("Cygnus;Cygn;Hercules;swan or northern cross"),
                    new Constellation("Delphinus;Dlph;Heavenly Waters;dolphin"),
                    new Constellation("Dorado;Dora;Bayer;goldfish"),
                    new Constellation("Draco;Drac;Ursa Major;dragon"),
                    new Constellation("Equuleus;Equl;Heavenly Waters;pony"),
                    new Constellation("Eridanus;Erid;Heavenly Waters;Erdanus river"),
                    new Constellation("Fornax;Forn;LaCaille;chemical furnace"),
                    new Constellation("Gemini;Gemi;Zodiac;twins"),
                    new Constellation("Grus;Grus;Bayer;Crane"),
                    new Constellation("Hercules;Herc;Hercules;Hercules"),
                    new Constellation("Horologium;Horo;La Caille;pendulum clock"),
                    new Constellation("Hydra;Hyda;Hercules;Hydra"),
                    new Constellation("Hydrus;Hydi;Bayer;lesser water snake"),
                    new Constellation("Indus;Indi;Bayer;Indian"),
                    new Constellation("Lacerta;Lacr;Perseus;lizard"),
                    new Constellation("Leo;Leon;Zodiac;lion"),
                    new Constellation("Leo Minor;LMin;Ursa Major;lesser lion"),
                    new Constellation("Lepus;Leps;Orion;hare"),
                    new Constellation("Libra;Libr;Zodiac;balance"),
                    new Constellation("Lupus;Lupi;Hercules;wolf"),
                    new Constellation("Lynx;Lync;Ursa Major;lynx"),
                    new Constellation("Lyra;Lyra;Hercules;lyre/harp"),
                    new Constellation("Mensa;Mens;La Caille; Table Mountain"),
                    new Constellation("Microscopium;Micr;La Caille; microscope"),
                    new Constellation("Monoceros;Mono;Orion;unicorn"),
                    new Constellation("Musca;Musc;Bayer;fly"),
                    new Constellation("Norma;Norm;La Caille; carpenter's level"),
                    new Constellation("Octancs; Octn; La Caille; octant"),
                    new Constellation("Ophichus;Ophi;Hercules;serpent-bearer"),
                    new Constellation("Orion;Orio;Orion;Orion"),
                    new Constellation("Pavo;Pavo;Bayer;peacock"),
                    new Constellation("Pegasus;Pegs;Perseus;Pegasus"),
                    new Constellation("Perseus;Pers;Perseus;Perseus"),
                    new Constellation("Phoenix;Phoe;Bayer;Phoenix"),
                    new Constellation("Pictor;Pict;La Caille;easel"),
                    new Constellation("Pisces;Pisc;Zodiac;fishes"),
                    new Constellation("Piscis Austrinus;PscA;Heavenly Waters;southern fish"),
                    new Constellation("Puppis;Pupp;Heavenly Waters;poop deck"),
                    new Constellation("Pyxis;Pyxi;Heavenly Waters; mariner's compass"),
                    new Constellation("Reticulum;Reti;La Caille; eyepiece graticule"),
                    new Constellation("Sagitta;Sgte;Hercules;arrow"),
                    new Constellation("Sagittarius;Sgtr;Zodiac;archer"),
                    new Constellation("Scorpius;Scor;Zodiac;scorpion"),
                    new Constellation("Sculptor;Scul;La Caille;sculptor"),
                    new Constellation("Scutum;Scut;Hercules;shield"),
                    new Constellation("Serpens;Serp;Hercules;snake"),
                    new Constellation("Sextans;Sext;Hercules;sextant"),
                    new Constellation("Taurus;Taur;Zodiac;bull"),
                    new Constellation("Telescopium;Tele;La Caille;telescope"),
                    new Constellation("Triagulum;Tria;Perseus;triangle"),
                    new Constellation("Triangulum Australe;TrAu;Hercules;southern triangle"),
                    new Constellation("Tucana;Tucn;Bayer;toucan"),
                    new Constellation("Ursa Major;UMaj;Ursa Major;greater bear"),
                    new Constellation("Ursa Minor;UMin;Ursa Major;lesser bear"),
                    new Constellation("Vela;Velr;Heavenly Waters; sails"),
                    new Constellation("Virgo;Virg;Zodiac;virgin or maiden"),
                    new Constellation("Volans;Voln;Bayer;flying fish"),
                    new Constellation("Vulpecula;Vulp;Hercules;fox"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void addConstellations(Constellation... constellations){
        Arrays.stream(constellations).forEach(c -> constellationMap.put(c.getName(), c));
    }

    public Map<String, Constellation> getConstellationMap() {
        return constellationMap;
    }
}
