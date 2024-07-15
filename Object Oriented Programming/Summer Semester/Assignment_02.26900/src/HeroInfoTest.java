import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class HeroInfoTest {

    @Test
    public void testGetSpecies() {
        HeroInfo heroInfo1 = new HeroInfo(Species.Earth, Superpower.MIND);
        HeroInfo heroInfo2 = new HeroInfo(Species.Krypton, Superpower.STRENGTH);

        assertEquals(Species.Earth, heroInfo1.getSpecies());
        assertEquals(Species.Krypton, heroInfo2.getSpecies());
    }

    @Test
    public void testGetSuperpower() {
        HeroInfo heroInfo1 = new HeroInfo(Species.Earth, Superpower.MIND);
        HeroInfo heroInfo2 = new HeroInfo(Species.Krypton, Superpower.STRENGTH);

        assertEquals(Superpower.MIND, heroInfo1.getSuperpower());
        assertEquals(Superpower.STRENGTH, heroInfo2.getSuperpower());
    }

    @Test
    public void testToString() {
        HeroInfo heroInfo1 = new HeroInfo(Species.Earth, Superpower.MIND);
        HeroInfo heroInfo2 = new HeroInfo(Species.Krypton, Superpower.STRENGTH);

        assertEquals("HeroInfo{species=earth, superpower=mind}", heroInfo1.toString());
        assertEquals("HeroInfo{species=krypton, superpower=strength}", heroInfo2.toString());
    }
}