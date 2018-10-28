package enums;

public enum HomePageMenu {

    HOME(0, "Home"),
    CONTACT_FORM(1, "Contact form"),
    SERVICE(2, "Service"),
    METALS_AND_COLORS(3, "Metals & Colors");

    private int index;
    private String value;

    HomePageMenu(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
