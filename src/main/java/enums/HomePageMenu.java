package enums;

public enum HomePageMenu {

    HOME(0, "Home", "Home Page"),
    CONTACT_FORM(1, "Contact form", "Contact Form"),
    SERVICE(2, "Service", "Service"),
    METALS_AND_COLORS(3, "Metals & Colors", "Metals and Colors");

    private int index;
    private String value;
    private String title;

    HomePageMenu(int index, String value, String title) {
        this.index = index;
        this.value = value;
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return value;
    }
}
