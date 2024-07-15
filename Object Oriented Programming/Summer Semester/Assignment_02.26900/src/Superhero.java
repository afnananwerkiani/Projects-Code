public enum Superhero {
    BATMAN(new HeroInfo(Species.Earth, Superpower.MIND)),
    SUPERMAN(new HeroInfo(Species.Krypton, Superpower.STRENGTH)),
    MARTIANMANHUNTER(new HeroInfo(Species.Mars, Superpower.MIND)),
    FLASH(new HeroInfo(Species.OA, Superpower.SPEEDSTER));

    private HeroInfo info;

    private Superhero(HeroInfo info) {
        this.info = info;
    }

    public Species getSpecies() {
        return info.getSpecies();
    }

    public Superpower getSuperpower() {
        return info.getSuperpower();
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}