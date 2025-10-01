package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("sandbox.user"),
                        PropertyReader.getProperty("sandbox.password"));
    }

    public static User withLockUserPermission() {
        return new User(PropertyReader.getProperty("sandbox.locked"),
                PropertyReader.getProperty("sandbox.password"));
    }

    public static User withEmptyUserPermission() {
        return new User(PropertyReader.getProperty("sandbox.empty_locked"),
                PropertyReader.getProperty("sandbox.password"));
    }

    public static User withEmptyPasswordPermission() {
        return new User(PropertyReader.getProperty("sandbox.user"),
                PropertyReader.getProperty("sandbox.empty_password"));
    }
}
