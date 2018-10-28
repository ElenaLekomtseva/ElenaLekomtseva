package enums;

public enum Metals {

    GOLD(0, "Gols"),
    SILVER(1, "Silver"),
    BRONZE(2, "Bronze"),
    SELEN(3, "Selen");

    private int index;
    private String value;

    Metals(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return value;
    }
}
