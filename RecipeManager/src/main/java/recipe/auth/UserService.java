package recipe.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final File usersFile;
    private final Gson gson;

    public UserService() {
        this(new File("users.json"));
    }

    public UserService(File file) {
        this.usersFile = file;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public synchronized boolean register(String username, String password) {
        Map<String, String> users = loadUsers();
        if (users.containsKey(username)) return false;
        users.put(username, hash(password));
        persist(users);
        return true;
    }

    public synchronized boolean authenticate(String username, String password) {
        Map<String, String> users = loadUsers();
        String hash = users.get(username);
        return hash != null && hash.equals(hash(password));
    }

    private Map<String, String> loadUsers() {
        if (!usersFile.exists()) return new HashMap<>();
        try (Reader r = new InputStreamReader(new FileInputStream(usersFile), StandardCharsets.UTF_8)) {
            Type t = new TypeToken<Map<String, String>>(){}.getType();
            Map<String, String> m = gson.fromJson(r, t);
            return m != null ? m : new HashMap<>();
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load users: " + ex.getMessage(), ex);
        }
    }

    private void persist(Map<String, String> users) {
        try (Writer w = new OutputStreamWriter(new FileOutputStream(usersFile), StandardCharsets.UTF_8)) {
            gson.toJson(users, w);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to persist users: " + ex.getMessage(), ex);
        }
    }

    private String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No SHA-256", e);
        }
    }
}
