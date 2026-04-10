package payloadBuilder;

public class PayloadBuilder {

    public static String registerUser(String email, String password) {
        return "{\n" +
                "  \"firstName\": \"Test\",\n" +
                "  \"lastName\": \"User\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"confirmPassword\": \"" + password + "\",\n" +
                "  \"groupId\": \"1deae17a-c67a-4bb0-bdeb-df0fc9e2e526\"\n" +
                "}";
    }

    public static String login(String email, String password) {
        return "{\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}";
    }
}