import java.util.ArrayList;

public class HeroInfo {
    //    ArrayList heroinfo=new ArrayList<>();
    private Species species;
    private Superpower superpower;

    public HeroInfo(Species species, Superpower superpower) {
        this.species = species;
        this.superpower = superpower;
    }

    public Species getSpecies() {
        return species;
    }

    public Superpower getSuperpower() {
        return superpower;
    }

    @Override
    public String toString() {
        return "HeroInfo{" +
                "species=" + species +
                ", superpower=" + superpower +
                '}';
    }
}