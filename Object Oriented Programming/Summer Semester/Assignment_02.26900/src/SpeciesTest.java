import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SpeciesTest {

    @Test
    public void testToString() {
        assertEquals("earth", Species.Earth.toString());
        assertEquals("krypton", Species.Krypton.toString());
        assertEquals("mars", Species.Mars.toString());
        assertEquals("oa", Species.OA.toString());
    }
}
