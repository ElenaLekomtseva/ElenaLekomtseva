package enums;

public enum Vegetables {

    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    private String value;

    Vegetables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
