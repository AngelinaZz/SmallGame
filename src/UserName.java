public class UserName {
    private static String username;

    private UserName() {

    }

    public static String getInstance() {
        return username;
    }

    public static void setInstance(String name) {
        if (username == null) {
            username = name;
        }
    }
}
