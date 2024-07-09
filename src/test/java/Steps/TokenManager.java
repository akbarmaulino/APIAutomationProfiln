package Steps;
import java.util.HashMap;
import java.util.Map;

public class TokenManager {
    private static Map<String, String> tokens = new HashMap<>();

    public static void setToken(String key, String token) {
        tokens.put(key, token);
    }

    public static String getToken(String key) {
        return tokens.get(key);
    }

    public static void clearToken(String key) {
        tokens.remove(key);
    }

    // Other methods as needed (refreshToken, checkTokenValidity, etc.)
}
