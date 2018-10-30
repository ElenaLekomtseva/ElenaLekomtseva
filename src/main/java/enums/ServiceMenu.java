package enums;

public enum ServiceMenu {

    SUPPORT(0, "Support", "Support"),
    DATES(1, "Dates", "Dates"),
    COMPLEX_TABLE(2, "Complex Table", "Complex Table"),
    SIMPLE_TABLE(3, "Simple Table", "Simple Table"),
    USER_TABLE(4, "User Table", "User Table"),
    TABLE_WITH_PAGES(5, "Table with pages", "Table with pages"),
    DIFFERENT_ELEMENTS(6, "Different elements", "Different Elements"),
    PERFORMANCE(7, "Performance", "Performance");

    private int index;
    private String value;
    private String title;

    ServiceMenu(int index, String value, String title) {
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
