import java.util.HashMap;

public enum Superpower {
    MIND,
    STRENGTH,
    SPEEDSTER;

    private static HashMap<Superpower, Superpower> STRENGTH_MAP;

    static {
        STRENGTH_MAP = new HashMap<>();
    }

    public Superpower effectiveAgainst() {
        if (this == STRENGTH) {
            return Superpower.MIND;
        } else if (this == MIND) {
            return Superpower.SPEEDSTER;
        } else if (this == SPEEDSTER) {
            return Superpower.STRENGTH;
        } else {
            throw new UnsupportedOperationException("Undefined Superpower");
        }
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}