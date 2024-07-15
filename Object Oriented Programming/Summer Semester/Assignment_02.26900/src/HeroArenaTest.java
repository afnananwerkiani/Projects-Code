import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class HeroArenaTest {

    @Test
    public void testGetHero() {
        HeroArena heroArena = new HeroArena();
        assertEquals(Superhero.BATMAN, heroArena.getHero("BAT"));
        assertEquals(Superhero.SUPERMAN, heroArena.getHero("SUP"));
        assertEquals(Superhero.MARTIANMANHUNTER, heroArena.getHero("MAR"));
        assertEquals(Superhero.FLASH, heroArena.getHero("FLA"));
        assertNull(heroArena.getHero("NONEXISTENT")); // Testing for a non-existent hero
    }

    @Test
    public void testGetHeroAbbreviations() {
        HeroArena heroArena = new HeroArena();
        assertEquals(4, heroArena.getHeroAbbreviations().size());
        assertTrue(heroArena.getHeroAbbreviations().contains("BAT"));
        assertTrue(heroArena.getHeroAbbreviations().contains("SUP"));
        assertTrue(heroArena.getHeroAbbreviations().contains("MAR"));
        assertTrue(heroArena.getHeroAbbreviations().contains("FLA"));
    }

    @Test
    public void testListHeroes() {
        HeroArena heroArena = new HeroArena();
        String expectedList = "BATMAN : EARTH: Superpower: MIND \n" +
                "SUPERMAN : KRYPTON: Superpower: STRENGHT \n" +
                "MARTIANMANHUNTER: MARS: Superpower: MIND \n" +
                "FLASH: OA: Superpower: SPEEDSTER";

        assertEquals(expectedList, heroArena.listHeroes());
    }

    @Test
    public void testBattleHeroes() {
        Superhero superman = Superhero.SUPERMAN;
        Superhero martianManhunter = Superhero.MARTIANMANHUNTER;
        Superhero batman= Superhero.BATMAN;
        Superhero flash= Superhero.FLASH;
        assertEquals(superman, HeroArena.battleHeroes(batman, superman));
        assertEquals(batman, HeroArena.battleHeroes(batman, flash));
        assertEquals (null, HeroArena.battleHeroes (batman, martianManhunter));
        assertEquals(flash, HeroArena.battleHeroes (superman, flash));
        assertEquals (superman, HeroArena.battleHeroes(superman, martianManhunter));
        assertEquals(martianManhunter, HeroArena.battleHeroes (martianManhunter, flash));
    }
}
