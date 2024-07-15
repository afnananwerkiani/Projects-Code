public enum Species {
    Earth,
    Krypton,
    Mars,
    OA;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
