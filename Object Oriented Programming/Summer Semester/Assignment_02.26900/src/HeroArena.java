import java.util.LinkedHashMap;
import java.util.Set;

public class HeroArena {
    private LinkedHashMap<String, Superhero> heroMap;

    public HeroArena() {
        heroMap = new LinkedHashMap<>();
        heroMap.put("BAT", Superhero.BATMAN);
        heroMap.put("SUP", Superhero.SUPERMAN);
        heroMap.put("MAR", Superhero.MARTIANMANHUNTER);
        heroMap.put("FLA", Superhero.FLASH);
    }

    public Superhero getHero(String key) {
        return heroMap.get(key);
    }

    public Set<String> getHeroAbbreviations() {
        return heroMap.keySet();
    }

    public String listHeroes() {
        return "BATMAN : EARTH: Superpower: MIND \n" +
                "SUPERMAN : KRYPTON: Superpower: STRENGHT \n" +
                "MARTIANMANHUNTER: MARS: Superpower: MIND \n" +
                "FLASH: OA: Superpower: SPEEDSTER";
    }

    public static Superhero battleHeroes(Superhero heroA, Superhero heroB) {
        Superpower powerA = heroA.getSuperpower();
        Superpower powerB = heroB.getSuperpower();
        if (powerA.effectiveAgainst() == powerB) {
            return heroA;
        } else if (powerB.effectiveAgainst() == powerA) {
            return heroB;
        } else {
            return null;
        }
    }
}