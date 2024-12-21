package org.example.data;

import org.example.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserData {

    private final Set<User> userSet = new HashSet<>();

    public UserData() {
        userSet.add(new User("User 1"));
        userSet.add(new User("User 2"));
        userSet.add(new User("User 3"));
    }

    public Set<User> fetchUsers() {
        return userSet;
    }

    public void addUser(final String id) {
        userSet.add(new User(id));
    }
}
