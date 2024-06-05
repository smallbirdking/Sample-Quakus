package org.acme.getting.started;

import org.acme.getting.started.entity.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@ApplicationScoped
public class UserService {
    private Map<String, User> users = Collections.synchronizedMap(new LinkedHashMap<>());

    {
        users.put("wang", new User("1", "wang", "123"));
        users.put("doussin", new User("2", "doussin", "123"));
    }

    public User register(User user) {
        // In a real-world application, you should handle password encryption
        users.put(user.getUsername(), user);
        return user;
    }

    public User login(String username, String password) {
        // In a real-world application, you should handle password verification
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User getUser(String username) {
        return users.get(username);
    }
}