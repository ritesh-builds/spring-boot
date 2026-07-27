package in.strikes.service;

import in.strikes.model.User;

import java.util.*;

public class UserService {

    private Map<Integer, User> userDB;

    public UserService() {
        userDB = new HashMap<>();
    }

    public User createUser(User userReq) {
        userDB.put(userReq.getId(), userReq);
        return userReq;
    }

    public User getUserById(Integer id) {
        User user = userDB.getOrDefault(id, null);
        return user;
    }

    public List<User> getAllUsers() {
        return (List<User>) userDB.values();
    }
}
