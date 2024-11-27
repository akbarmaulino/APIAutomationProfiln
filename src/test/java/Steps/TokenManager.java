package Steps;
import java.util.HashMap;
import java.util.Map;

public class TokenManager {
    private static final Map<String, String> tokens = new HashMap<>();

    public static void setToken(String key, String token) {
        tokens.put(key, token);
    }

    public static String getToken(String key) {
        return tokens.get(key);
    }

}
