package pbe;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, String> users = new HashMap<>();
    private final Map<String, String> roles = new HashMap<>();

    public UserService() {
        users.put("admin", "admin123");
        users.put("operador", "operador123");
        users.put("visitante", "visitante123");

        roles.put("admin", "ROLE_ADMIN");
        roles.put("operador", "ROLE_OPERADOR");
        roles.put("visitante", "ROLE_VISITANTE");
    }

    public boolean validateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public String getUserRole(String username) {
        return roles.getOrDefault(username, "ROLE_GUEST");
    }
}