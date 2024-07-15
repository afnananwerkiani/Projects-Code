import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperpowerTest {

    @Test
    public void testEffectiveAgainst() {
        assertEquals(Superpower.MIND, Superpower.STRENGTH.effectiveAgainst());
        assertEquals(Superpower.SPEEDSTER, Superpower.MIND.effectiveAgainst());
        assertEquals(Superpower.STRENGTH, Superpower.SPEEDSTER.effectiveAgainst());
    }

    @Test
    public void testToString() {
        assertEquals("mind", Superpower.MIND.toString());
        assertEquals("strength", Superpower.STRENGTH.toString());
        assertEquals("speedster", Superpower.SPEEDSTER.toString());
    }
}
