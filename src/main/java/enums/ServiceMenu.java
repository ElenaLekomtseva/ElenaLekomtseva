package enums;

public enum ServiceMenu {

    SUPPORT(0, "Support"),
    DATES(1, "Dates"),
    COMPLEX_TABLE(2, "Complex Table"),
    SIMPLE_TABLE(3, "Simple Table"),
    USER_TABLE(4, "User Table"),
    TABLE_WITH_PAGES(5, "Table with pages"),
    DIFFERENT_ELEMENTS(6, "Different elements"),
    PERFORMANCE(7, "Performance");

    private int index;
    private String value;

    ServiceMenu(int index, String value) {
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
