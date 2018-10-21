package enums;

public enum Users {

    PITER_CHALOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String profileName;

    Users(String login, String password, String profileName) {
        this.login = login;
        this.password = password;
        this.profileName = profileName;
    }
}