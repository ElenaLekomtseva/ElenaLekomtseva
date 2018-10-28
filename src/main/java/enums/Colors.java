package enums;

public enum Colors {

    RED("Red"),
    GREEN("Green"),
    BLUE("BLUE"),
    YELLOW("Yellow");

    private String value;

    Colors(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
