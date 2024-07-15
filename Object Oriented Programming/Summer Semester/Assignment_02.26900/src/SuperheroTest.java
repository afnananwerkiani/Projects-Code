import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SuperheroTest {

    @Test
    public void testGetSpecies() {
        assertEquals(Species.Earth, Superhero.BATMAN.getSpecies());
        assertEquals(Species.Krypton, Superhero.SUPERMAN.getSpecies());
        assertEquals(Species.Mars, Superhero.MARTIANMANHUNTER.getSpecies());
        assertEquals(Species.OA, Superhero.FLASH.getSpecies());
    }

    @Test
    public void testGetSuperpower() {
        assertEquals(Superpower.MIND, Superhero.BATMAN.getSuperpower());
        assertEquals(Superpower.STRENGTH, Superhero.SUPERMAN.getSuperpower());
        assertEquals(Superpower.MIND, Superhero.MARTIANMANHUNTER.getSuperpower());
        assertEquals(Superpower.SPEEDSTER, Superhero.FLASH.getSuperpower());
    }

    @Test
    public void testToString() {
        assertEquals("batman", Superhero.BATMAN.toString());
        assertEquals("superman", Superhero.SUPERMAN.toString());
        assertEquals("martianmanhunter", Superhero.MARTIANMANHUNTER.toString());
        assertEquals("flash", Superhero.FLASH.toString());
    }
}
